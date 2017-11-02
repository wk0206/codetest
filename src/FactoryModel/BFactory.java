package FactoryModel;

public class BFactory implements IFactory {

	@Override
	public IProduct getProduct() {
		// TODO Auto-generated method stub
		return new BProduct(BProduct.class.getName());
	}

	public static void main(String[] args){
		IFactory f = new BFactory();
		IProduct i = f.getProduct();
		i.print();
	}
}
