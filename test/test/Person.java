package test;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 123L;
	
	
	public String Name;
	public int ID;
	public int age;

	public Person() {
		Name="";
		ID=0;
		age = 0;
	}
	
	public Person(String name, int ID, int age) {
		this.Name = name;
		this.ID = ID;
		this.age = age;
	}
	
	public String toString() {
		
		return "Person: "+Name+ID+age;
	}
	
}
