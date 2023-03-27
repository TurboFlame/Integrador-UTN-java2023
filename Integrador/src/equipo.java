import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class equipo{
	//Creador de equipos
	String País;
	int Puntaje=0;
	int PuntajeFIFA;

	            
	
	
	
	//con este metodo coloco todos los equipos en un array list.
	public List<equipo> crearEquiposAuto()throws IOException, CsvValidationException, NumberFormatException{
    String direccion=("D:\\Repositorios\\Integrador-UTN-java2023\\Integrador\\ExcelEquipos.csv");
	List<equipo> equipos=new ArrayList<>();
	FileReader ArchivoCSV = new FileReader(direccion);
	 @SuppressWarnings("resource")
	CSVReader ArchivoCSVLeido = new CSVReader(ArchivoCSV);
	 
	 String[] FilaActual;
	 while ((FilaActual=ArchivoCSVLeido.readNext())!=null) {
		 equipo NuevoEquipo=new equipo();
		 NuevoEquipo.País=FilaActual[1];
		 NuevoEquipo.PuntajeFIFA=Integer.parseInt(FilaActual[3]);
		 equipos.add(NuevoEquipo);
		 
	 }
	 
	
	return equipos;
    }
	
	
	/*para continuar mañana, tengo que hacer un getter que a partir de un atributo del objeto (pais en este caso) me otorgue el objeto trabajado para poder llamar 
	al pais luego. Tambien tengo que hacer una clase de Partidos predictivos, puedo hacer que en cada if ddel metodo prediccion me devuelva el dato de si empato, perdio o gano
	segun la prediccion, y por ultimo crear la clase de Partidos terminados que registre desde un CSV los partidos jugados, y terminar con un metodo que compare los partidos predictivos con los jugados
	y puntue segun la prediccion obtenida.
	*/
	
	
	//Este metodo es basicamente un getter que compara el nombre del equipo con un String que se le provea y otorga el objeto que coincida.
	//Lo utilizo ya que por el metodo usado para crear los array list no encontre la manera de llamar a los objetos
	//individualmente de forma tradicional
	public static equipo getEquipo(String País,List<equipo> equipos){
	
	
		for (int i = 0; i < equipos.size(); i++) {
	equipo placeholder=equipos.get(i);
	if (País.equals(placeholder.País)) {
		//placeholder.PuntajeFIFA=equipos.get(i).PuntajeFIFA;
		
		
		return equipos.get(i);}

	
		 }
	return null;
}
	
	
	
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

