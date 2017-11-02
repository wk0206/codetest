package FactoryModel;

public class AFactory implements IFactory {

	@Override
	public IProduct getProduct() {
		// TODO Auto-generated method stub
		return new AProduct(AProduct.class.getName());
	}

}
