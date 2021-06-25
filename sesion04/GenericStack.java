package org.mp.sesion04;

import org.mp.sesion03.ArrayList;

public class GenericStack<E> {

	private ArrayList<E> lista = new ArrayList<E>(); // Siempre se olvida instanciar y
														// lanza la excepciÃ³n NullPointerException

	/*
	 * Devuelve el tamaño de la lista
	 * 
	 * @return int
	 */
	public int getSize() {
		return lista.size();
	}

	/*
	 * Delvuelve el ultimo elemento de la lista
	 * 
	 * @return E
	 */
	public E peek() {
		return lista.get(getSize() - 1);
	}

	/*
	 * Añade al final de la lista el elemento proporcionado
	 * 
	 * @params E o
	 */
	public void push(E o) {
		lista.add(o);
	}

	/*
	 * Elimina y devuelve el ultimo elemento de la lista
	 * 
	 * @return E o
	 */
	public E pop() {
		E o = lista.get(getSize() - 1);
		lista.remove(getSize() - 1);
		return o;
	}

	/*
	 * Metodo que nos dice si la lista esta vacia o no devolviendo un booleano
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	@Override
	/*
	 * Metodo que convierte en String la pila
	 * 
	 * @return String
	 */
	public String toString() {
		return "Pila: " + lista.toString();
	}

}
