package test;

import java.io.Serializable;

public final class singleton implements Serializable {
	private static singleton Instance = null;
	private final static long serialVersionUID  = 2L;

	protected singleton() {
		System.out.println("test");
	}
	
	private singleton(String s) {
		System.out.println("test");
	}

	public static singleton getInstance() {
		if (Instance == null) {
			Instance = new singleton();
		}
		return Instance;
	}
	
	public static singleton getInstance2() {
		if (Instance == null) {
			Instance = new singleton("");
		}
		return Instance;
	}

}
