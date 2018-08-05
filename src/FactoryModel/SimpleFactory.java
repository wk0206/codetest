package FactoryModel;

public class SimpleFactory {

	public static IProduct getProduct(String name){
		if("A".equals(name)){
			return new AProduct(name);
		}else if("B".equals(name)){
			return new BProduct(name);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	public static void main(String[] args){
		IProduct i = getProduct("A");
		i.print();

	}
}
