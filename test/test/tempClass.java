package test;

public class tempClass { // 主类
	public static void main(String args[]) {
		OuterClass2 out = new OuterClass2();
		tempInterface outinter = out.doit();
		outinter.f();
	}
	
}

class OuterClass2 {
	// 定义一个内部类，并且接口OutInterface
	private class InnerClass implements tempInterface {
		InnerClass(String s) {
			System.out.println(s);
		}

		public void f() {
			System.out.println("访问内部类中的f()方法");
		}
	}

	public tempInterface doit() { // 方法返回接口
		return new InnerClass("访问内部类构造方法");
	}
}