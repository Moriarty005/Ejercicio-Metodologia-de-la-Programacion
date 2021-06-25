package org.mp.sesion02;

import java.util.GregorianCalendar;

public class Administrativo extends Empleado{

	private String unidad_de_destino;

	/**
	 * Contructor por defecto de la clase Administrativo
	 */
	public Administrativo() {
		super();
		this.unidad_de_destino = "";
	}
	
	/**
	 * Contructor por parametros de la clase Administrativo
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @param despacho
	 * @param salario
	 * @param fecha_contratacion
	 * @param unidad_de_destino
	 */
	public Administrativo(String nombre, String direccion, String telefono, String email, String despacho, double salario, GregorianCalendar fecha_contratacion, String unidad_de_destino) {
		super(nombre, direccion, telefono, email, despacho, salario, fecha_contratacion);
		this.unidad_de_destino = unidad_de_destino;
	}

	/**
	 * Getter
	 * @return unidad_de_destino
	 */
	public String getUnidad_de_destino() {
		return unidad_de_destino;
	}

	/**
	 * Setter
	 * @param unidad_de_destino
	 */
	public void setUnidad_de_destino(String unidad_de_destino) {
		this.unidad_de_destino = unidad_de_destino;
	}

	/**
	 * Override del metodo toString de la clase Administrativo
	 */
	@Override
	public String toString() {
		String cadena = "";
		
		cadena = "Administrativo\n";
		
		cadena += super.toString();
		cadena += "Destinado en la unidad " + this.unidad_de_destino;
		
		return cadena;
	}
	
	
}
