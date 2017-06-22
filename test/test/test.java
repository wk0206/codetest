/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import OnlyForTest.CodeTest;

/**
 * @author macanother
 *
 */
public class test {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 System.out.println("Set up");  
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("Tear down");  
	}

	@Test
	public void testlengthOfHashtable1() {
		
		 System.out.println("test case 1");  
		
		CodeTest A = new CodeTest();
		Hashtable<String, String> case1Table = new Hashtable<String, String>();
		case1Table.put("1", "2");
		assertEquals (1, A.lengthOfHashtable(case1Table));
		//fail("Not yet implemented");
	}
	
	@Test
	public void testlengthOfHashtable2() {
		
		System.out.println("test case 2");
		
		CodeTest A = new CodeTest();
		Hashtable<String, String> case2Table = new Hashtable<String, String>();
		case2Table.put("1", "2");
		assertEquals ("2", case2Table.get("1"));
	}

}
