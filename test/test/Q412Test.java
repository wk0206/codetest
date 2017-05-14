package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import easy.Q412;

public class Q412Test {

	Q412 instance = new Q412();
	List<String> r1 = new ArrayList<String>();

	@Before
	public void setUp() throws Exception {
		System.out.println("clear list");
		r1.clear();
		System.out.println("List cleared");
	}
	
	@Test
	public void testFizzBuzz() {
		r1.add("1");
		assertEquals(r1, instance.fizzBuzz(1));
		
		assertEquals("F", instance.fizzBuzz(3).get(2));
		assertEquals("B", instance.fizzBuzz(5).get(4));
		assertEquals("BF", instance.fizzBuzz(15).get(14));
	}

	
	@Test
	public void testFizzBuzz2() {
		r1.add("1");
		assertEquals(r1, instance.fizzBuzz2(1));
		
		assertEquals("F", instance.fizzBuzz2(3).get(2));
		assertEquals("B", instance.fizzBuzz2(5).get(4));
		assertEquals("BF", instance.fizzBuzz2(15).get(14));
	}

}
