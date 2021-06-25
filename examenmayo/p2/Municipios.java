package org.mp.examenmayo.p2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Municipios {

	private List<Municipio> municipios;

	public Municipios(File municipios) {
		super();
		
		this.municipios = new ArrayList<Municipio>();
		
		try {
			this.leerMunicipios(municipios);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void leerMunicipios(File municipios) throws Exception {
	
		BufferedReader in;
		
		try {
			
			//Inicializamos el bueffered reader
			in = new BufferedReader(new FileReader(municipios));
			
			String[] lista;
			String palabra = in.readLine();
			
			//System.out.println(palabra);
			
			while(palabra != null) {
				
				palabra = in.readLine();
				
				if(palabra != null) {
					
					lista = palabra.split(";");
				
					Municipio aux = new Municipio(lista[0], lista[1], Double.valueOf(lista[2].replace(",", ".")), Double.valueOf(lista[3].replace(",", ".")), Double.valueOf(lista[4].replace(",", ".")), Integer.valueOf(lista[5].replace(",", ".")));
					this.municipios.add(aux);
				}
			}
			
			//Cerramos buffer de datos
			in.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//return (cosa que devolvamos)
	}
	
	public Municipio buscar(String municipio){
		
		Municipio aux = null;
		
		for(Municipio m : this.municipios) {
			
			if(m.getMunicipio().equals(municipio)) {
				 aux = m;
			}
		}
		
		return aux;
	}
	
	public long poblacionTotal(){
		
		int total = 0;
		for(Municipio m : this.municipios) {
			
			total += m.getHabitantes();
		}

		return total;
	}

	
	public List<Municipio> municipiosProvincia(String provincia){
		
		List<Municipio> lista = new ArrayList<Municipio>();
		
		for(Municipio m : this.municipios) {
			
			if(m.getProvincia().equals(provincia)) {
				
				lista.add(m);
			}
		}
		
		return lista;
	}
	
	public ArrayList<Municipio> getMunicipios() {
		
		ArrayList<Municipio> municipiosTemp = new ArrayList<Municipio>(this.municipios);		
		return municipiosTemp;
	}

	@Override
	public String toString() {
		return "Municipios [municipios=" + municipios + "]";
	}
	
	
	
}
