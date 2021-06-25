package org.mp.sesion06;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class UtilidadArchivos {

	private ArrayList<File> lista;
	
	public UtilidadArchivos() {
		this.lista = new ArrayList<File>();
	}
	
	
	public static void copiar(File origen, File destino){
		
		BufferedReader in;
		BufferedWriter out;
		try {
			in = new BufferedReader(new FileReader(origen));
			out = new BufferedWriter(new FileWriter(destino));
			
			String cadena = "";
			
			while((cadena = in.readLine()) != null) {
				
				out.write(cadena + " \n");
			}
			
			in.close();
			out.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public ArrayList listarDirectoriosArchivos(File dir) {
		
		this.listarDirectoriosArchivosRec(dir);
		
		return this.lista;
	}
	
	
	private void listarDirectoriosArchivosRec(File dir) {
		
		if(dir.isDirectory()) {
			
			File[] lista_archivos = dir.listFiles();
			
			for(int index = 0; index < lista_archivos.length; index++){
				
				this.listarDirectoriosArchivosRec(lista_archivos[index]);
			}
		}
		
		this.lista.add(dir);
		
	} 
	
	
	public void zip(File dir, String caminoSalida, String nombreArchivo){
	
		this.listarDirectoriosArchivos(dir);
		
		/*byte[] buffer = new byte[1024];
		
		ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(new File(caminoSalida +  "/" + nombreArchivo + ".zip"))));
		ZipEntry e = new ZipEntry(dir.getAbsolutePath());
		zos.putNextEntry(e);
		
		
		
		zos.closeEntry();
		zos.close();
		*/
		
		try {
			
			byte[] buffer = new byte[1024];
			
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(caminoSalida + File.separator + nombreArchivo));
			zos.setLevel(Deflater.BEST_COMPRESSION);
			
			for(int index = 0; index < this.lista.size(); index++) {
				
				if(this.lista.get(index).isFile()) {
					
					FileInputStream in = new FileInputStream(this.lista.get(index));
					zos.putNextEntry(new ZipEntry(this.lista.get(index).getAbsolutePath().replace(caminoSalida, "")));
					
					int len = 0;
					
					while((len = in.read(buffer)) > 0) {
						
						zos.write(buffer, 0, len);
					}
					
					in.close();
					zos.closeEntry();
					
					
				}
			}
			zos.close();
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
	}
}
