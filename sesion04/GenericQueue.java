package org.mp.sesion04;

import org.mp.sesion03.LinkedList;

public class GenericQueue<E> {

	private LinkedList<E> lista = new LinkedList<E>(); // No olvidar new

	/*
	 * Encola o añade al final de la lista el elemento proporcionado
	 * 
	 * @params E e
	 */
	public void enqueue(E e) {
		lista.addLast(e);
	}

	/*
	 * Elimina de la lista el primer elemento y lo devuelve
	 * 
	 * @return E
	 */
	public E dequeue() {
		return lista.removeFirst();
	}

	/*
	 * Devuelve el tamanio de la lista
	 * 
	 * @return int
	 */
	public int getSize() {
		return lista.size();
	}

	@Override
	/*
	 * Convierte en String la lista
	 * 
	 * @return String
	 */
	public String toString() {
		return "Cola: " + lista.toString();
	}

}
