package CGM;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.cg.helix.persistence.exception.NoResultsException;

public class LanguageTest {

	private static LanguageServiceImpl service = new LanguageServiceImpl();
	
	@Before
	public void setUp() throws Exception {
		System.out.println("test start");
		Language l1 = new Language();
		Language l2 = new Language();
		Language l3 = new Language();
		Language l4 = new Language();

		l1.setName("Afar");
		l1.setId("aar");

		l2.setId("fin");
		l2.setName("Finnish");

		l3.setId("gle");
		l3.setName("Irish");

		l4.setId("jav");
		l4.setName("Javanese");

	}

	/**
	 * Tests the 'getLanguageById' method.
	 * @throws NoResultsException 
	 */
	@Test
	public void getLanguageById() throws NoResultsException {

		//1.Normal Case
		// Get
		Language result1 = service.getLanguageById("gle");
		// Validate
		Assert.assertNotNull(result1);
		Assert.assertEquals(result1.getName(), "Irish");
		
//		//2.Exception
//		try {
//		Language result2 = service.getLanguageById("aaa");
//		Assert.assertNull(result2);
//		}catch(NullPointerException e){
//			assertThat(e.getMessage(), is());
//		}
		
	}
//	
//	@Test(expected=NullPointerException.class)
//	public void getLanguageById_throws_Exception() throws NullPointerException{
//
//		//2.Exception
//		service.getLanguageById("aaa");
//		
//	}
//	
//	@Test
//	public void getLanguageById_throws_Exception_result() throws NullPointerException{
//
//		//3.Exception
//		try {
//			Language result3 = service.getLanguageById("aaa");
//			Assert.assertNull(result3);
//		} catch (NullPointerException e) {
//			
//		}
//	}
//	
}