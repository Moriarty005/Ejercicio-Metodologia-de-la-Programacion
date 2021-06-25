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
	 * Contructor vac�o
	 */
	public Fraccion() {
		numerador = 0;
		denominador = 1;
	}

	/**
	 * Contructor
	 * 
	 * @param numerador
	 * 			numerador (numero de arriba) de la fracci�n
	 * @param denominador
	 * 			denominador (numero de abajo) de la fracci�n
	 */
	public Fraccion(int numerador, int denominador) {

		this.numerador = ((denominador > 0) ? 1 : -1) * numerador;
		this.denominador = Math.abs(denominador);

	}

	
	@Override
	/**
	 * Sobreescritura de del m�todo equals para adaptarlo a la clase Fraccion
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
	 * @return numerador: numerador (parte de arriba de la fracci�n)
	 */
	public int getNumerador() {
		return numerador;
	}

	/**
	 * Getter
	 * 
	 * @return denominador: denominador (parte de abajo) de la fracci�n
	 */
	public int getDenominador() {
		return denominador;
	}

	@Override
	/**
	 * Sobreescritura del m�todo toString para adaptarlo a la clase Fraccion
	 * 
	 * @return devuelve la fracci�n en formato String
	 */
	public String toString() {
		if (denominador == 1)
			return numerador + "";
		else
			return numerador + "/" + denominador;
	}

	/**
	 *  Suma a nuestra fracci�n, la fracci�n que se pasa como par�metro
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
	 * Resta a nuestra fracci�n, la fracci�n que se pasa como par�metro
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
	 * Multiplica a nuestra fracci�n, la fracci�n que se pasa como par�metro
	 * 
	 * @param b
	 * @return
	 */
	public Fraccion multiplicar(Fraccion b) {
		return new Fraccion(numerador * b.getNumerador(), denominador * b.getDenominador());
	}

	
	/**
	 * Divide a nuestra fracci�n, la fracci�n que se pasa como par�metro
	 * 
	 * @param b
	 * @return
	 */
	public Fraccion dividir(Fraccion b) {
		return new Fraccion(numerador * b.getDenominador(), denominador * b.getNumerador());
	}

	
	/**
	 * M�todo que calcula el m�ximo com�n divisor del enumerador y denomiandor de la fracci�n
	 * 
	 * @param u
	 * @param v
	 * @return u (mcd del enumerador y denomiandor de la fracci�n)
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
	 * M�todo que simplifica, si se puede, el enumerador y denominador de la fracci�n
	 * 
	 * @return this (la propia fracci�n con sus variables modificadas en caso de que se hayan modificado)
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
