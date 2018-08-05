package UT;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import CTCI.Chapter17.Q17_1;

public class CTCIQ17_1 extends Q17_1 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddWithoutOperator() {
		assertEquals(300,addWithoutOperator(100,200));
		assertEquals(0,addWithoutOperator(0,0));
		assertEquals(200,addWithoutOperator(0,200));
		assertEquals(0,addWithoutOperator(100,-100));
		assertEquals((Integer.MAX_VALUE + 10),addWithoutOperator(Integer.MAX_VALUE, 10));

		//fail("Not yet implemented");
	}

}
