package org.mp.sesion02;
/**
 * @author lolac
 */
public abstract class MatrizGenerica <E extends Number>{


	public MatrizGenerica() {
		
		super();
	}

	/**
	 * Description of the method sumar.
	 * @param o1 
	 * @param o2 
	 * @return 
	 */
	protected abstract E sumar(E o1, E o2);

	/**
	 * Descripti@Override
	on of the method multiplicar.
	 * @param o1 
	 * @param o2 
	 * @return 
	 */
	protected abstract E multiplicar(E o1, E o2);

	/**
	 * Description of the method cero.
	 * @return 
	 */
	protected abstract E cero();

	/**
	 * Description of the method sumarMatrices.
	 * @param matriz1 
	 * @param matriz2 
	 * @return 
	 */
	public E[][] sumarMatrices(E[][] matriz1, E[][] matriz2) {

		//System.out.println("Matrices que nos llegan(sumar)\n1: " + matriz1.length + " / " + matriz1[0].length + "\n2: " + matriz2.length + " / " + matriz2[0].length);
		
		E[][] aux = (E[][])new Number[matriz1.length][matriz1[0].length];
		
		if(matriz1[0].length == matriz2[0].length && matriz1.length == matriz2.length) {
			
			for(int index1 = 0; index1 < aux.length; index1++) {
				
				for(int index2 = 0; index2 < aux[0].length; index2++) {
					
					aux[index1][index2] = sumar(matriz1[index1][index2], matriz2[index1][index2]);
					//System.out.println("Valor de aux[i1][i2] en sumar: " + aux[index1][index2]);
				}
			}
			
		}else {
			throw new RuntimeException("Las matrices no tienen el mismo tamaño");
		}
		
		
		
		return aux; 
	}

	/**
	 * Description of the method multiplicarMatrices.
	 * @param matriz1 
	 * @param matriz2 
	 * @return 
	 */
	public E[][] multiplicarMatrices(E[][] matriz1, E[][] matriz2) {
		
		//System.out.println("Matrices que nos llegan(mult)\n1: " + matriz1.length + " / " + matriz1[0].length + "\n2: " + matriz2.length + " / " + matriz2[0].length);
		
		E[][] aux = (E[][])new Number[matriz1[0].length][matriz2.length];
		
		for(int i = 0; i < aux.length; i++) {
			
			for(int j = 0; j < aux[0].length; j++) {
				
				aux[i][j] = cero();
			}
		}
		
		if(matriz1[0].length == matriz2.length) {
			
			for(int index1 = 0; index1 < aux.length; index1++) {
				
				for(int index2 = 0; index2 < aux[0].length; index2++) {
					
					for (int index3 = 0; index3 < aux[0].length; index3++) {
	                    
						System.out.println("Valor de aux[i1][i2] en sumar: " + aux[index1][index2]);
						aux[index1][index2] = sumar(aux[index1][index2], multiplicar(matriz1[index1][index3], matriz2[index3][index2]));
	                    //System.out.println("Valor de aux[i1][i2] en sumar: " + aux[index1][index2]);
	                }
				}
			}
			
		}else {
			throw new RuntimeException("No coinciden las columnas de la primera matriz con las filas de la segunda");
		}
		
		return aux;
	}

}
