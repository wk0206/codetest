package DesignPattern;

public class Singleton_dcl {

	private volatile Singleton_dcl Instance = null;

	Singleton_dcl() {
		// do sth
	}

	public Singleton_dcl getInstance() {
		if (Instance == null) {
			synchronized (Singleton_dcl.class) {
				if(Instance == null) {
					Instance = new Singleton_dcl();
				}
			}
		}

		return Instance;
	}
}
