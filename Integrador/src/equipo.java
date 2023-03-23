
public class equipo{
	//Creador de equipos
	String País;
	int Puntaje=0;
	int PuntajeFIFA;
	            
	
	
	public static void Prediccion(equipo equipo1,equipo equipo2) {
	         //Metodo para comparar ranking de equipos y su winrate aproximado
     int difPuntaje=equipo1.PuntajeFIFA-equipo2.PuntajeFIFA;
//encuentro la diferencia de puntos y a partir de esta imprimo en consola
//la diferencia de habilidad entre equipos
     if (difPuntaje<=-200)
    	 System.out.println(equipo1.País + " tiene una muy baja probabilidad de ganar contra " + equipo2.País);
     else if (-200<difPuntaje && difPuntaje<=-100)
    	 System.out.println(equipo1.País + " tiene una desventaja considerable contra " + equipo2.País);
     else if(-100<difPuntaje && difPuntaje<0)
    	 System.out.println(equipo1.País + " tiene una ligera desventaja contra " + equipo2.País);
     else if(difPuntaje==0)
    	 System.out.println("Ambos equipos estan igualados");
     else if (difPuntaje>0 && difPuntaje<=100)
    	 System.out.println(equipo1.País + " tiene una ligera ventaja contra " + equipo2.País);
     else if (difPuntaje>100 && difPuntaje<=200)
    	 System.out.println(equipo1.País + " tiene una ventaja considerable contra " + equipo2.País);
     else if (difPuntaje>200)
    	 System.out.println(equipo1.País + " tiene una probabilidad muy alta de ganar contra " + equipo2.País);
    	 
    	 
    	 
    	 
    	 
    	 
    	 
	}





}

