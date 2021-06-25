package org.mp.sesion07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ImagenDAO {

	public static Imagen leerArchivo(String cabeceraI) {

		Imagen aux = null;
		String[] datos = null;
		int lineas = 0;
		int columnas = 0;
		String[] nbandas = null;
		
		try {
			
			BufferedReader in = new BufferedReader(new FileReader(new File(cabeceraI)));
			
			datos = new String[5];
			
			datos[0] = in.readLine();
			datos[1] = in.readLine();
			datos[2] = in.readLine();
			in.readLine();
			datos[3] = in.readLine();
			nbandas = datos[3].substring(1, datos[3].length() - 1).split(";");
			
			lineas = Integer.valueOf(in.readLine());
			columnas = Integer.valueOf(in.readLine());
			
			aux = new Imagen(lineas, columnas, datos[2], datos[1]);
			
			in.close();
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		if(datos == null) {
			
			return null;
		}else {
			
			datos[0] = cabeceraI.replace(".cabecera", ".dat");
			aux = leerBSQ(datos[0], aux, nbandas, datos[1]);
		}
		
		
		return aux;
	}
	
	private static Imagen leerBSQ(String nombreArchivo, Imagen imagen, String[] nbandas, String tipoImagen) {
		
		Number[][] datos = new Number[imagen.getLineas()][imagen.getColumnas()];
		
		try {
			
			DataInputStream in = new DataInputStream(new FileInputStream(nombreArchivo));
			
			Banda<Number> banda_aux = null;
			
			for(String nbanda : nbandas) {
				
				for(int index = 0; index < imagen.getLineas(); index++){
					
					for(int index2 = 0; index2 < imagen.getColumnas(); index2++) {
						
						//Leemos los datos de los ficheros diferenciando el tipo de dato
						if(tipoImagen.equals("Integer")) {
							
							datos[index][index2] = in.readInt();
							
						}else if(tipoImagen.equals("Double")) {
							
							datos[index][index2] = in.readDouble();
						}
					}
				}
				
				//Creamos una banda auxiliar nueva en la que guardaremos los datos que hemos leido
				banda_aux = new Banda<>(nbanda, datos);
			
				//Y la añadimos a la imagen
				imagen.anadirBanda(banda_aux);
				
				//Reseteamos la matriz de datos
				datos = new Number[imagen.getLineas()][imagen.getColumnas()];
			}
			
			in.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return imagen;
	}

	public static void escribirArchivo(String salida, Imagen imagen) {
		
		
		try {
			
			File fichero = new File(salida);
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fichero)));
			
			out.println(fichero.getName().replace(".cabecera", ".dat"));
			out.println(imagen.getTipoImagen());
			out.println(imagen.getFormatoImagen());
			out.println(imagen.getNumeroBandas());
			out.print("[");
			
			for(int index = 1; index <= imagen.getBandas().size(); index++) {
				
				out.print("Banda" + index);
				
				if(index < imagen.getBandas().size()) {
					out.print(";");
				}
			}
			
			out.println("]");
			out.println(imagen.getLineas());
			out.println(imagen.getColumnas());
			
			out.close();
			
			escribirBSQ(fichero.getAbsolutePath().replace(".cabecera", ".dat"), imagen);
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private static void escribirBSQ(String nombreArchivo, Imagen imagen) {
		
		File fichero = new File(nombreArchivo);
		
		try {
			
			FileOutputStream fos = new FileOutputStream(fichero);
			DataOutputStream out = new DataOutputStream(fos);
			
			for(Banda banda : imagen.getBandas()) {
				
				for(int index = 0; index < imagen.getLineas(); index++) {
					
					for(int index2 = 0; index2 < imagen.getColumnas(); index2++) {
						
						if(imagen.getTipoImagen().equals("Integer")) {
							
							out.writeInt(banda.getDatoXY(index, index2).intValue());
							
						}  else if(imagen.getTipoImagen().equals("Double")) {
							
							out.writeDouble(banda.getDatoXY(index, index2).doubleValue());
						}
					}
				}
			}
			
			
			out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
