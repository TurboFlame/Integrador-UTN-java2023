import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import com.opencsv.exceptions.CsvValidationException;


public class Partido {
	
	String nombrePartido;
	int golesEquipo1;
	int golesEquipo2;
	String Equipo1;
	String Equipo2;
	String ganador;
	
	
	//Este metodo crea un HashMap de los partidos a partir de la DB
	public static LinkedHashMap<String, Partido> getPartidos() throws IOException, CsvValidationException, NumberFormatException, SQLException{
		 ResultSet rs=Conexion.getResultSet("partidos");
		 LinkedHashMap<String, Partido> Partidos=new LinkedHashMap<>();
		 
		 while (rs.next()) {
		 Partido nuevoPartido=new Partido();
		 nuevoPartido.Equipo1=rs.getString(1);
		 nuevoPartido.Equipo2=rs.getString(2);
		 nuevoPartido.golesEquipo1=rs.getInt(3);
		 nuevoPartido.golesEquipo2=rs.getInt(4);
		 nuevoPartido.nombrePartido=rs.getString(1)+" "+ rs.getString(2);
		 
		 Partidos.put(nuevoPartido.nombrePartido,nuevoPartido);
		 
		 }
		
		 return Partidos;
		 
		     }
			 
		
	
	//Este metodo setea los ganadores de cada partido a partir de la diferencia de goles
    static public List<String> setGanadores(LinkedHashMap<String,Partido> partidosHash,LinkedHashMap<String,equipo> equiposHash) {
    	 List<String> Ganadores = new ArrayList<String>();
    	 Ganadores.add("null");
    	 for (Partido ePartido : partidosHash.values()) {
    	 
    	        if (ePartido.golesEquipo1>ePartido.golesEquipo2) {
    	        	ePartido.ganador=ePartido.Equipo1;
    	        equiposHash.get(ePartido.Equipo1).Puntaje++;
    	        }
    	        if (ePartido.golesEquipo1<ePartido.golesEquipo2) {
    	        	ePartido.ganador=ePartido.Equipo2;
    		    equiposHash.get(ePartido.Equipo2).Puntaje++;
    		    } 
    	        if(ePartido.golesEquipo1==ePartido.golesEquipo2) {
    	        	ePartido.ganador="empate";
    		    }
           
           Ganadores.add(ePartido.ganador);
           
           }
      return Ganadores;
      }
     
    
     
     
//Este metodo sirve para dar un resultado predictivo de los partidos a partir del ranking fifa.
//Devuelve los ganadores en un array list en forma de Strings.
 	static public List<String> PartidosPredictivos() throws CsvValidationException, NumberFormatException, IOException, SQLException{
 		ArrayList<String> predicciones=new ArrayList<String>();
 		predicciones.add("la maquina");
 		
 		LinkedHashMap<String, equipo>  equiposHash = equipo.crearEquiposAuto();
 		LinkedHashMap<String, Partido> PartidosHash=Partido.getPartidos();
 	    for (Partido e : PartidosHash.values()) {
 	    	
 	        Partido partidoReferencia=e;
 	        	equipo primerEquipo;
 	            equipo segundoEquipo;
 	            primerEquipo=equiposHash.get(e.Equipo1);
 	            segundoEquipo=equiposHash.get(e.Equipo2);
 	   
 	            
 	            int difPuntos=primerEquipo.PuntajeFIFA-segundoEquipo.PuntajeFIFA;
 	            
 	            
 	       try {
 	        	   
 	        	   
 	            if (difPuntos<-100) {       
 	            	predicciones.add(partidoReferencia.Equipo2);
 	            }
 	            else if (difPuntos>100) {
 	            	predicciones.add(partidoReferencia.Equipo1);    	
 	            }
 	           else if ((difPuntos<100) && (difPuntos>-100)) {
 	        	   predicciones.add("empate");
 	                      }
     
 	                             }catch (Exception a) {System.out.println("Problema en diferenciacion de puntos");}
 	      
 	           }
 	   return predicciones;
 	}
 	
    



 	
 	/*Este metodo compara cada uno de los miembros del array list de predicciones y
 	de partidos jugados. Por cada caso en que el ganador del partido coincide con 
 	la prediccion, suma un punto a quien hizo la prediccion.*/
  static public void comparacion (List<String> resultados,List<String> predicciones) {
 	int puntuacion=0;
 	        for(int i=0;i<predicciones.size();i++) {
 	        	
 	        	if (resultados.get(i).equals(predicciones.get(i)))
 	        		puntuacion ++;
 	        }
 	       System.out.println("La puntuacion de " + predicciones.get(0) + " es de " + puntuacion);
       }
  
 
 	
  
  
  
  
  
}
  

