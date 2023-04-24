import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import com.opencsv.exceptions.CsvValidationException;
import java.sql.*;
public class Integrador_1 {

	
	
	
	public static void main(String[] args) throws CsvValidationException, NumberFormatException, IOException, SQLException {
		// TODO Auto-generated method stub

	
		LinkedHashMap<String,Partido> partidosHash=new LinkedHashMap<String,Partido>();
		partidosHash=Partido.getPartidos();
		LinkedHashMap<String,equipo> equiposHash=new LinkedHashMap<String,equipo>();
	    equiposHash=equipo.crearEquiposAuto();
	    
	    
	    
		List<String> resultados=Partido.setGanadores(partidosHash,equiposHash);
		List<String> resultadosPredictivos=Partido.PartidosPredictivos();
		
		Partido.comparacion(resultados, resultadosPredictivos);
		
		
		equipo.printPuntajeEquipos(equiposHash);
		
		
		
		ResultSet rs=Conexion.getResultSet("predicciones");
         
		
		/*Loop que itera sobre cada prediccion de los usuarios y compara los resultados
		  predictivos con el partido real. Tambien da una puntuacion a los usuarios dependiendo
		 su prediccion*/
		while(rs.next()){
			List<String> prediccionesUsuario=new ArrayList<String>();
			
            prediccionesUsuario.add(rs.getString(1));
            
            for (int i=2;i<=rs.getMetaData().getColumnCount();i++) {
            prediccionesUsuario.add(rs.getString(i)); 
                          }  
            
            Partido.comparacion(resultados, prediccionesUsuario);
		       }
		}

	}

