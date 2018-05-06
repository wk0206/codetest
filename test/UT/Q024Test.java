/**
 * 
 */
package UT;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mid.Q024;

/**
 * @author zbook15G3
 *
 */
public class Q024Test extends Q024 {

	Q024 instance = new Q024();

	ListNode head = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);

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
		// Q024 instance = new Q024();
		// Class<Q024> clazz = Q024.class;
		//
		// try {
		// Method method = clazz.getDeclaredMethod("ListNode", new Class[]
		// {int.class,int.class});
		// method.setAccessible(true);
		// Object head = method.invoke(instance, new Object[] {1});
		// Object n2 = method.invoke(instance, new Object[] {2});
		// Object n3 = method.invoke(instance, new Object[] {3});
		// Object n4 = method.invoke(instance, new Object[] {4});
		//
		// head.next = n2;
		// n2.next = n3;
		// n3.next = n4;
		//
		// } catch(Exception e) {
		// e.printStackTrace();
		//
		// Assert.fail();
		// }
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void test_insert() {
		insert(n2, n3);
		assertEquals(n2.next, head.next.next);
		// fail("Not yet implemented");
	}

	@Test
	public void test_swapPairs() {
		swapPairs(head);
		assertEquals(1, head.val);
		// assertEquals(n2.next,head.next.next);
		// assertEquals(n2.next,head.next.next);
		// assertEquals(n2.next,head.next.next);

		// fail("Not yet implemented");
	}

}
