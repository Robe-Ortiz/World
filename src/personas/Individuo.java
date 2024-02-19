package personas;

import java.util.Calendar;
import java.util.Objects;

public class Individuo implements Movimiento, Comparable<Individuo>{

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Continente continenteDeOrigen;
	private int metrosTotalesDesplazados;
	private Integer anioNacimiento;
	private String dni;
	private boolean puedeCorrer;

	public Individuo(String nombre, String primerApellido,String segundoApellido, Continente continenteDeOrigen, Integer anioNacimiento,Integer dniSinLetra) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.continenteDeOrigen = continenteDeOrigen;
		this.anioNacimiento = comprobarAnioNacimiento(anioNacimiento);
		this.dni = asignarLetraDni(dniSinLetra);
		metrosTotalesDesplazados = 0;
		this.puedeCorrer = true;
	}

	
	
	public String getNombre() {
		return nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public String getDni() {
		return dni;
	}
	public int getMetrosTotalesDesplazados() {
		return metrosTotalesDesplazados;
	}
	public void setMetrosTotalesDesplazados(int metrosTotalesDesplazados) {
		this.metrosTotalesDesplazados = metrosTotalesDesplazados;
	}
	public void setPuedeCorrer(boolean puedeCorrer) {
		this.puedeCorrer = puedeCorrer;
	}



	private Integer comprobarAnioNacimiento(Integer anioNacimiento) {
		Calendar calendario = Calendar.getInstance();
		int anioActual = calendario.get(Calendar.YEAR);
		if(anioNacimiento < 1900 || anioNacimiento > anioActual){
			return null;
		}
		return anioNacimiento;
	}
	
	private String asignarLetraDni(Integer dni) {
		String numerosDni = Integer.toString(dni);
		if(numerosDni.length() != 8) {return null;}
		
		String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
		int sumaNumerosDni = 0;
		for(int i = 0;i<numerosDni.length();i++) {
			sumaNumerosDni += Character.getNumericValue(numerosDni.charAt(i));
		}
		int resto = sumaNumerosDni % 23;
		char letraDni = 0;
		for(int i = 0; i<letrasDni.length() ;i++) {
			if(i == resto) {
				letraDni = letrasDni.charAt(i);
			}
		}
		String dniFinal = numerosDni + letraDni;
		return dniFinal;
	}

	@Override
	public String toString() {
		return String.format("Mi nombre es %s %s %s nací en %s%s%s y mi DNI es %s.",
				nombre,primerApellido,segundoApellido,this.continenteDeOrigen.getNombre(),
				anioNacimiento==null?"":" en el año ",anioNacimiento==null?"":anioNacimiento,dni);
	}

	@Override
	public void andar() {
		metrosTotalesDesplazados += 5;
		
	}

	@Override
	public void correr() {
		if(puedeCorrer)
			metrosTotalesDesplazados += 500;
                else
                        andar();
		
	}
	
	public void comprobarDistanciaRecorrida(){
		System.out.printf("Actualmente %s %s lleva recorrida una distancia de %s metros.\n",nombre,primerApellido,metrosTotalesDesplazados);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Individuo other = (Individuo) obj;
		return Objects.equals(dni, other.dni);
	}


	@Override
	public int compareTo(Individuo persona) {		
		return this.anioNacimiento - persona.anioNacimiento;
	}
	
	
	
}
