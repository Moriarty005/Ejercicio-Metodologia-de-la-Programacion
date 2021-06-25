package org.mp.sesion06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConjuntoDatos {

	private File archivoTexto;
	private String separador;
	private Locale locale;
	private List cabecera;
	private int numeroLineas;
	private int numeroColumnas;
	private double[][] datos;
	
	
	
	public ConjuntoDatos(File archivoTexto, String separador, Locale locale) {
		super();
		this.archivoTexto = archivoTexto;
		this.separador = separador;
		this.locale = locale;
		
		this.cabecera = this.cabecera(archivoTexto);
		this.numeroColumnas = this.numColumnas(archivoTexto);
		this.numeroLineas = this.numLineas(archivoTexto);
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(archivoTexto));
			
			if(in.readLine() != null) {
				
				this.datos = this.leerDatos(archivoTexto, numeroLineas, numeroColumnas);
			}
			
			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private List cabecera(File archivoTexto) {
		
		System.out.println("Archivotexto (cabecera): " + archivoTexto);
		
		List<String> lista = new ArrayList();
		BufferedReader in;
		String[] cosas;
		try {
			in = new BufferedReader(new FileReader(archivoTexto));
			
			String cadena = in.readLine();
			
			if(cadena != null) {
				
				cosas = cadena.split(this.getSeparador());
				
				for(int index = 0; index < cosas.length; index++) {
					
					//System.out.println("cosas: " + cosas[index]);
					lista.add(cosas[index]);
				}
			}
			
			in.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}
	
	private int numLineas(File archivoTexto) {
		
		System.out.println("Archivotexto (numLineas): " + archivoTexto);
		
		int numero_lineas = 0;
		BufferedReader in;
		try {
			
			in = new BufferedReader(new FileReader(archivoTexto));
			
			while((in.readLine()) != null) {
				
				numero_lineas++;
			}
			
			in.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return numero_lineas - 1;
	}
	
	private int numColumnas(File archivoTexto) {
		
		System.out.println("Archivotexto (numColumnas): " + archivoTexto);
		
		//System.out.println("size col: " + this.cabecera(archivoTexto).size());
		
		return this.cabecera.size();
	}
	
	private double[][] leerDatos(File archivoTexto, int filas, int columnas){
		
		System.out.println("Archivotexto (leerDatos): " + archivoTexto);
		
		double[][] matriz = new double[filas][columnas];
		
		BufferedReader in;
		
		try {
			
			in = new BufferedReader(new FileReader(archivoTexto));
			
			String palabra = in.readLine();
			
			
			if(palabra != null) {
				
				String cadena = "";
				
				int numero = 0;
				String[] lista_strings;
			
					
				System.out.println("columnas: " + columnas);
				System.out.println("filas: " + filas);
				
				for(int index = 0; index < filas; index++) {
					
					cadena = in.readLine();
					lista_strings = cadena.split(this.getSeparador());
					
					for(int index2 = 0; index2 < columnas; index2++) {
						
						matriz[index][index2] = Double.valueOf(lista_strings[index2]);
						System.out.println("Valor de matriz[" + index + "][" + index2 + "]: " + matriz[index][index2]);
					}
					
				}
			}
			
			in.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return matriz;
	}
	
	
	public double[] getColumna(int columna) {
		
		double[] lista_datos = new double[this.getNumeroLineas()];
		
		for(int index = 0; index < this.getNumeroLineas(); index++) {
			
			lista_datos[index] = this.datos[index][columna];
		}
		
		return lista_datos;
	}
	
	
	
	public double[] getColumna(String columna) {
		
		return this.getColumna(this.getCabecera().indexOf(columna));
	}
	
	
	
	public void exportar(String[] cabecera, String archivoTexto, String separador) throws FileNotFoundException{
	
		double[][] matrizDatos = new double[numeroLineas][cabecera.length];
		
		
		for(int index = 0; index < cabecera.length; index++) {
			
			double[] columnas = this.getColumna(cabecera[index]);
			
			for(int index2 = 0; index2 < columnas.length; index2++) {
				
				
				matrizDatos[index2][index] = columnas[index2];
			}
		}
		
		PrintWriter out = new PrintWriter(archivoTexto);
		
		for(int index = 0; index < cabecera.length; index++) {
			
			out.print(cabecera[index]);
			
			if(index < cabecera.length - 1) {
				
				out.print(separador);
			}
		}
		
		out.println();
		
		for(int index = 0; index < matrizDatos.length; index++) {
							
			for(int index2 = 0; index2 < matrizDatos[index].length; index2++) {
				
				out.print(matrizDatos[index][index2]);
				
				if(index2 < matrizDatos[index].length - 1) {
					out.print(separador);
				}
				
			}
			out.println();
			
		}
		
		out.close();
		/**try {
			
			PrintWriter out = new PrintWriter(archivoTexto);
			
			double[] col;
			
			for(int index = 0; index < cabecera.length; index++) {
				
				out.print(cabecera[index] + separador);
				
			}
			
			out.println();
			
			for(int index = 0; index < cabecera.length; index++) {
				
				col = this.getColumna(cabecera[index]);
				
				for(int index2 = 0; index < this.getNumeroLineas(); index++) {
					
					out.print(col[index2] + separador);
				}
				
				out.println();
			}
			
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	
	public ConjuntoDatos conjuntoDatos(String[] cabecera, String archivoTexto, String separador, Locale locale) {
		
		try {
			this.exportar(cabecera, archivoTexto, separador);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ConjuntoDatos(new File(archivoTexto), separador, locale);
	}

	public File getArchivoTexto() {
		
		return archivoTexto;
	}



	public String getSeparador() {
		
		return separador;
	}



	public Locale getLocale() {
		
		return locale;
	}



	public List getCabecera() {
		
		return cabecera;
	}



	public int getNumeroLineas() {
				
		return numeroLineas;
	}



	public int getNumeroColumnas() {
		
		return this.numeroColumnas;
	}



	public double[][] getDatos() {
		
		return datos;
	}
	
	
}
