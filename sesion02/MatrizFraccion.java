package org.mp.sesion02;

import org.mp.sesion02.Fraccion;

/**
 * Clase que trabaja con matrices las cuales tienen cada casilla con una Fraccion
 * 
 * @author lolac
 */
public class MatrizFraccion extends MatrizGenerica<Fraccion> {

	/**
	 * Constructor
	 */
	public MatrizFraccion() {
		
		super();
	}
	
	@Override
	protected Fraccion sumar(Fraccion f1, Fraccion f2) {

		System.out.println("Valor de f1: " + f1);
		
		Fraccion devolver = f1.sumar(f2);
		
		return devolver;
	}
	
	@Override
	protected Fraccion multiplicar(Fraccion f1, Fraccion f2) {

		Fraccion devolver = f1.multiplicar(f2);
		
		return devolver;
	}

	protected Fraccion cero() {

		return new Fraccion();
	}

}
