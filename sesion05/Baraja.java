package org.mp.sesion05;

import java.util.Random;

public class Baraja {

	private String nombreBaraja;
	private Carta[] cartas;

	/**
	 * Contructor por parámetros
	 * 
	 * @param nombreBaraja
	 * @param cartas
	 */
	public Baraja(String nombreBaraja, Carta[] cartas) {
		super();
		this.nombreBaraja = nombreBaraja;
		this.cartas = cartas;
	}

	/**
	 * Getter
	 * 
	 * @return nombreBaraja
	 */
	public String getNombreBaraja() {
		return nombreBaraja;
	}

	/**
	 * Setter
	 * 
	 * @param nombreBaraja
	 */
	public void setNombreBaraja(String nombreBaraja) {
		this.nombreBaraja = nombreBaraja;
	}

	/**
	 * Getter
	 * 
	 * @return cartas
	 */
	public Carta[] getCartas() {
		return cartas;
	}

	/**
	 * Setter
	 * 
	 * @param cartas
	 */
	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}

	/**
	 * Método que va a ordenar mediante inserción las cartas del array pasado
	 * 
	 * @param cartas
	 */
	public void insercion(Carta[] cartas) {

		int index, index2;
		Carta aux;

		for (index = 1; index < cartas.length; index++) {
			
			aux = cartas[index]; 
			index2 = index - 1;
			
			while ((index2 >= 0) && cartas[index2].getValor() > aux.getValor()) {
				
				cartas[index2 + 1] = cartas[index2--];
			}
			cartas[index2 + 1] = aux;
		}

		//Cuando termina de ordenar se asigna la lista ordenada al array de cartas del objeto
		this.setCartas(cartas);
	}
}
