package edificios;

import java.util.Map;
import java.util.TreeMap;

import personas.Individuo;

public class BloqueOficinas extends Edificio implements MoverteEntrePlantas {

	private int numeroDePlantas;
	private Map<Individuo,Integer> individuosPorPlanta = new TreeMap<>();
	
	public BloqueOficinas(String nombre, int anioConstruccion, int altura,int numeroDePlantas) {
		super(nombre,anioConstruccion,altura);
		this.numeroDePlantas = numeroDePlantas;		
	}

	private boolean siNoEstaEnElEdificio(Individuo persona) {
		if(!individuosPorPlanta.containsKey(persona))
			return true;
		return false;
	}
	
	@Override
	public void entrarEdificio(Individuo persona) {
		if(siNoEstaEnElEdificio(persona) && persona.isEstaEnElExterior()) {
			individuosPorPlanta.put(persona, 0);
			persona.setPuedeCorrer(false);
			persona.setEstaEnElExterior(false);
		}
	}

	@Override
	public void salirEdificio(Individuo persona) {
		if(! siNoEstaEnElEdificio(persona) && individuosPorPlanta.get(persona) == 0) {
			individuosPorPlanta.remove(persona);
			persona.setPuedeCorrer(true);
			persona.setEstaEnElExterior(true);
		}
	}
	

	
	@Override
	public void subirUnaPlantaPorEscalera(Individuo persona) {
		if(siNoEstaEnElEdificio(persona)) {
			return;
		}
		
		if(individuosPorPlanta.get(persona) == numeroDePlantas) {
			return;
		}
		
		individuosPorPlanta.put(persona, individuosPorPlanta.get(persona)+1);
		persona.setMetrosTotalesDesplazados(persona.getMetrosTotalesDesplazados() + 10);
	}

	@Override
	public void bajarUnaPlantaPorEscalera(Individuo persona) {
		if(siNoEstaEnElEdificio(persona)) {
			return;
		}
		if(individuosPorPlanta.get(persona) == 0) {
			return;
		}
		
		individuosPorPlanta.put(persona, individuosPorPlanta.get(persona)-1);
		persona.setMetrosTotalesDesplazados(persona.getMetrosTotalesDesplazados() + 10);
	}

	@Override
	public void usarAscensor(Individuo persona, int plantaDestino) {

		if(siNoEstaEnElEdificio(persona)) {
			return;
		}
		if(plantaDestino < 0 || plantaDestino > numeroDePlantas) {
			return;
		}
		individuosPorPlanta.put(persona, plantaDestino);
	}

	@Override
	public void saberEnQuePlantaEstaUnIndividuo(Individuo persona) {
		if(siNoEstaEnElEdificio(persona)) {
			System.out.printf("%s %s con dni: %s no se encuentra en el edificio.\n",
			persona.getNombre(),persona.getPrimerApellido(), persona.getDni());
		}else {
			System.out.printf("%s %s con dni: %s se encuentra en la planta %s.\n",
			persona.getNombre(),persona.getPrimerApellido(), persona.getDni(),individuosPorPlanta.get(persona));
		}
	}
	
	public  void saberQuienEstaEnUnaPlanta(Integer planta) {
		System.out.printf("Lista de personas que se encuentran en la planta: %d\n",planta);
		individuosPorPlanta.forEach((persona,plantaPersona)->{
			if(plantaPersona == planta) {
				System.out.printf("%s %s\n",persona.getNombre(),persona.getPrimerApellido());
			}
		});
	}
	
	
	public void reportBloqueOficinas() {

		if(individuosPorPlanta.isEmpty()) {
			System.out.println("El edificio está vacío.");
			return;
		}
		System.out.println("Las personas que se encuentran en el edificio son:");
		for(Map.Entry<Individuo,Integer> persona : individuosPorPlanta.entrySet()) {
			System.out.printf("%s en la planta %d.\n",persona.getKey().getNombre(),persona.getValue());
		}
	}
	
	
	@Override
	public String toString() {
		return String.format("%s\n"
				+ "Fue diseñado como bloque de oficinas y tiene %d plantas.", super.toString(),numeroDePlantas);
		
	}




	
	
	
}
