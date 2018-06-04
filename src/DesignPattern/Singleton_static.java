package DesignPattern;

public class Singleton_static {
	Singleton_static (){
		//do sth
	}
	
	//private static Singleton_static Instance = null;
	
	private static class InnerClass{
		public static Singleton_static instance = new Singleton_static();  
	}
	
	public static Singleton_static getInstance() {
		return InnerClass.instance;
	}
	

}
