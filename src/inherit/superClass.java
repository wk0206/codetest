package inherit;

public class superClass {

	private int p;
	protected int pp;
	public int ppp;
	
	superClass(){
		this.p=0;
		this.pp=1;
		this.ppp=2;
		
		System.out.println(p);
		System.out.println(pp);
		System.out.println(ppp);
	}

	public void print(superClass object) {
		System.out.println(object.p);
		System.out.println(object.pp);
		System.out.println(object.ppp);
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println(this.p);
		System.out.println(this.pp);
		System.out.println(this.ppp);
	}
}
