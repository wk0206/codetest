package OnlyForTest;

import java.util.ArrayList;
import java.util.Hashtable;
//import static net.Mildview.util.Range.*;

import easy.Q009;

public class classInstanceTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("test");
		
		Q009 i1 = new Q009();
		
		Q009 i3 = (Q009)i1.clone();
		//i3.main(args);
		
		//Class cs =  Class.forName("Q009");

    	try {
    		
    		Class c =  Class.forName("easy.Q009");
    		Q009 i2 = (Q009) c.newInstance();
    		i2.main(args);
    		
    		Class ca = Class.forName("java.util.ArrayList");
    		ArrayList a = (ArrayList) ca.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public int lengthOfHashtable(Hashtable H){
		return H.size();
	}


}
