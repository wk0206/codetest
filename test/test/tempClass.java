package test;

public class tempClass { // ����
	public static void main(String args[]) {
		OuterClass2 out = new OuterClass2();
		tempInterface outinter = out.doit();
		outinter.f();
	}
	
}

class OuterClass2 {
	// ����һ���ڲ��࣬���ҽӿ�OutInterface
	private class InnerClass implements tempInterface {
		InnerClass(String s) {
			System.out.println(s);
		}

		public void f() {
			System.out.println("�����ڲ����е�f()����");
		}
	}

	public tempInterface doit() { // �������ؽӿ�
		return new InnerClass("�����ڲ��๹�췽��");
	}
}