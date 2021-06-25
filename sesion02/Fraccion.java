package org.mp.sesion02;

/**
 * Fraccion
 * 
 * @author lolac
 * @version 19.02.2021
 */
public class Fraccion extends Number implements Comparable<Object> {

	
	private int numerador;
	private int denominador;

	/**
	 * Contructor vacío
	 */
	public Fraccion() {
		numerador = 0;
		denominador = 1;
	}

	/**
	 * Contructor
	 * 
	 * @param numerador
	 * 			numerador (numero de arriba) de la fracción
	 * @param denominador
	 * 			denominador (numero de abajo) de la fracción
	 */
	public Fraccion(int numerador, int denominador) {

		this.numerador = ((denominador > 0) ? 1 : -1) * numerador;
		this.denominador = Math.abs(denominador);

	}

	
	@Override
	/**
	 * Sobreescritura de del método equals para adaptarlo a la clase Fraccion
	 * 
	 * @author lolac
	 */
	public boolean equals(Object obj) {

		if (!(obj instanceof Fraccion))
			return false;
		Fraccion otro = (Fraccion) obj;
		if (denominador != otro.denominador)
			return false;
		if (numerador != otro.numerador)
			return false;
		return true;
	}

	/**
	 * Getter
	 * 
	 * @return numerador: numerador (parte de arriba de la fracción)
	 */
	public int getNumerador() {
		return numerador;
	}

	/**
	 * Getter
	 * 
	 * @return denominador: denominador (parte de abajo) de la fracción
	 */
	public int getDenominador() {
		return denominador;
	}

	@Override
	/**
	 * Sobreescritura del método toString para adaptarlo a la clase Fraccion
	 * 
	 * @return devuelve la fracción en formato String
	 */
	public String toString() {
		if (denominador == 1)
			return numerador + "";
		else
			return numerador + "/" + denominador;
	}

	/**
	 *  Suma a nuestra fracción, la fracción que se pasa como parámetro
	 * 
	 * @param b
	 * @return 
	 */
	public Fraccion sumar(Fraccion b) {
		
		int num = this.numerador * b.getDenominador() + this.denominador * b.getNumerador();
		int den = this.denominador * b.getDenominador();
		return new Fraccion(num, den);

	}

	/**
	 * Resta a nuestra fracción, la fracción que se pasa como parámetro
	 * 
	 * @param b
	 * @return
	 */
	public Fraccion restar(Fraccion b) {
		int num = numerador * b.getDenominador() - denominador * b.getNumerador();
		int den = denominador * b.getDenominador();
		return new Fraccion(num, den);
	}

	/**
	 * Multiplica a nuestra fracción, la fracción que se pasa como parámetro
	 * 
	 * @param b
	 * @return
	 */
	public Fraccion multiplicar(Fraccion b) {
		return new Fraccion(numerador * b.getNumerador(), denominador * b.getDenominador());
	}

	
	/**
	 * Divide a nuestra fracción, la fracción que se pasa como parámetro
	 * 
	 * @param b
	 * @return
	 */
	public Fraccion dividir(Fraccion b) {
		return new Fraccion(numerador * b.getDenominador(), denominador * b.getNumerador());
	}

	
	/**
	 * Método que calcula el máximo común divisor del enumerador y denomiandor de la fracción
	 * 
	 * @param u
	 * @param v
	 * @return u (mcd del enumerador y denomiandor de la fracción)
	 */
	private static int mcd(int u, int v) {
		
		//Se calcula y se adigna el valor absoluto de las variables u y v
		u = Math.abs(u);
		v = Math.abs(v);
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	
	/**
	 * Método que simplifica, si se puede, el enumerador y denominador de la fracción
	 * 
	 * @return this (la propia fracción con sus variables modificadas en caso de que se hayan modificado)
	 */
	public Fraccion simplificar() {
		int dividir = mcd(numerador, denominador);
		numerador /= dividir;
		denominador /= dividir;
		return this;
	}

	
	
	public int compareTo(Object o) {

		Fraccion otro = (Fraccion) o;

		double valorFraccion = (double) numerador / denominador;
		double valorOtro = (double) otro.getNumerador() / otro.getDenominador();

		if (valorFraccion > valorOtro)
			return 1;
		else if (valorFraccion < valorOtro)
			return -1;
		else
			return 0;

	}

	@Override
	public double doubleValue() {

		double valor = (double) this.getNumerador() / this.getDenominador();

		return valor;
	}

	@Override
	public float floatValue() {
		
		float valor = (float) this.getNumerador() / this.getDenominador();
		
		return valor;
	}

	@Override
	public int intValue() {
		
		int valor = this.getNumerador() / this.getDenominador();
		
		return valor;
	}

	@Override
	public long longValue() {
		
		long valor = this.getNumerador() / this.getDenominador();
		
		return valor;
	}

}
