/**
 * 
 */
package UT;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.cg.helix.persistence.exception.NoResultsException;

import CGM.Language;
import CGM.LanguageServiceImpl;

/**
 * @author Wang
 *
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class LanguageServiceImplTest {

	private static LanguageServiceImpl service = new LanguageServiceImpl();

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLanguageById() throws NoResultsException {

		// 1.Normal Case
		// Get
		Language result1 = service.getLanguageById("gle");
		// Validate
		Assert.assertNotNull(result1);
		Assert.assertEquals(result1.getName(), "Irish");

	}

	@Test(expected = NoResultsException.class)
	public void getLanguageById_throws_Exception() throws NoResultsException {

		// 2.Exception
		service.getLanguageById("aaa");
		//fail("No exception thrown.");

	}

	@Test
	public void getLanguageById_throws_Exception_result() {
		Language result3 = null;
		// 3.Exception result
		try {
			result3 = service.getLanguageById("aaa");
			
		} catch (NoResultsException e) {
			Assert.assertNull(result3);
		}
		
	}
}
