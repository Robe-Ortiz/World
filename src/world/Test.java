package world;

import edificios.BloqueOficinas;
import personas.Continente;
import personas.Individuo;

public class Test {

	
	public static void main(String[] args) {
		
		
		Individuo roberto = new Individuo("Roberto","Ortiz","López",Continente.EU,1993,47427250);				
		
		BloqueOficinas torrePegi = new BloqueOficinas("Torre Pegi", 2015, 210, 56);
		BloqueOficinas torreMapfre = new BloqueOficinas("Torre Mapfre", 1996, 120, 12);
		Planeta tierra = new Planeta("Tierra");
		
		tierra.añadirEdificioAlPlaneta(torreMapfre);
		tierra.añadirEdificioAlPlaneta(torrePegi);
		tierra.verEdificiosQueContieneElPlaneta();

	
	}
}
