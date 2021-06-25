package org.mp.examenmayo.p1;

public abstract class AbstractList<E> implements List<E> {

	protected int size = 0; // Tamano de la lista

	/** Crea una lista por defecto */
	protected AbstractList() {
	}

	/** Crea una lista a partir de un array de objetos */
	protected AbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Anade un nuevo elemento al final de la lista */
	public void add(E e) {
		add(size, e);
	}

	/** Devuelve true si la lista no contiene ningun elemento */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Devuelve el numero de elementos de la lista */
	public int size() {
		return size;
	}

	/**
	 * Método que borra un elemento especifico de la lista
	 * @param e
	 * @return boolean
	 */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		} else
			return false;
	}

	/**
	 * Metodo que añade todos los elementos de la lista pasada
	 * @param otraLista (De donde cojeremos los datos a añadir)
	 * @exception RunTimeException en el caso de que otraLista estuviese vacía y la nuestra no haya cambiado
	 */
	public void addAll(List<E> otraLista) {

		if (!otraLista.isEmpty()) {

			for (int index = 0; index < otraLista.size(); index++) {

				this.add(otraLista.get(index));
			}
		} else {

			throw new RuntimeException("La lista no ha cambiado, otraLista estÃ¡ vacÃ­a");
		}

	}

	// Elimina todos los elementos de otraLista de la lista
	// Devuelve verdadero si la lista cambia como resultado de la llamada
	public boolean removeAll(List<E> otraLista) {

		boolean terminado = false;

		int aux = this.size();

		if (!otraLista.isEmpty()) {

			// Eliminamos
			for (int index = 0; index < this.size; index++) {

				for (int index2 = 0; index2 < otraLista.size(); index2++) {

					if (this.get(index) == otraLista.get(index2)) {

						this.remove(index);
					}
				}
			}

			if (this.size() == aux) {

				terminado = false;
			} else {
				terminado = true;
			}

		} else {

			terminado = false;
		}

		return terminado;
	}

}
