import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import com.opencsv.exceptions.CsvValidationException;


public class equipo{
	//Creador de equipos
	String País;
	int Puntaje=0;
	int PuntajeFIFA;
    String grupo;
    String clave;
	            
	
	
	
	//con este metodo coloco todos los equipos en un hashmap desde la DB.
	static public LinkedHashMap<String, equipo> crearEquiposAuto()throws IOException, CsvValidationException, NumberFormatException, SQLException{
  
		LinkedHashMap<String, equipo> equipos=new LinkedHashMap<>();	
	 ResultSet rs=Conexion.getResultSet("equipos");
	 						
	 while (rs.next()) {
		 equipo NuevoEquipo=new equipo();
		 NuevoEquipo.País=rs.getString(2);
		 NuevoEquipo.PuntajeFIFA=rs.getInt(3);
		 NuevoEquipo.grupo=rs.getString(4);
		 NuevoEquipo.clave=rs.getString(1);
		 equipos.put(rs.getString(1),NuevoEquipo);
		 	
	 }
	 
	
	return equipos;
    }
	
	//Con este metodo imprimo los puntajes (Cantidad de veces que gano) de cada equipo
	static public void printPuntajeEquipos(LinkedHashMap<String,equipo> equiposHash) {
	
	for(equipo eEquipo:equiposHash.values()) {
	System.out.println("El puntaje de " + eEquipo.País + " es " + eEquipo.Puntaje);
	}
	
	}
	
	
	
	
	
	
	
	
	/*
	Metodo obsoleto tras el revamp del codigo utilizando HashMap en lugar de List
	
	
	Este metodo es basicamente un getter que compara el nombre del equipo con un String que se le provea y otorga el objeto que coincida.
	Lo utilizo ya que por el metodo usado para crear los array list no encontre la manera de llamar a los objetos
	individualmente de forma tradicional
	public static equipo getEquipo(String País,List<equipo> equipos){
	
	
		for (int i = 0; i < equipos.size(); i++) {
	equipo placeholder=equipos.get(i);
	if (País.equals(placeholder.País)) {
		//placeholder.PuntajeFIFA=equipos.get(i).PuntajeFIFA;
		
		
		return equipos.get(i);}

	
		 }
	return null;
}


	*/
	
	

     
     
   
    	 		
    	 
    	 
    	 
	}







