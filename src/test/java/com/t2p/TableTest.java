package com.t2p;

import java.io.IOException;

import org.junit.Test;

public class TableTest {

	@Test
	public void testSimpleTable() {
		String testName = "test1.html";
		Table table = new Table(testName);
		try {
			table.init();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(testName);
		table.Print();
		System.out.println();
	}

	@Test
	public void testTableWithColumnMerge1() {
		String testName = "test2-1.html";
		Table table = new Table(testName);
		try {
			table.init();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(testName);
		table.Print();
		System.out.println();
	}

	@Test
	public void testTableWithColumnMerge2() {
		String testName = "test2-2.html";
		Table table = new Table(testName);
		try {
			table.init();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(testName);
		table.Print();
		System.out.println();
	}
	
	@Test
	public void testTableWithColumnMerge3() {
		String testName = "test2-3.html";
		Table table = new Table(testName);
		try {
			table.init();
		} catch (IOException e) {
			e.printStackTrace();
		}


		System.out.println(testName);
		table.Print();
		System.out.println();
		
	}
	
	@Test
	public void testTableWithRowMerge1() {
		String testName = "test3-1.html";
		Table table = new Table(testName);
		try {
			table.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(testName);
		table.Print();
		System.out.println();
	}
	
	@Test
	public void testTableWithRowMerge2() {
		String testName = "test3-2.html";
		Table table = new Table(testName);
		try {
			table.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(testName);
		table.Print();
		System.out.println();
	}
	
	
	@Test
	public void testTableWithRowMerge3() {
		String testName = "test3-3.html";
		Table table = new Table(testName);
		try {
			table.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(testName);
		table.Print();
		System.out.println();
	}
}
