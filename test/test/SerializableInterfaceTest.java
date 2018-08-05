package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableInterfaceTest implements Serializable  {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerializableInterfaceTest outter = new SerializableInterfaceTest();
		Person p1 = new Person();
		Person p2 = new Person("Wang", 12,34);
		
		System.out.println("Person Serial" + p2);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\zbook15G3\\Documents\\JavaOutputStream\\SerializableInterfaceTest.txt");
		
		
		
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p2);
		oos.flush();
		oos.close();
		
		
		FileInputStream fis = new FileInputStream("C:\\Users\\zbook15G3\\Documents\\JavaOutputStream\\SerializableInterfaceTest.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        p1 = (Person) ois.readObject();
        ois.close();
        System.out.println("Person Deserial" + p1);
		
		//OutputStreamWriter writer = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
		
	}
}
