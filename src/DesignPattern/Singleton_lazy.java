package DesignPattern;

public class Singleton_lazy {

	private Singleton_lazy Instance = null;

	Singleton_lazy() {
		//DO STH
	}
	
	public Singleton_lazy getInstance() {
		if(Instance == null) {
			Instance = new Singleton_lazy();
		}
		
		return Instance;
	}
}
