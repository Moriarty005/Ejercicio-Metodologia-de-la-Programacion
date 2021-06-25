package org.mp.sesion05;

import java.util.ArrayList;
import java.util.List;

public class Acciones {

	private List<Accion> acciones;
	
	public Acciones() {
		this.acciones = new ArrayList<Accion>();
	}
	
	
	
	public List<Accion> getAcciones() {

		return this.acciones;
	}



	public void add(Accion accion) {

		this.acciones.add(accion);
		
	}

}
