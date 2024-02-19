package world;

import java.util.ArrayList;
import java.util.List;

import edificios.Edificio;

public class Planeta {

	private String nombre;
	private List<Edificio> edificiosDelPlaneta = new ArrayList<>();
	
	public Planeta(String nombre) {
		this.nombre = nombre;
	}
	
	public void añadirEdificioAlPlaneta(Edificio edificio) {
		edificiosDelPlaneta.add(edificio);
	}
	
	public void verEdificiosQueContieneElPlaneta() {
		for(Edificio edificio : edificiosDelPlaneta) {
			System.out.println(edificio);
			System.out.println();
		}
	}
}
