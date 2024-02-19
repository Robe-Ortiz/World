package edificios;

import personas.Individuo;

public abstract class Edificio {
	private String nombre;
	private int anioConstruccion;
	private int metrosDeAltura;
	
	
	public Edificio(String nombre, int anioConstruccion, int metrosDeAltura) {
		this.nombre = nombre;
		this.anioConstruccion = anioConstruccion;
		this.metrosDeAltura = metrosDeAltura;
	}
	
	public abstract void entrarEdificio(Individuo persona);
	public abstract void salirEdificio(Individuo persona);
	
	@Override
	public String toString() {
		return String.format("Este edificio se llama %s fue construido en el año %d y tiene una altura de %d metros.",
				nombre,anioConstruccion,metrosDeAltura);
	}
	
}
