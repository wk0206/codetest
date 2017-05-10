package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import easy.Q231;

public class Q231Test {

	private static Q231 instance = new Q231();
	
	//prepare data
	private static int E1 = 0;
	private static int E2 = 1;
	private static int E3 = 16;
	private static int E4 = (int)(Math.pow(2,30));
	private static int E5 = (int)(-Math.pow(2,31));
	private static int E6 = 9;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMethod1() {
		assertEquals(false, instance.method1(E1));
		assertEquals(true, instance.method1(E2));
		assertEquals(true, instance.method1(E3));
		assertEquals(true, instance.method1(E4));
		assertEquals(false, instance.method1(E5));
		assertEquals(false, instance.method1(E6));
	}

	@Test
	public void testMethod2() {
		assertEquals(false, instance.method2(E1));
		assertEquals(true, instance.method2(E2));
		assertEquals(true, instance.method2(E3));
		assertEquals(true, instance.method2(E4));
		assertEquals(false, instance.method2(E5));
		assertEquals(false, instance.method2(E6));
	}

	@Test
	public void testMethod3() {
		assertEquals(false, instance.method3(E1));
		assertEquals(true, instance.method3(E2));
		assertEquals(true, instance.method3(E3));
		assertEquals(true, instance.method3(E4));
		assertEquals(false, instance.method3(E5));
		assertEquals(false, instance.method3(E6));
	}

}
