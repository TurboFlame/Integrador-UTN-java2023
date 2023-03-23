
public class Integrador_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		equipo Argentina=new equipo();
		
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
		
		Argentina.Puntaje=0;
		
		ArabiaS.Puntaje=0;
				
		Mexico.Puntaje=0;
		
		Polonia.Puntaje=0;
				
				
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
		
		
		
		
		
		
		
	}

}





