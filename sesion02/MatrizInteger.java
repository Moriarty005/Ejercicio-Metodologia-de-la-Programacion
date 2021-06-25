package org.mp.sesion02;
/**
 * Description of MatrizInteger.
 * 
 * @author lolac
 */
public class MatrizInteger extends MatrizGenerica<Integer> {
	// Start of user code (user defined attributes for MatrizInteger)

	// End of user code

	/**
	 * The constructor.
	 */
	public MatrizInteger() {
		// Start of user code constructor for MatrizInteger)
		super();
		// End of user code
	}

	@Override
	protected Integer sumar(Integer o1, Integer o2) {
		
		return o1 + o2;
	}

	@Override
	protected Integer multiplicar(Integer o1, Integer o2) {
		
		return o1 * o2;
	}

	@Override
	protected Integer cero() {
		
		return 0;
	}

}
