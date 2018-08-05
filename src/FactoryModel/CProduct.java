package FactoryModel;

public class CProduct extends AbstractProduct {
	
	private String name;

	public CProduct(String name) {
		this.name=name;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		this.printBefore();
		System.out.println("print C >>>"+name);
		

	}

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
		CProduct i = new CProduct("test");
		i.print();
	}
}
