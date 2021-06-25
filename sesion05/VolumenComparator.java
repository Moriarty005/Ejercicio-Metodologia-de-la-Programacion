package org.mp.sesion05;

import java.util.Comparator;

public class VolumenComparator implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {

		Accion a1 = (Accion) arg0;
		Accion a2 = (Accion) arg1;
		
		int devolver = 99;
		
		if(a1.getVolumen() == a2.getVolumen()) {
			devolver = 0;
		}else if(a1.getVolumen() > a2.getVolumen()) {
			devolver = 1;
		}else if(a1.getVolumen() < a2.getVolumen()) {
			devolver = -1;
		}
		
		return devolver;
	}

}
