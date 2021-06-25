package org.mp.sesion02;

import java.util.GregorianCalendar;

public abstract class ObjectoGeometrico{

	public String color = "";
	public boolean relleno = false;
	public GregorianCalendar fechaCreado = null;

	
	
	public ObjectoGeometrico(String color, boolean relleno) {
		super();
		this.color = color;
		this.relleno = relleno;
		this.fechaCreado = new GregorianCalendar();
	}

	/**
	 * Description of the method esRelleno.
	 * @return 
	 */
	public boolean esRelleno() {

		return this.relleno;
	}

	/**
	 * Description of the method toString.
	 * @return 
	 */
	public String toString() {

		String cadena = "Creado el " + this.fechaCreado + "\nColor: " + this.color + " y relleno: " + this.relleno;
		
		return cadena;
	}
	
	/**
	 * Getter
	 * @return color 
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Setter
	 * @param newColor 
	 */
	public void setColor(String newColor) {
		this.color = newColor;
	}

	/**
	 * Getter
	 * @return relleno 
	 */
	public boolean getRelleno() {
		return this.relleno;
	}

	/**
	 * Setter
	 * @param newRelleno 
	 */
	public void setRelleno(boolean newRelleno) {
		this.relleno = newRelleno;
	}

	/**
	 * Getter
	 * @return fechaCreado 
	 */
	public GregorianCalendar getFechaCreado() {
		return this.fechaCreado;
	}

	/**
	 * Setter
	 * @param newFechaCreado 
	 */
	public void setFechaCreado(GregorianCalendar newFechaCreado) {
		this.fechaCreado = newFechaCreado;
	}

	abstract double getPerimetro();

	abstract double getArea();
	
	

}
