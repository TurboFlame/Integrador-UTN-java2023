import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.exceptions.CsvValidationException;
import java.util.ArrayList;
public class Integrador_1 {

	public static void main(String[] args) throws CsvValidationException, NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
	//el codigo "funciona", pero falta mucho para que sea entendible. Lo seguiré actualizando en dias proximos.				
		
	/*Por confusion mia al leer la consigna complique las cosas al hacer que el el programa calcule la probabilidad
	 * de victoria a partir del ranking fifa y saque el ganador de los partidos a partir de la diferencia de goles
	 * en lugar de hacer que sean datos otorgados automaticamente por el SCV.
	 * El proximo cambio que se hará es estandarizar las variables "placeholder" inicializadas y reducirlas al minimo 
	 * en lugar de plagar a lo largo de todo el codigo, ademas de simplificar el paso de variables.
	 * 
	 */
		

		
		equipo equipoGenerico=new equipo();
		Partido partidoGenerico = new Partido();
		List<equipo> equiposlist = equipoGenerico.crearEquiposAuto();
		List<Partido> partidoslist=new ArrayList<>();
		partidoslist=Partido.getPartidos();
		
		
		
		
		equipo equipoejemplo=equipoGenerico.getEquipo("Mexico", equiposlist);
		
	
		List<String> resultados=partidoGenerico.setGanadores(partidoslist);
		
		List<String> resultadosPredictivos=partidoGenerico.PartidosPredictivos();
		
		int resultado=partidoGenerico.comparacion(resultados, resultadosPredictivos);
				System.out.println("La puntuacion del programa de prediccion es " + resultado);
		
		

		
	

	   }

	}

