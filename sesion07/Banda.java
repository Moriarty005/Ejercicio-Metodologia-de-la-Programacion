package org.mp.sesion07;

import java.util.Arrays;

public class Banda<T extends Number> {

	private String nombreBanda;
	private T[][] datos;
	
	public Banda(String nombre, int x, int y) {
		
		this.nombreBanda = nombre;
		this.datos = (T[][]) new Number[x][y];
	}
	
	public Banda(String nombre, T[][] datos) {
		
		this.nombreBanda = nombre;
		this.datos = datos;
	}

	public String getNombreBanda() {
		return nombreBanda;
	}

	public void setNombreBanda(String nombreBanda) {
		this.nombreBanda = nombreBanda;
	}

	public T[][] getDatos() {
		return datos;
	}

	public void setDatos(T[][] datos) {
		this.datos = datos;
	}
	
	public void setDatoXY(T dato, int x, int y) {
		
		this.getDatos()[x][y] = dato;
	}
	
	public T getDatoXY(int x, int y) {
		
		return this.getDatos()[x][y];
	}

	@Override
	public String toString() {
		
		String cadena = this.getNombreBanda() + ": \n";
		
		for(int index = 0; index < this.getDatos().length; index++) {
			
			for(int index2 = 0; index2 < this.getDatos()[index].length; index2++) {
				
				cadena += this.getDatos()[index][index2] + " ";
			}
			
			cadena += "\n";
		}
		
		return cadena;
	}
	
	
}
