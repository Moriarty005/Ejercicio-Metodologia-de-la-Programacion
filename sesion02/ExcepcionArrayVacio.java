package org.mp.sesion02;

public class ExcepcionArrayVacio extends Exception{

	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param mensaje_excepcion
	 */
	public ExcepcionArrayVacio(String mensaje_excepcion) {
		
		super(mensaje_excepcion);
	}
}
