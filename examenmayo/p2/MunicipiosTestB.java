package org.mp.examenmayo.p2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class MunicipiosTestB {

	private static StringBuilder builder = new StringBuilder();
	private static String directorioEntrada;
	private static String cmunicipios;
	private static Municipios municipios;

	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + "src" 
				+ File.separator + "org" + File.separator + "mp"
				+ File.separator + "examenmayo" + File.separator 
				+ "p2" + File.separator;

		cmunicipios = directorioEntrada + "poblacion-longitud-latitud-municipios-espana.csv";
		File file = new File(cmunicipios);

		municipios = new Municipios(file);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testOrdenNatural() {
		
		ArrayList<Municipio> muni = municipios.getMunicipios();
		Collections.sort(muni);
		assertTrue(muni.get(0).getMunicipio().equals("Ababuj"));
		assertTrue(muni.get(6).getMunicipio().equals("Abajas"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testOrdenHabitantesComparator() {
		
		ArrayList<Municipio> muni = municipios.getMunicipios();
		Collections.sort(muni, new HabitantesComparator());
		assertTrue(muni.get(0).getMunicipio().equals("Illan de Vacas"));
		assertTrue(muni.get(muni.size()-1).getMunicipio().equals("Madrid"));
	}
	
	@Test
	public void testOrdenDistanciaAMunicipioComparator() {
		
		Municipio encontrado = municipios.buscar("Almeria");
		assertTrue(encontrado.getMunicipio().equals("Almeria"));
		
		ArrayList<Municipio> muni = municipios.getMunicipios();
		Collections.sort(muni, new DistanciaAMunicipioComparator(encontrado));
		
		assertTrue(muni.get(0).getMunicipio().equals("Almeria"));
		System.out.println(muni.get(1).getMunicipio());
		assertTrue(muni.get(1).getMunicipio().equals("Huercal de Almeria"));
		assertTrue(muni.get(2).getMunicipio().equals("Viator"));
		assertTrue(muni.get(3).getMunicipio().equals("Pechina"));

		Municipio encontrado1 = municipios.buscar("Madrid");
		Collections.sort(muni, new DistanciaAMunicipioComparator(encontrado1));
		
		assertTrue(muni.get(0).getMunicipio().equals("Madrid"));
		assertTrue(muni.get(1).getMunicipio().equals("Pozuelo de Alarcon"));
		assertTrue(muni.get(2).getMunicipio().equals("Leganes"));
		assertTrue(muni.get(3).getMunicipio().equals("Coslada"));
		
	}
	
	

	@Rule
	public TestWatcher watchman = new TestWatcher() {

		@Override
		protected void failed(Throwable e, Description description) {
			if (description != null) {
				Date date = new Date();
				String strDateFormat = "hh: mm: ss dd-MMM-aaaa";
				SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
				builder.append("####" + System.getProperty("user.home") +"####\n");
				builder.append(objSDF.format(date) + " " + description);
			}
			if (e != null) {
				builder.append(' ');
				builder.append(e);
			}
			builder.append(" FAIL\n");
		}

		@Override
		protected void succeeded(Description description) {
			if (description != null) {
				Date date = new Date();
				String strDateFormat = "hh: mm: ss dd-MMM-aaaa";
				SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
				builder.append("####" + System.getProperty("user.home") +"####\n");
				builder.append(objSDF.format(date) + " " + description);
			}
			builder.append(" OK\n");
		}
	};

	@AfterClass
	public static void afterClass() throws IOException {
		FileWriter fw = new FileWriter(directorioEntrada +".log.MunicipiosTestB.txt", true);
		PrintWriter logFile = new PrintWriter(fw);
		logFile.write(builder.toString()+"\n");
		logFile.close();
	}
}
