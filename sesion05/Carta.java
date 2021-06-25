package org.mp.sesion05;

public class Carta implements Comparable {

	private String palo;
	private int numero;
	private int valor;

	/**
	 * Constructor vacío
	 */
	public Carta() {
		super();
		this.palo = "";
		this.numero = 0;
		this.valor = 0;
	}

	/**
	 * Contructor por parámetros
	 * 
	 * @param palo
	 * @param numero
	 */
	public Carta(String palo, int numero) {
		super();
		this.palo = palo;
		this.numero = numero;
		this.asignarValor(this);
	}

	/**
	 * Getter
	 * 
	 * @return palo
	 */
	public String getPalo() {
		return palo;
	}

	/**
	 * Setter
	 * 
	 * @param palo
	 */
	public void setPalo(String palo) {
		this.palo = palo;
	}

	/**
	 * Getter
	 * 
	 * @return numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Setter
	 * 
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Geter
	 * 
	 * @return valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Setter
	 * 
	 * @param valor
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(Object obj) {

		boolean respuesta = false;

		if (obj.getClass().getSimpleName().equals("Carta")) {
			Carta nueva = (Carta) obj;

			if ((this.getNumero() == nueva.getNumero()) && (this.getPalo().equals(nueva.getPalo()))
					&& (this.getValor() == nueva.getValor())) {

				respuesta = true;
			}
		}

		return respuesta;
	}

	@Override
	public String toString() {
		return "Carta [palo=" + palo + ", numero=" + numero + ", valor=" + valor + "]";
	}

	@Override
	public int compareTo(Object arg0) {

		Carta otro = (Carta) arg0;

		if (this.getValor() > otro.getValor())
			return 1;
		else if (this.getValor() < otro.getValor())
			return -1;
		else
			return 0;
	}

	/**
	 * Método que va a asignarle el valor a una carta según su número y su palo
	 * 
	 * @param carta
	 */
	public void asignarValor(Carta carta) {

		if (carta.getNumero() >= 1 && carta.getNumero() <= 12) {

			carta.setValor(carta.getNumero());
		} else {

			carta.setValor(0);
		}

		if (carta.getValor() != 0) {
			if (carta.getPalo().equals("O")) {

				carta.setValor(carta.getValor() + 0);
			} else if (carta.getPalo().equals("C")) {

				carta.setValor(carta.getValor() + 12);
			} else if (carta.getPalo().equals("E")) {

				carta.setValor(carta.getValor() + 24);
			} else if (carta.getPalo().equals("B")) {

				carta.setValor(carta.getValor() + 36);
			} else {
				carta.setPalo("error");
			}
		}

	}

}
