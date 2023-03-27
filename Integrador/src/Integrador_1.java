import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;
import java.util.ArrayList;
public class Integrador_1 {

	public static void main(String[] args) throws CsvValidationException, NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
		
		
		
		
		
		
		
		
		
		
		
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		Argentina.País=("Argentina");
		equipo ArabiaS=new equipo();
		
		ArabiaS.País=("Arabia Saudita");
		equipo Mexico=new equipo();
		
		Mexico.País=("México");
		equipo Polonia=new equipo();
		
		Polonia.País=("Polonia");
		Argentina.PuntajeFIFA=1773; 
		
		ArabiaS.PuntajeFIFA=1437;
				
		Mexico.PuntajeFIFA=1644;		
		
		Polonia.PuntajeFIFA=1548;
		
				
				
		grupo grupoA=new grupo();
		
		grupo grupoB=new grupo();
		
		grupo grupoC=new grupo();
		
		grupo grupoD=new grupo();
		
		grupo grupoE=new grupo();
		
		grupo grupoF=new grupo();
		
		grupo grupoG=new grupo();
		
		grupo grupoH=new grupo();
		
		
		
		
		equipo[] equiposC={Argentina,Polonia,Mexico,ArabiaS};
		
		grupoC.equipos=equiposC;
		
		
		int SumPFIFA=grupoC.getSumPFIFA();
		
		
		System.out.println(SumPFIFA);
		
		
		equipo.Prediccion(Mexico, Polonia);
		*/
		
		
		
		/*
		Partido partidoGenerico=new Partido();
		List<Partido> partidoslist=partidoGenerico.getPartidos();
		partidoGenerico.setGanadores(partidoslist);
		
		Partido nuevoPartido=Partido.getPartido("ArabiaS-Mexico", partidoslist);
		Partido Partidoprueba=Partido.getPartido("Argentina-Polonia", partidoslist);
		
         equipo equipoGenerico=new equipo();
         equipoGenerico.País="PaísGenerico";
        		List<equipo> equipos=equipoGenerico.crearEquiposAuto();         
        		
        		List<String> resultadosPredi=partidoGenerico.PartidosPredictivos();
        		List<String> resultados*/
        		
        		
		
	}

}





