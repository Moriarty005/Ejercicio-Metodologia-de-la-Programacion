package org.mp.sesion05;

public class Accion implements Comparable<Accion>{

	private String nombre;
	private long volumen;
	
	public Accion(String nombre, long volumen) {
		
		this.nombre = nombre;
		this.volumen = volumen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getVolumen() {
		return volumen;
	}

	public void setVolumen(long volumen) {
		this.volumen = volumen;
	}
	
	public boolean equals(Object obj) {

		Accion acc = (Accion) obj;
		
		boolean iguales = false;
		
		if((this.nombre == acc.getNombre()) && (this.volumen == acc.getVolumen())) {
			iguales = true;
		}
		
		return iguales;
	}

	public int compareTo(Accion o) {
		
		return this.nombre.compareTo(o.getNombre());
	}
}
