package org.mp.examenmayo.p1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> extends AbstractList<E> {

	private static final int CAPACIDAD_INICIAL = 16;

	private E[] data = (E[]) new Object[CAPACIDAD_INICIAL];

	/** Create a default list */
	public ArrayList() {
	}

	/** Create a list from an array of objects */
	public ArrayList(E[] objects) {

		for (int i = 0; i < objects.length; i++)
			add(objects[i]); // Warning: don't use super(objects)!

	}

	@Override /** Add a new element at the specified index */
	public void add(int index, E e) {
		ensureCapacity();
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
	

		// Move the elements to the right after the specified index
		for (int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];

		// Insert new element to data[index]
		data[index] = e;

		// Increase size by 1
		size++;
	}

	/** Create a new larger array, double the current size + 1 */
	
	private void ensureCapacity() {
		if (size == data.length) {
			E[] newData = (E[]) (new Object[size * 2 + 1]);
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	@Override /** Clear the list */
	public void clear() {
		data = (E[]) new Object[CAPACIDAD_INICIAL];
		size = 0;
	}

	@Override /** Return true if this list contains the element */
	public boolean contains(E e) {
		for (int i = 0; i < size; i++)
			if (data[i].equals(e))
				return true;

		return false;
	}

	@Override /** Return the element at the specified index */
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
	}

	@Override /**
				 * Return the index of the first matching element in this list.
				 * Return -1 if no match.
				 */
	public int indexOf(E e) {
		for (int i = 0; i < size; i++)
			if (e.equals(data[i]))
				return i;

		return -1;
	}

	@Override /**
				 * Return the index of the last matching element in this list.
				 * Return -1 if no match.
				 */
	public int lastIndexOf(E e) {
		for (int i = size - 1; i >= 0; i--)
			if (e.equals(data[i]))
				return i;

		return -1;
	}

	@Override /**
				 * Remove the element at the specified position in this list.
				 * Shift any subsequent elements to the left. Return the element
				 * that was removed from the list.
				 */
	public E remove(int index) { //size quiero eliminar el último, pila
		checkIndex(index); // O(1)

		E e = data[index]; // O(1)

		// Shift data to the left
		for (int j = index; j < size - 1; j++) { // con size no lo ejecuto ninguna vez
			data[j] = data[j + 1];
		}
		data[size - 1] = null; // This element is now null O(1)

		// Decrement size
		size--; // O(1)

		return e; // O(1)
	}

	@Override /**
				 * Replace the element at the specified position in this list
				 * with the specified element.
				 */
	public E set(int index, E e) {
		checkIndex(index);
		E antiguo = data[index];
		data[index] = e;
		return antiguo;
	}

	@Override
	public String toString() {
		// Una forma
	/*	StringBuilder resultado = new StringBuilder("[");

		for (int i = 0; i < size; i++) {
			resultado.append(data[i]);
			if (i < size - 1)
				resultado.append(", ");
		}

		return resultado.toString() + "]";
		*/
		
		// Otra forma con iterator()
		int i = 0;
		
	//	String cadena = new String("["); //con esta opción iríamos concatenando / +
		StringBuilder resultado = new StringBuilder("["); //objeto mutable/cambiante
		Iterator<E> iterador =  this.iterator();
		// esquema de recorrido de mi array sacando elementos y construyendo el toString
		while (iterador.hasNext()){
			
			resultado.append(iterador.next()); //append añade al objeto StringBuilder
			if (i < size - 1) // se puede usar tb if (iterador.hasNext()
				resultado.append(", ");
			i++;
		}

		return resultado.toString() + "]";
		
	}

	/** Trims the capacity to current size */
	public void trimToSize() {

		if (size != data.length) {
			E[] newData = (E[]) new Object[size];
			System.arraycopy(data, 0, newData, 0, size);
			//Tambien se puede clonar
			//newData = data.clone();
			data = newData;
		} // If size == capacity, no need to trim
		else {
			throw new RuntimeException("Guapit@ no necesitas hacer un trim, el tamaño coincide con la capacidad");
		}
	}
		
	@Override /** Override iterator() defined in Iterable */
	public Iterator<E> iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<E> {
		private int current = 0; // Current index

		@Override
		public boolean hasNext() {
			return (current < size);
		}

		@Override
		public E next() {
			/*E e = data[current];
			current++;
			return e;*/
			if (current == size) {
				throw new NoSuchElementException("No hay más elementos en la lista");
			}
			return data[current++];
			
		}

		@Override
		public void remove() {
			ArrayList.this.remove(current);
		}
	}


}