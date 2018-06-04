package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonInstantiator {
	public SingletonInstantiator() {
		singleton isntance = singleton.getInstance();
		
		singleton isntance2 = new singleton();
		
		singleton instance3 = singleton.getInstance();
		
		//singleton instance4 = new singleton("");
	}
	
	
	
	public void  anotherSingleton() {
		singleton newInstance =singleton.getInstance2();
		
		
		//newInstance
	}
	
	public void serializaSingleton()throws IOException , ClassNotFoundException {
		
		singleton newInstance =singleton.getInstance2();
		
		
		 FileOutputStream fileOut =
		         new FileOutputStream("/tmp/employee.ser");
		 
		ObjectOutputStream oos = new ObjectOutputStream(fileOut);
		oos.writeObject(newInstance);
		oos.close();
		fileOut.close();
		
		 FileInputStream fileIn =
		         new FileInputStream("/tmp/employee.ser");
		 
		ObjectInputStream ois = new ObjectInputStream(fileIn);
		
		
		//deserialize object , now you have two instance of singleton
		//-----------------------------------------------------------
		singleton serializalbeInstance = (singleton)ois.readObject();
		//-----------------------------------------------------------
		ois.close();
		fileIn.close();
		
	}
}
