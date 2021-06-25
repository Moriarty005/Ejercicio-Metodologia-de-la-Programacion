package org.mp.sesion07;

import java.util.ArrayList;


public class Imagen {

	private String formatoImagen;
	private String tipoImagen;
	private int columnas;
	private int lineas;
	private ArrayList<Banda<?>> bandas;
	
	
	public Imagen(int lineas, int columnas, String formatoImagen, String tipoImagen) {
		this.formatoImagen = formatoImagen;
		this.tipoImagen = tipoImagen;
		this.columnas = columnas;
		this.lineas = lineas;
		
		this.bandas = new ArrayList<Banda<?>>();
	}
	
	public void anadirBanda(Banda banda) {
		
		this.getBandas().add(banda);
	}
	
	public void eliminarBanda(int i) {
		
		this.getBandas().remove(i);
	}
	
	public String getFormatoImagen() {
		return formatoImagen;
	}
	
	public void setFormatoImagen(String formatoImagen) {
		this.formatoImagen = formatoImagen;
	}


	public String getTipoImagen() {
		return tipoImagen;
	}

	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}

	public int getColumnas() {
		return columnas;
	}


	public int getLineas() {
		return lineas;
	}

	public Banda<?> getBanda(int i){
		
		return this.getBandas().get(i);
	}
	
	public ArrayList<Banda<?>> getBandas() {
		
		return this.bandas;
	}
	
	public int getNumeroBandas() {
		
		return this.getBandas().size();
	}
	
	public Number[] getDatosPixel(int x, int y) {
		
		Number[] datos = new Number[this.getBandas().size()];
		
		for(int index = 0; index < this.getBandas().size(); index++) {
			
			datos[index] = this.getBanda(index).getDatoXY(x, y);
		}
		
		return datos;
	}
	
	public Imagen extraerImagen(int x1, int y1, int x2, int y2) throws XYFueraImagenException {
		
		Imagen aux;
		
		if(!this.XYValida(x1, y1, x2, y2)) {
			
			throw new XYFueraImagenException();
		}
			
		int columnas = y2 - y1 + 1;
		int lineas = x2 - x1 + 1;
		aux = new Imagen(lineas, columnas, this.getFormatoImagen(), this.getTipoImagen());
		
		String nombreBanda;
		
		Number[][] datos;
		
		for(Banda banda : this.getBandas()) {
			
			datos = new Number[lineas][columnas];
			
			for(int index = y1, index2 = 0; index <= x2; index++, index2++) {
				
				for(int index3 = x1, index4 = 0; index3 <= x2; index3++, index4++) {
					
					datos[index2][index4] = banda.getDatoXY(index3, index);
				}
			}
			
			Banda nueva_banda = new Banda(banda.getNombreBanda(), datos);
			aux.anadirBanda(nueva_banda);
		}
	
		
		return aux;
	}
	
	private boolean XYValida(int x1, int y1, int x2, int y2) {
		
		boolean devolver = true;
		
		if(x1 < 0 || x1 >= this.columnas || y1 >= this.lineas || x2 < 0 || x2 >= this.columnas || y2 >= this.lineas) {
			
			devolver = false;
		}
		
		return devolver;
	}

	@Override
	public String toString() {
		return "Imagen [formatoImagen=" + formatoImagen + ", tipoImagen=" + tipoImagen + ", columnas=" + columnas
				+ ", lineas=" + lineas + ", bandas=" + bandas + "]";
	}
	
	
}
