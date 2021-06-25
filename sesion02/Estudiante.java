package org.mp.sesion02;

public class Estudiante extends Persona{

	private int nivel;

	/**
	 * Contructor por defecto de la clase Estudiante
	 */
	public Estudiante() {
		super();
		this.nivel = 0;
	}
	
	/**
	 * Constructor por parametros de la clase estudiante
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @param nivel
	 */
	public Estudiante(String nombre, String direccion, String telefono, String email, int nivel) {
		super(nombre, direccion, telefono, email);
		this.nivel = nivel;
	}

	/**
	 * Getter
	 * @return nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Setter
	 * @param nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	
	/**
	 * Override del metodo toString para la clase Estudiante
	 */
	@Override
	public String toString() {
		
		String cadena = "";
		
		if(this.getNivel() == 1) {
			cadena += "Estudiante de Grado\n";
		}else if(this.getNivel() == 2) {
			cadena += "Estudiante de Máster\n";
		}else if(this.getNivel() == 3) {
			cadena += "Estudiante de Doctorado\n";
		}
		
		cadena += super.toString();
		
		return cadena;
	}

	
	
}
