package org.mp.sesion04;

import java.util.Iterator;

import org.mp.sesion03.LinkedList;

public class SortedLinkedList<E extends Comparable<E>> extends LinkedList {

	/** Crea una SortedLinkedList enlazada por defecto */
	public SortedLinkedList() {
		super();
	}

	/** Crea una SortedLinkedList enlazada con parametros */
	public SortedLinkedList(Comparable<E>[] cadenas) {
		for (int i = 0; i < cadenas.length; i++) {
			addSorted(cadenas[i]);
		}
	}

	/**
	 * Añade un elemento a la cabeza de la lista
	 * 
	 * @param E o
	 */
	public void addFirst(E e) {

		throw new UnsupportedOperationException("No garantiza orden");
	}

	/**
	 * Añade un elemento al final de la lista
	 * 
	 * @param E o
	 */
	public void addLast(E e) {

		throw new UnsupportedOperationException("No garantiza orden");
	}

	public void add(E e) {

		throw new UnsupportedOperationException("No garantiza orden");
	}

	/**
	 * Añade el elemento e en la posición index. La posición del elemento head es
	 * 0
	 * 
	 * @param int index
	 * @param E   o
	 */
	public void add(int index, E o) {

		throw new UnsupportedOperationException("No garantiza orden");
	}

	/**
	 * Añade un elemento al comienzo de la lista
	 * 
	 * @param int index
	 * @param E   o
	 */
	public void addFirst(int index, E o) {

		throw new UnsupportedOperationException("No garantiza orden");
	}

	/**
	 * Sustituye el elemento de la posición especificada en la lista por el
	 * elemento especificado.
	 * 
	 * @param int index
	 * @param E   o
	 * @return E
	 */
	public E set(int index, E o) {

		throw new UnsupportedOperationException("No garantiza orden");
	}

	/**
	 * A�ade un elemento a la lista de manera ordenada
	 * 
	 * @param Comparable<E> e
	 */
	public void addSorted(Comparable<E> e) {

		if (super.isEmpty() || e.compareTo((E) super.getFirst()) <= 0) {

			super.addFirst((E) e);

		} else if (e.compareTo((E) super.getLast()) >= 0) {

			super.addLast(e);
		} else {

			Iterator iterador = super.iterator();

			E auxiliar = null;
			E auxiliar2 = null;
			int index = 1;
			boolean anhadido = false;

			auxiliar = (E) iterador.next();

			while (iterador.hasNext() && anhadido == false) {

				if (e.compareTo(auxiliar) >= 0 && e.compareTo(auxiliar = (E) iterador.next()) <= 0) {

					anhadido = true;
					super.add(index, e);
				}

				index++;
			}
		}
	}

	/**
	 * Convierte a String la lista
	 * 
	 * @return String
	 */
	public String toString() {

		return "Lista ordenada: " + super.toString();
	}

}
