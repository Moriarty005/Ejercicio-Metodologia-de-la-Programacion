package org.mp.sesion04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Evaluador {

	private GenericStack<Integer> pila;

	public Evaluador() {
		this.pila = new GenericStack<Integer>();
	}

	/**
	 * Este metodo va a eliminar la irregularidades en las cadenas tales como los
	 * espacios innecesarios y los caracteres que esten juntos devolviendo asi un
	 * vector de cadenas con cada uno de los caracteres separados individualmente
	 * 
	 * @param expresion
	 * @return lista_caracteres (lista con los caracteres de la expresion separada)
	 */
	public String[] eliminarBlancos(String expresion) {

		StringTokenizer caracteres_separados = new StringTokenizer(expresion, "+*/- ", true);
		GenericQueue<String> cola_de_strings = new GenericQueue<String>();

		String aux = "";

		while (caracteres_separados.hasMoreTokens()) {

			aux = caracteres_separados.nextToken();

			if (!aux.equals(" ")) {
				cola_de_strings.enqueue(aux);
			}
		}

		String[] lista_caracteres = new String[cola_de_strings.getSize()];

		for (int index = 0; index < lista_caracteres.length; index++) {

			lista_caracteres[index] = cola_de_strings.dequeue();
		}

		return lista_caracteres;

		// Primer intento de resolucion
		/*
		 * String[] lista_caracteres = new String[expresion.length()]; String aux = "";
		 * 
		 * expresion = expresion.replaceAll("  ", " "); expresion =
		 * expresion.replaceAll("  ", " ");
		 * 
		 * //System.out.println("expresion: " + expresion);
		 * 
		 * for(int index = 0; index < expresion.length(); index++) {
		 * 
		 * aux += expresion.charAt(index);
		 * 
		 * if(index != expresion.length() - 1) { if(expresion.charAt(index) != ' ' &&
		 * expresion.charAt(index + 1) != ' ') {
		 * if(!Character.isDigit(expresion.charAt(index + 1))) { aux += " "; } } } }
		 * 
		 * //System.out.println("aux: " + aux);
		 * 
		 * lista_caracteres = aux.split(" ");
		 * 
		 * int casillas_a_eliminar = 0;
		 * 
		 * for(int index2 = 0; index2 < lista_caracteres.length; index2++) {
		 * 
		 * if(lista_caracteres[index2].isEmpty()) { casillas_a_eliminar++; } }
		 * 
		 * String[] lista_caracteres_2 = new String[lista_caracteres.length -
		 * casillas_a_eliminar];
		 * 
		 * for(int index3 = 0; index3 < lista_caracteres_2.length; index3++) {
		 * 
		 * lista_caracteres_2[index3] = lista_caracteres[index3]; }
		 * //System.out.println("dentro: " + Arrays.toString(lista_caracteres)); return
		 * lista_caracteres_2;
		 */
	}

	/*
	 * Detecta de operador se ha proporcionado y se aplica a los numeros que hay en
	 * operandosPila
	 * 
	 * @param char op
	 * 
	 * @param GenericStack<Integer> operandosPila
	 */
	public void procesarUnOperador(char op, GenericStack<Integer> operandosPila) {

		int numero2 = operandosPila.pop();
		int numero1 = operandosPila.pop();

		int resultado = 0;

		switch (op) {
		case '+':
			resultado = numero1 + numero2;
			break;

		case '-':
			resultado = numero1 - numero2;
			break;

		case '*':
			resultado = numero1 * numero2;
			break;

		case '/':
			if (numero2 == 0) {
				throw new RuntimeException("No es posible una división por cero");
			}
			resultado = numero1 / numero2;
			break;
		}

		operandosPila.push(resultado);
	}

	/*
	 * Se proporciona una expresion matematica en notacion polaca inversa y se
	 * calcula el resultado
	 * 
	 * @param String string
	 * 
	 * @return Object pila.pop()
	 */
	public Object evaluarExpresion(String string) {

		int auxiliar = 0;
		String[] caracteres = eliminarBlancos(string);
		String numero_final = "";

		if (soloDigitos(string)) {

			for (int index = 0; index < caracteres.length; index++) {
				numero_final += caracteres[index];
			}

			pila.push(Integer.valueOf(numero_final));

		} else {

			for (int index = 0; index < caracteres.length; index++) {

				if (esOperador(caracteres[index])) {

					procesarUnOperador(caracteres[index].charAt(0), pila);

				} else {
					pila.push(Integer.valueOf(caracteres[index]));
				}
			}

		}

		return pila.pop();
	}

	/*
	 * Comprueba que la cadena proporcionada es simplemente un digito
	 * 
	 * @param String cadena
	 * 
	 * @return boolean
	 */
	private boolean soloDigitos(String cadena) {

		boolean cadena_solo_digitos = false;

		if (!(cadena.contains("+") || cadena.contains("/") || cadena.contains("*") || cadena.contains("-"))) {
			cadena_solo_digitos = true;
		}

		return cadena_solo_digitos;
	}

	/*
	 * Comprueba si el string proporcionado es un operador valido o no
	 * 
	 * @param String token
	 * 
	 * @return boolean
	 */
	private boolean esOperador(String token) {

		boolean es_caracter = false;

		if (token.equals("+") || token.equals("/") || token.equals("*") || token.equals("-")) {
			es_caracter = true;
		}

		return es_caracter;
	}

}
