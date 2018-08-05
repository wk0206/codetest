package test;

import java.io.Serializable;

public class subClass extends AbstractTest implements Serializable{

	
	public void test() {
		// TODO Auto-generated method stub
		super.someTest();
		this.someTest();
	}

	@Override
	protected void pTest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean anohterTest() {
		// TODO Auto-generated method stub
		return false;
	}
	

	public void someTest() {
		
	}
}
