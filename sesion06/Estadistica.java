package org.mp.sesion06;

import org.apache.commons.math3.*;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
public class Estadistica {

	private ConjuntoDatos cd;
	
	public Estadistica(ConjuntoDatos cd) {
		
		this.cd = cd;
	}

	public double max(String columna) {

		DescriptiveStatistics ds = new DescriptiveStatistics();
		double[] datos = this.cd.getColumna(columna);
		
		for(double dato : datos) {
			
			ds.addValue(dato);
		}
		
		return ds.getMax();
	}

	public double min(String columna) {

		DescriptiveStatistics ds = new DescriptiveStatistics();
		double[] datos = this.cd.getColumna(columna);
		
		for(double dato : datos) {
			
			ds.addValue(dato);
		}
		
		return ds.getMin();
	}

	public double suma(String columna) {

		DescriptiveStatistics ds = new DescriptiveStatistics();
		double[] datos = this.cd.getColumna(columna);
		
		for(double dato : datos) {
			
			ds.addValue(dato);
		}
		
		return ds.getSum();
	}

	public double media(String columna) {

		DescriptiveStatistics ds = new DescriptiveStatistics();
		double[] datos = this.cd.getColumna(columna);
		
		for(double dato : datos) {
			
			ds.addValue(dato);
		}
		
		return ds.getMean();
	}
	
	
	
}
