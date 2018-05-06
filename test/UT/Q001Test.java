package UT;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import easy.Q001;

public class Q001Test {

	private static Q001 instance = new Q001();
	private static int[] nums = new int[]{3,2,1,4};
	private static int[] nums_false = new int[]{3,6,5,4};
	private static int target = 4;
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("test start");
	}

	@Test
	public void testInputCheckIntArray() {
		assertEquals(false,instance.inputCheck(null));
		assertEquals(false,instance.inputCheck(new int[]{}));
		assertEquals(false,instance.inputCheck(new int[]{1}));
		assertEquals(true,instance.inputCheck(new int[]{1,2,3,4}));
	}

	@Test
	public void testInputCheckInt() {
		assertEquals(true,instance.inputCheck(1));

	}

	@Test
	public void testBruteForce() {
		int[] result = instance.bruteForce(nums, target);
		assertEquals(0,result[0]);
		assertEquals(2,result[1]);
		
		int[] result_false = instance.bruteForce(nums_false, target);
		
		assertEquals(0,result_false[0]);
		assertEquals(0,result_false[1]);

	}

	//@Ignore("test")
	@Test 
	public void testBetterOne() {
		int[] result = instance.betterOne(nums, target);
		
		System.out.println(Arrays.toString(result));
		
		assertEquals(0,result[0]);
		assertEquals(2,result[1]);
	}

	@Test
	public void testBestOne() {
		int[] result = instance.bestOne(nums, target);
		
		assertEquals(0,result[0]);
		assertEquals(2,result[1]);
		
		int[] result_false = instance.bestOne(nums_false, target);		
		
		assertEquals(0,result_false[0]);
		assertEquals(0,result_false[1]);
	}

}
