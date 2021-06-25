package org.mp.sesion02;

import java.util.GregorianCalendar;

/**
 * Description of ObjetoGeometrico.
 * 
 * @author lolac
 */
public class Octogono extends ObjectoGeometrico implements Comparable<Object>, DeColor, Cloneable{

	private double lado;
	
	public Octogono() {
		super("blanco", false);
		this.lado = 0;
	}
	
	public Octogono(String color, boolean relleno, double lado) {
		super(color, relleno);
		this.lado = lado;
	}
	
	public Octogono clone() {
		
		return new Octogono(this.color, this.relleno, this.lado);
	}
	
	@Override
	public int compareTo(Object o) {
		
		Octogono aux = (Octogono) o;
		int devolver;
		
		if(this.getLado() == aux.getLado()) {
			devolver = 0;
		}else if(this.getLado() < aux.getLado()) {
			devolver = -1;
		}else{
			devolver = 1;
		}
		
		return devolver;
	}

	@Override
	public String comoColorear() {
		
		String devolver = "Colorear los 8 lados de " + this.getColor();
		
		return devolver;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public double getPerimetro() {

		return (8 * this.lado);
	}

	@Override
	public double getArea() {

		double area = (2 + (4 / Math.sqrt(2))) * lado * lado;
		
		return area;
	}
	
	
}
