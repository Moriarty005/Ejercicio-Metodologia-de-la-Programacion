package org.mp.sesion03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> extends AbstractList<E> {

  private static final int CAPACIDAD_INICIAL = 16;
  private E[] data = (E[])new Object[CAPACIDAD_INICIAL];

  /** Crea una lista por defecto */
  public ArrayList() {
  }

  /** Crea una lista a partir de un array de objetos */
  public ArrayList(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]); // Advertencia: no usar super(objects)!
  }

  @Override /** Añade un nuevo elemento en la posición index */
  public void add(int index, E e) {
	  
    ensureCapacity();
    
    if (index < 0) {
    	System.out.println("HEY1   Indice: " + index + ", Tama�o: " + size);
      throw new IndexOutOfBoundsException ("Indice: " + index + ", Tama�o: " + size);
    }
    // Mueve los elementos a la derecha desde la posición especificada por index
    for (int i = size - 1; i >= index; i--)
      data[i + 1] = data[i];

    // Inserta un nuevo elemento en data[index]
    data[index] = e;

    // Incrementa el tamaño en 1
    size++;
  }

  /** Crea un nuevo array con el doble tamaño más 1 */
  private void ensureCapacity() {
	  
	  if(this.data[this.data.length - 1] != null) {
		  
		  int capacidad_final = this.data.length * 2;
		  capacidad_final++;
		  
		  E[] aux = (E[])new Object[capacidad_final];
		  System.arraycopy(this.data, 0, aux, 0, this.data.length);
		  data = aux;
	  }
	  
  }

  @Override /**Elimina todos los elementos de la lista  */
  public void clear() {

	  for(int index = 0; index < this.size; index++) {
		  this.data[index] = null;
	  }
	  
	  size = 0;
  }

  @Override /** Devuelve true si la lista contiene el elemento */
  public boolean contains(E e) {
	  
	  boolean encontrado = false;
	  
	  for(int index = 0; index < this.size; index++) {
		  if(this.data[index].equals(e)) {
			  encontrado = true;
		  }
	  }
	  
       return encontrado;
  }

  @Override /**Devuelve el elemento en la posición index especificada  */
  public E get(int index) {
    checkIndex(index);
    return data[index];
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
    	System.out.println("HEY1   Indice: " + index + ", Tama�o: " + size);
      throw new IndexOutOfBoundsException ("Indice: " + index + ", Tama�o: " + size);
    }
  }

  @Override /** Devuelve el índice de la primera
   *  ocurrencia del elemento en la lista.
   *  Devuelve -1 si no está. */
  public int indexOf(E e) {
	  
	  int posicion_encontrado = -1;
	  boolean check_encontrado = false;
	  
	  for(int index = 0; index < this.size && !check_encontrado; index++) {
		  if(this.data[index].equals(e)) {
			  posicion_encontrado = index;
			  check_encontrado = true;
		  }
	  }
	  
       return posicion_encontrado;
  }

  @Override /** Devuelve el índice de la última ocurrencia del elemento
   *  en la lista. Devuelve -1 si no está. */
  public int lastIndexOf(E e) {
	  
	  int posicion_encontrado = -1;
	  
	  for(int index = 0; index < this.size; index++) {
		  if(this.data[index].equals(e)) {
			  posicion_encontrado = index;
		  }
	  }
	  
      return posicion_encontrado;
  }

  @Override /**Elimina el elemento en la posición especificada
   *  en la lista. Desplaza la subsecuencia de elementos a la izquierda.
   *  Devuelve el elemento eliminado. */
  public E remove(int index) {
    
	  checkIndex(index);
	  
	  E aux = this.data[index];
	  
	  this.data[index] = null;
	  
	  for(int i = index; i < this.size - 1; i++) {
		  
		  this.data[i] = this.data[i + 1];
	  }
	  
	  size--;
	  
	  return aux;
  }

  @Override /** Sustituye el elemento de la posición especificada
   *  en la lista por el elemento especificado. */
  public E set(int index, E e) {
    checkIndex(index);
    E antiguo = data[index];
    data[index] = e;
    return antiguo;
  }

  @Override
  public String toString() {
    StringBuilder resultado = new StringBuilder("[");

    for (int i = 0; i < size; i++) {
      resultado.append(data[i]);
      if (i < size - 1) resultado.append(", ");
    }

    return resultado.toString() + "]";
  }

  /** Ajusta la capacidad del array al tamaño de la lista */
  public void trimToSize() {
		
	 	int aux = 0;
	  
		for (int i = 0; i < size && aux == 0; i++) {
			
			if(this.data[i] == null) {
				  aux = i;
			}
		}
		
		  
		E[] nueva_lista = (E[])new Object[aux + 1];
		System.arraycopy(this.data, 0, nueva_lista, 0, nueva_lista.length);
		this.data = nueva_lista;

  }

  @Override /** Sobre-escribe el método iterator() definido en Iterable */
  public Iterator<E> iterator() {
	  ArrayListIterator cosa = new ArrayListIterator();
    return cosa;
    // Devuelve una instancia de ArrayListIterator
  }

	public class ArrayListIterator implements Iterator<E> {
		
		private int actual = 0;
		
		@Override
		public boolean hasNext() {
			return actual < size;
		}

		@Override
		public E next() {
			
			if (actual == size) {
				throw new NoSuchElementException("No hay m�s elementos en la lista");
			}
			
			return data[actual++];
		}

		@Override
		public void remove() {
			ArrayList.this.remove(actual);
		}

	}


}