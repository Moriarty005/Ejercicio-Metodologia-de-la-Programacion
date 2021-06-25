package org.mp.sesion02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorPrimos implements Iterator<Integer> {

	private int limite;
	private int actual;

	public IteradorPrimos(int limite) {
		super();
		this.limite = limite;
		this.actual = 2;
	}

	public int getLimite() {
		return limite;
	}

	public int getActual() {
		return actual;
	}

	@Override
	public boolean hasNext() {

		if (this.actual > limite) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Integer next() {

		if (this.actual > this.limite) {
			throw new NoSuchElementException("No se puede acceder a más números primos");
		}

		Integer aux = this.actual;

		do {

			this.actual++;

		} while (!esPrimo(this.actual));

		return aux;
	}

	public void remove() {
		throw new UnsupportedOperationException("Método no soportado");
	}

	public static boolean esPrimo(int numero) {

		int divisor = 2;
		boolean primo = true;

		while (primo && divisor <= Math.sqrt(numero)) {

			if (numero % 2 == 0) {

				if (numero % divisor == 0) {
					primo = false;

				}
				divisor++;

			} else {
				if (divisor <= 2) {
					divisor = 3;
				}

				if (numero % divisor == 0) {
					primo = false;
				}
				divisor += 2;
			}

		}

		return primo;
	}

	public String mostrarPrimos() {

		String cadena = "";
		int contador = 0;
		
		while (this.hasNext()) {

			cadena += "\t" + this.next();
			contador++;
			if(contador == 10) {
				cadena += "\n";
				contador = 0;
			}
		}
		
		

		return cadena;
	}

}
