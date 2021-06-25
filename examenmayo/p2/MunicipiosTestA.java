package org.mp.examenmayo.p2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class MunicipiosTestA {
	
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
				+"p2" + File.separator;

		cmunicipios = directorioEntrada + "poblacion-longitud-latitud-municipios-espana.csv";
		File file = new File(cmunicipios);
		
		municipios = new Municipios(file);
	}

	@Test
	public void testPoblacionTotal() {
		System.out.println(municipios.poblacionTotal());
		assertTrue(municipios.poblacionTotal()==46745807);
	}
	
	@Test
	public void testBuscar() {
		Municipio encontrado = municipios.buscar("Abla");
		assertTrue(encontrado.getMunicipio().equals("Abla"));
				
		encontrado = municipios.buscar("Almeriia");
		assertNull(encontrado);	
	}	

	@Test
	public void testMunicipiosProvincia() {
		
		List<Municipio> lista= municipios.municipiosProvincia("Almeria");
		System.out.println("Tamaño lista: " + lista.size());		
		assertTrue(lista.size()==102);
	
		for (Municipio municipio : lista) {
			//System.out.println(municipio);
			assertTrue(municipio.equals(municipios.buscar(municipio.getMunicipio())));
		}
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
		FileWriter fw = new FileWriter(directorioEntrada +".log.MunicipiosTestA.txt", true);
		PrintWriter logFile = new PrintWriter(fw);
		logFile.write(builder.toString()+"\n");
		logFile.close();
	}
	
}
