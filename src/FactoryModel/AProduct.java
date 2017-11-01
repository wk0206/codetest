package FactoryModel;

public class AProduct extends AbstractProduct {

	private String name;
	
	public AProduct(String name){
		this.name = name;
	}
	
	@Override
	public void print(){
		this.printBefore();
		System.out.println("print A >>>"+name);
	}
	public static void main(String[] args) {

		AProduct i = new AProduct("test");
		i.print();
		
	}
	



}
