package GenericType;

public class test<T> {
	private T a;
	public test() {}
	
	public test(T a) {
		this.a=a;
	}
	public void set(T a){
		this.a=a;
	}
	public T get(){
		return a;
	}

	public static void main(String[] args) {
		test<Integer> t = new test<Integer>(6);
		test<Integer> t2 = new test<Integer>();
		
		Integer t3 = t.get();
		
		
	}

}
