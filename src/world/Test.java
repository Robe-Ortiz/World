package world;

import java.util.Calendar;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import edificios.BloqueOficinas;
import edificios.Casino;
import personas.Continente;
import personas.Individuo;

public class Test {

	
	public static void main(String[] args) {
		
		
		Individuo roberto = new Individuo("Roberto","Ortiz","López",Continente.EU,1993,47427250);
		Individuo fabio = new Individuo("Fabio","Reséndiz","Vergara",Continente.AM,1993,87965415);	
		
		BloqueOficinas torrePegi = new BloqueOficinas("Torre Pegi", 2015, 210, 56);
		BloqueOficinas torreMapfre = new BloqueOficinas("Torre Mapfre", 1996, 120, 12);
		Planeta tierra = new Planeta("Tierra");
		
		Casino casino1 = new Casino("Casino el indio",1950,8,30);
		
		
		tierra.añadirEdificioAlPlaneta(torreMapfre);
		tierra.añadirEdificioAlPlaneta(torrePegi);
		tierra.añadirEdificioAlPlaneta(casino1);
		//tierra.verEdificiosQueContieneElPlaneta();
		
		casino1.entrarEdificio(roberto);
		torrePegi.entrarEdificio(roberto);
		
		/*
		torrePegi.usarAscensor(roberto, 2);
		torrePegi.entrarEdificio(fabio);
		torrePegi.subirUnaPlantaPorEscalera(fabio);
		torrePegi.bajarUnaPlantaPorEscalera(roberto);
		torrePegi.bajarUnaPlantaPorEscalera(roberto);
		*/

		//torrePegi.reportBloqueOficinas();
		//torrePegi.saberEnQuePlantaEstaUnIndividuo(roberto);
		
		casino1.reportCasino();
		torrePegi.saberQuienEstaEnUnaPlanta(0);
	}
}
