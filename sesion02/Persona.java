package org.mp.sesion02;

public class Persona {

	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	
	/**
	 * Contructor por defecto de la clase persona
	 */
	public Persona() {
		
		this.nombre = "";
		this.direccion = "";
		this.telefono = "";
		this.email = "";
	}
	
	/**
	 * Contructor por parametros de la clase persona
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param email
	 */
	public Persona(String nombre, String direccion, String telefono, String email) {

		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	
	/*
	 * Getter
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/*
	 * Setter
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Getter
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * Setter
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Getter
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Setter
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Getter 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Setter
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Override del metodos toString
	 */
	@Override
	public String toString() {
		return "Nombre = " + nombre + ", Dirección = " + direccion + ", Teléfono = " + telefono + ", email = " + email;
	}
	
	
}
