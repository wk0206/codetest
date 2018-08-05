package FactoryModel;

public class UserWithSimpleFactory {

	
	public static void main(String[] args){
		SimpleFactory sf = new SimpleFactory();
		IProduct i = sf.getProduct("A");
		i.print();

	}
}
