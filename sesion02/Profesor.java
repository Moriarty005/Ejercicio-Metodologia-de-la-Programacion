package org.mp.sesion02;

import java.util.GregorianCalendar;

public class Profesor extends Empleado{

	private String horario_tutorias;
	private int categoria;
	
	/**
	 * Contructor por defecto de la clase Profesor
	 */
	public Profesor() {
		super();
		this.horario_tutorias = "";
		this.categoria = 0;
	}
	
	/**
	 * Constructor por parametros de la clase Profesor
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @param despacho
	 * @param salario
	 * @param fecha_contratacion
	 * @param horario_tutorias
	 * @param categoria
	 */
	public Profesor(String nombre, String direccion, String telefono, String email, String despacho, double salario, GregorianCalendar fecha_contratacion, String horario_tutorias, int categoria) {
		super(nombre, direccion, telefono, email, despacho, salario, fecha_contratacion);
		this.horario_tutorias = horario_tutorias;
		this.categoria = categoria;
	}

	/**
	 * Getter 
	 * @return horario_tutorias
	 */
	public String getHorario_tutorias() {
		return horario_tutorias;
	}

	/**
	 * Setter
	 * @param horario_tutorias
	 */
	public void setHorario_tutorias(String horario_tutorias) {
		this.horario_tutorias = horario_tutorias;
	}

	/**
	 * Getter
	 * @return categoria
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * Setter
	 * @param categoria
	 */
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	/**
	 * Override del metodo toString de la clase Profesor
	 */
	@Override
	public String toString() {
		
		
		String cadena = "";
		
		if(categoria == 1) {
			cadena = "Profesor Ayudante\n";
		}else if(categoria == 2) {
			cadena = "Profesor Titular de Universidad\n";
		}else if(categoria == 3){
			cadena = "Profesor Catedrático de Universidad\n";
		}
		
		cadena += super.toString();
		cadena += "Horario = " + this.horario_tutorias;
		
		return cadena;
	}
	
	
	
}
