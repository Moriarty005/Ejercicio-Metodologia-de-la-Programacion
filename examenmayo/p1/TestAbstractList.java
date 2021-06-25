package org.mp.examenmayo.p1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestAbstractList {
	
	private String[] nombres1 = {"Tomás", "Ana", "Pedro", "Carmen", "Julia" };
	private String[] nombres2 = {"Tomás", "Ana", "Miguel", "María", "Daniel" };
	private String[] nombres3 = {};
	private String[] nombres4 = {"Enrique"};
	private String[] nombres5 = {"Tomás", "Ana", "Marta"};
	private static StringBuilder builder = new StringBuilder();
	private static String directorioEntrada;
	
	@Before
	public void setUp() throws Exception {	
		directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + "src" 
				+ File.separator + "org" + File.separator + "mp"
				+ File.separator + "examenmayo" + File.separator 
				+ "p1" + File.separator;

	}
	
	@Test
	public void testAddAll() {

		List<String> lista1 = new ArrayList<String>(nombres1);
		List<String> lista2 = new ArrayList<String>(nombres2);
		List<String> lista3 = new ArrayList<String>(nombres3);

		try {
			lista1.addAll(lista3);
			fail();
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "La lista no ha cambiado, otraLista está vacía");
		}
		lista1.addAll(lista2);
		assertEquals("[Tomás, Ana, Pedro, Carmen, Julia, Tomás, Ana, Miguel, María, Daniel]", lista1.toString());
	}

	@Test
	public void testRemoveAll() {
		
		List<String> lista1 = new ArrayList<String>(nombres1);
		List<String> lista2 = new ArrayList<String>(nombres2);
		List<String> lista4 = new ArrayList<String>(nombres4);

		assertTrue(lista1.removeAll(lista2));
		assertEquals("[Pedro, Carmen, Julia]", lista1.toString());
		assertFalse(lista1.removeAll(lista4));
		assertEquals("[Pedro, Carmen, Julia]", lista1.toString());

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
		FileWriter fw = new FileWriter(directorioEntrada +".log.TestAbstractList.txt", true);
		PrintWriter logFile = new PrintWriter(fw);
		logFile.write(builder.toString()+"\n");
		logFile.close();
	}
}
