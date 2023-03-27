import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class Partido {
	
	String nombrePartido;
	int golesEquipo1;
	int golesEquipo2;
	String Equipo1;
	String Equipo2;
	String ganador;
	
	
	
	public static List<Partido> getPartidos() throws IOException, CsvValidationException, NumberFormatException{
		
		String direccion2=("D:\\Repositorios\\Integrador-UTN-java2023\\Integrador\\ExcelPartidos.csv");
		FileReader ArchivoCSV2 = new FileReader(direccion2);
		 CSVReader ArchivoCSVLeido2 = new CSVReader(ArchivoCSV2);
		 List<Partido> Partidos=new ArrayList<>();
		 String[] FilaActual2;
		 while ((FilaActual2=ArchivoCSVLeido2.readNext())!=null) {
			 Partido nuevoPartido=new Partido();
			 nuevoPartido.nombrePartido=(FilaActual2[0]) + "-" + FilaActual2[1];
			 nuevoPartido.golesEquipo1=Integer.parseInt(FilaActual2[2]);
			nuevoPartido.golesEquipo2=Integer.parseInt(FilaActual2[3]);
			
           
             nuevoPartido.Equipo1=FilaActual2[0];
			 nuevoPartido.Equipo2=FilaActual2[1];
			 
			
			 Partidos.add(nuevoPartido);
		     }
			 return Partidos;
			 
	    }	
	public static Partido getPartido (String nombreEstePartido,List<Partido> partidosList) {
	for (int i=0;i<partidosList.size();i++) {
	         Partido partidoPlaceholder=partidosList.get(i);
	         if(nombreEstePartido.equals(partidoPlaceholder.nombrePartido)) {
	        		 return partidoPlaceholder;
	       
		
	         }
	       }
	return null;
	}
     public List<String> setGanadores(List<Partido> partidosList) {
    	 List<String> Ganadores = new ArrayList<String>();
      for (int i=0;i<(partidosList.size());i++){
    	  
    	  Partido partidoPlaceholder=partidosList.get(i);
    	  
    	        if (partidoPlaceholder.golesEquipo1>partidoPlaceholder.golesEquipo2) {
    	        partidoPlaceholder.ganador=partidoPlaceholder.Equipo1;}
    	        if (partidoPlaceholder.golesEquipo1<partidoPlaceholder.golesEquipo2) {
    		    partidoPlaceholder.ganador=partidoPlaceholder.Equipo2;}
    	        if(partidoPlaceholder.golesEquipo1==partidoPlaceholder.golesEquipo2) {
    		    partidoPlaceholder.ganador="empate";}
 
           Ganadores.add(partidoPlaceholder.ganador);
           
           }
      return Ganadores;
      }
     
     
     
     
     

 	public List<String> PartidosPredictivos() throws CsvValidationException, NumberFormatException, IOException{
 		ArrayList<String> predicciones=new ArrayList<String>();
 		equipo EquipoGenerico=new equipo();
 		
 		List<equipo> equiposlist = EquipoGenerico.crearEquiposAuto();
 	    Partido partidoPlaceholder = null;
 	      List<Partido> Partidos=partidoPlaceholder.getPartidos();
 	    for (int i=0;i<Partidos.size();i++) {
 	    	
 	        Partido partidoReferencia=Partidos.get(i);
 	        	equipo primerEquipo;
 	            equipo segundoEquipo;
 	            primerEquipo=equipo.getEquipo(partidoReferencia.Equipo1, equiposlist);
 	            segundoEquipo=equipo.getEquipo(partidoReferencia.Equipo2, equiposlist);
 	            
 	           // System.out.println(primerEquipo.PuntajeFIFA);
 	          //  System.out.println(segundoEquipo.PuntajeFIFA);
 	            
 	            
 	            int difPuntos=primerEquipo.PuntajeFIFA-segundoEquipo.PuntajeFIFA;
 	           
 	            if (difPuntos<-100)
 	            	predicciones.add(partidoReferencia.Equipo2);
 	            else if (difPuntos>100)
 	            	predicciones.add(partidoReferencia.Equipo1);
 	           else if ((difPuntos<100) && (difPuntos>-100))
 	        	   predicciones.add("empate");
 	           else{
 	           // System.out.println("hola");
 	            predicciones.add("null");
 	            System.out.println("aca paso algo raro");
 	            }
 	      }
 	   return predicciones;
 	}
 	
    



 	
 	
  public int comparacion (List<String> resultados,List<String> predicciones) {
 	int puntuacion=0;
 	        for(int i=0;i<predicciones.size();i++) {
 	        	
 	        	if (resultados.get(i).equals(predicciones.get(i)))
 	        		puntuacion ++;
 	        }
 	       return puntuacion;
       }
 	
 	
 	
}
