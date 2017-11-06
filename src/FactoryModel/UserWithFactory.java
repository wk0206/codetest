package FactoryModel;

public class UserWithFactory {

	public static void main(String[] args) {
		IFactory fc = new AFactory();
		IProduct ip = fc.getProduct();
		ip.print();

	}

}
