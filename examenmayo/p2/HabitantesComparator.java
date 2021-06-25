package org.mp.examenmayo.p2;

import java.util.Comparator;

public class HabitantesComparator implements Comparator{
	
	@Override
	public int compare(Object o1, Object o2) {

		Municipio aux1 = (Municipio) o1;
		Municipio aux2 = (Municipio) o2;
		
		int devolver = 0;
		
		if(aux1.getHabitantes() > aux2.getHabitantes()) {
			
			devolver = 1;
		}else if(aux1.getHabitantes() <= aux1.getHabitantes()) {
			
			devolver = -1;
		}
		
		return devolver;
	}
}

	