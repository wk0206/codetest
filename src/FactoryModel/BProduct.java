package FactoryModel;

public class BProduct extends AbstractProduct {

	private String name;
	
	public BProduct(String name){
		this.name = name;
	}
	
	@Override
	public void print(){
		this.printBefore();
		System.out.println("print B >>>"+name);
	}
	public static void main(String[] args) {

		BProduct i = new BProduct("test");
		i.print();
		
	}
	



}
