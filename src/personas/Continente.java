package personas;

public enum Continente {
EU("Europa"), AF("Africa"), AS("Asia"), OC("Oceanía"), AM("América");

	private final String nombre;
	
	private Continente(final String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}


}
