package edificios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

import personas.Individuo;

public class Casino extends Edificio {

	private int edadMinimaAcceso;
	private List<Individuo> individuosEnElCasino = new ArrayList<>();

	public Casino(String nombre, int anioConstruccion,int metrosDeAltura,int edadMinimaAcceso) {
		super(nombre,anioConstruccion,metrosDeAltura);
		this.edadMinimaAcceso = edadMinimaAcceso;
	}

	@Override
	public void entrarEdificio(Individuo persona) {
		if(!individuosEnElCasino.contains(persona) && persona.isEstaEnElExterior()){
			Predicate<Integer> tieneEdadMinima = anio -> Calendar.getInstance().get(Calendar.YEAR) - anio >= edadMinimaAcceso;
			if(tieneEdadMinima.test(persona.getAnioNacimiento())) {
				individuosEnElCasino.add(persona);
				persona.setEstaEnElExterior(false);
				persona.setPuedeCorrer(false);
			}
		}
	}

	@Override
	public void salirEdificio(Individuo persona) {
		if(individuosEnElCasino.contains(persona)) {
			individuosEnElCasino.remove(persona);
			persona.setEstaEnElExterior(true);
			persona.setPuedeCorrer(true);
		}	
	}
	
	
	
	
	
	public void reportCasino() {

		if(individuosEnElCasino.isEmpty()) {
			System.out.println("El edificio está vacío.");
			return;
		}
		System.out.println("Las personas que se encuentran en el casino son:");
		for(Individuo persona : individuosEnElCasino) {
			System.out.printf("%s %s .\n",persona.getNombre(),persona.getPrimerApellido());
		}
	}

}
