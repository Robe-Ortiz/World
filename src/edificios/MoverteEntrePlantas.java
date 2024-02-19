package edificios;

import personas.Individuo;

public interface MoverteEntrePlantas {

	public void subirUnaPlantaPorEscalera(Individuo persona);
	public void bajarUnaPlantaPorEscalera(Individuo persona);
	public void usarAscensor(Individuo persona,int plantaDestino);
	public void saberEnQuePlantaEstaUnIndividuo(Individuo persona);
}
