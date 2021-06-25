package org.mp.sesion04;

import java.util.NoSuchElementException;

public class GenericJosephus<E> {

	private GenericQueue<E> cola = new GenericQueue<E>();
	private int k = 0;
	private int n = 0;

	/*
	 * Contructor por parametros de GenericGosephus
	 */
	public GenericJosephus(int k, int n, E[] objects) {
		this.k = k;
		this.n = n;
		if (objects != null) {
			for (int index = 0; index < objects.length; index++) {
				this.cola.enqueue(objects[index]);
			}
		}

	}

	/*
	 * Devulve el parametro cola del objeto
	 * 
	 * @return GenericQueue<E>
	 */
	public GenericQueue<E> getCola() {

		return this.cola;
	}

	/*
	 * Elimina en orden los valores de la cola del objeto de manera que se devuelve
	 * como resultado un String con la solucion de la eliminacion de Josephus
	 * 
	 * @param GenericQueue<E> cola
	 * 
	 * @return String
	 */
	public String ordenEliminar(GenericQueue<E> cola) {

		String devolver = "";

		if (this.n <= 1) {

			if (this.n == 0) {

				throw new NoSuchElementException("No hay ninguna persona");

			} else if (this.n == 1) {

				devolver += "Solo hay una persona";

			} else {

				devolver += "Evento no contemplado";
			}

		} else if (this.n > 1) {

			devolver += "Orden de eliminación: " + "\n";

			for (int index = 0; index < this.n; index++) {

				for (int index2 = 0; index2 < k; index2++) {

					if (index2 == this.k - 1) {

						devolver += "Debe morir " + this.getCola().dequeue() + "\n";
					} else {

						this.getCola().enqueue(this.getCola().dequeue());
					}
				}
			}

		} else {

			devolver += "Evento no contemplado";
		}

		return devolver;
	}

	/*
	 * Metodo que va a convertir a String el objeto GenericJosephus
	 * 
	 * @return String
	 */
	public String toString() {

		String cadena_a_devolver = "Problema de Josephus: ";

		cadena_a_devolver += "k=" + this.k + ", n=" + this.n + "\n" + this.getCola().toString();

		return cadena_a_devolver;
	}

}
