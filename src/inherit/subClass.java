package inherit;

public class subClass extends superClass {
	private String s;
	protected String ss;
	public String sss;

	subClass() {
		// super.p=0;
		super.pp = 11;
		super.ppp = 22;

		// System.out.println(p);
		System.out.println(pp);
		System.out.println(ppp);
	}
	
	@Override
	public void print() {
		super.print();
	}

	public static void main(String[] args) {
		subClass subInstance = new subClass();
		subInstance.print();
		subInstance.print(subInstance );
	}
}
