package org.mp.sesion02;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Empleado extends Persona{

	private String despacho;
	private double salario;
	private GregorianCalendar fecha_contratacion;
	
	/**
	 * Constructor por defecto de la clase Empleado
	 */
	public Empleado() {
		super();
		this.despacho = "";
		this.salario = 0.0;
		this.fecha_contratacion = null;
	}
	
	/**
	 * Constructor por parametros de la clase Empleado
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @param despacho
	 * @param salario
	 * @param fecha_contratacion
	 */
	public Empleado(String nombre, String direccion, String telefono, String email, String despacho, double salario, GregorianCalendar fecha_contratacion) {
		super(nombre, direccion, telefono, email);
		this.despacho = despacho;
		this.salario = salario;
		this.fecha_contratacion = fecha_contratacion;
	}

	/**
	 * Getter
	 * @return despacho
	 */
	public String getDespacho() {
		return despacho;
	}

	/**
	 * Setter
	 * @param despacho
	 */
	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

	/**
	 * Getter
	 * @return salario
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Setter
	 * @param salario
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * Getter
	 * @return fecha_contratacion
	 */
	public GregorianCalendar getFecha_contratación() {
		return fecha_contratacion;
	}

	/**
	 * Setter
	 * @param fecha_contratacion
	 */
	public void setFecha_contratación(GregorianCalendar fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
	}

	/**
	 * Override del metodo toString de la clase Empleado
	 */
	@Override
	public String toString() {
		
		String cadena = "";
		
		cadena += super.toString() + "\n";
		
		cadena += "Despacho = " + this.despacho + ", salario = " + (int) this.salario + ", Fecha de contrataciÃ³n = " + this.fecha_contratacion.get(Calendar.DATE) + "/" + (this.fecha_contratacion.get(Calendar.MONTH) + 1) + "/" + this.fecha_contratacion.get(Calendar.YEAR) + "\n";
		
		return cadena;
	}
	
	
}
