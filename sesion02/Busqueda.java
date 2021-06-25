package org.mp.sesion02;

public class Busqueda {

	public static <T extends Comparable> int busquedaBinaria(T[] array, T dato)  throws ExcepcionArrayVacio{
		
		if(array.length == 0) {
			throw new ExcepcionArrayVacio("Array vacío");
		}
		
		int n = array.length;
		
		int devolver = -1;
		
		int centro, min = 0, max = n - 1;
		
		while(min <= max){
			
			centro = (max + min) / 2;
			
			int comparacion = dato.compareTo(array[centro]);
			
		    if(comparacion == 0) {
		    	
		    	devolver = centro;
		    	
		    } else if(comparacion < 0){
		    	
		        max = centro - 1;
		    }else {
		    	
		      min = centro+1;
		      
		    }
		}
		
		   return devolver;
	}
}