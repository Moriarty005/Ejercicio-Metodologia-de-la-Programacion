package org.mp.sesion01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Mayor {

	public static int elEnteroMayor(int[] a) {

		int max = a[0];
		System.out.println(max);

		for (int indice = 0; indice <= a.length - 1; indice++) {
			if (a[indice] > max) {
				max = a[indice];
			}
		}

		return max;
	}

}
