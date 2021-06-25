package org.mp.sesion05;

public class SolucionesBusqueda {

	
	/**
	 * Algoritmo de búsqueda que encuentra el numero solicitado de forma lineal
	 * @param busqueda
	 * @return
	 * @throws ElementoNoEncontradoException
	 */
	public static Object busquedaLineal(Busqueda busqueda) throws ElementoNoEncontradoException {
		
		int numero_buscado = 0;
		boolean encontrado = false;
		
		for (int i = 0; i < busqueda.getNumElementos() && encontrado == false; i++) {
            if(busqueda.getNumBuscado() == i) {
            	numero_buscado = busqueda.getNumBuscado();
            	encontrado = true;
            }
        }
		
		if(encontrado) {
			throw new ElementoNoEncontradoException("");
		}
		
		return numero_buscado;
	}

	public static Object busquedaBinariaIter(Busqueda busqueda) throws ElementoNoEncontradoException{

        int primero = 0, ultimo = busqueda.getNumElementos() - 1;
        int numero_buscado = 0;
        boolean encontrado = false;
        
        while (primero <= ultimo && encontrado == false) {
            int mitad = primero + (ultimo - primero) / 2;

            if (busqueda.getDatos()[mitad] == busqueda.getNumBuscado()) {
                numero_buscado = mitad;
            	encontrado = true;
            }
            
            if (busqueda.getDatos()[mitad] < busqueda.getNumBuscado()) {
                primero = mitad + 1;
                
            }else {
                ultimo = mitad - 1;
            }
        }
        
        if(!encontrado) {
        	throw new ElementoNoEncontradoException("");
        }
        
        return numero_buscado;
	}

	public static Object busquedaBinariaRec(Busqueda busqueda) throws ElementoNoEncontradoException{
		
		int numero_buscado = buscar(busqueda.getDatos(), busqueda.getNumBuscado(), 0, busqueda.getNumElementos());
		
		if(numero_buscado == -1) {
        	throw new ElementoNoEncontradoException("");
        }
		
		return numero_buscado;
	}
	
	public static int buscar(int[] datos, int numero_buscado, int primero, int ultimo) {

	    int centro = (primero + ultimo) / 2;
	    int numero_final = -1;
	    
	    if (ultimo < primero) {
	    	numero_final = -1;
	    }

	    if (numero_buscado < datos[centro]) {
	    	numero_final = buscar(datos, numero_buscado, primero, centro - 1);
	    }

	    if (numero_buscado > datos[centro]) {
	    	numero_final = buscar(datos, numero_buscado, centro + 1, ultimo);
	    }

	    if (numero_buscado == datos[centro]) {
	    	numero_final = centro;
	    }

	    return numero_final;
	}
	
	

}
