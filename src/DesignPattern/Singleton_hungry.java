package DesignPattern;

public class Singleton_hungry {
	private Singleton_hungry Instance = new Singleton_hungry();
	
	Singleton_hungry(){
		//do sth
	}
	
	public Singleton_hungry getInstance() {
		return Instance;
	}

}
