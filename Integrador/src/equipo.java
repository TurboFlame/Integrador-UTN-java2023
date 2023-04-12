import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class equipo{
	//Creador de equipos
	String País;
	int Puntaje=0;
	int PuntajeFIFA;
    String grupo;
    String clave;
	            
	
	
	
	//con este metodo coloco todos los equipos en un array list.
	public HashMap<String, equipo> crearEquiposAuto()throws IOException, CsvValidationException, NumberFormatException{
    String direccion=("D:\\Repositorios\\Integrador-UTN-java2023\\Integrador\\ExcelEquipos.csv");
    HashMap<String, equipo> equipos	 = new HashMap<>();
	FileReader ArchivoCSV = new FileReader(direccion);
	 @SuppressWarnings("resource")
	CSVReader ArchivoCSVLeido = new CSVReader(ArchivoCSV);
	 
	 String[] FilaActual;							
	 while ((FilaActual=ArchivoCSVLeido.readNext())!=null) {
		 equipo NuevoEquipo=new equipo();
		 NuevoEquipo.País=FilaActual[1];
		 NuevoEquipo.PuntajeFIFA=Integer.parseInt(FilaActual[3]);
		 NuevoEquipo.grupo=FilaActual[2];
		 NuevoEquipo.clave=FilaActual[0];
		 equipos.put(FilaActual[0],NuevoEquipo);
		 	
	 }
	 
	
	return equipos;
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
	
	
	//este metodo fue un "prototipo" del metodo de prediccion. Lo mantengo disponible ya que
	//resulta util para algunos testeos
	public static void Prediccion(equipo equipo1,equipo equipo2) {
	         
     int difPuntaje=equipo1.PuntajeFIFA-equipo2.PuntajeFIFA;

     if (100<=difPuntaje)
    	 System.out.println(equipo1.País + " gana a " + equipo2.País);
     else if ((difPuntaje>-100) && (difPuntaje<100))
    	 System.out.println(equipo1.País + " empata a " + equipo2.País);
     else if(difPuntaje<=-100)
    	 System.out.println(equipo1.País + " pierde contra " + equipo2.País);
     
     
     
     
     
     
     
     
     
  /*   else if(difPuntaje==0)
    	 System.out.println("Ambos equipos estan igualados");
     else if (difPuntaje>0 && difPuntaje<=100)
    	 System.out.println(equipo1.País + " tiene una ligera ventaja contra " + equipo2.País);
     else if (difPuntaje>100 && difPuntaje<=200)
    	 System.out.println(equipo1.País + " tiene una ventaja considerable contra " + equipo2.País);
     else if (difPuntaje>200)
    	 System.out.println(equipo1.País + " tiene una probabilidad muy alta de ganar contra " + equipo2.País);
    	 
    	 */
    	 
    	 		
    	 
    	 
    	 
	}





}

