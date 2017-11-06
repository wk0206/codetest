package InnerClass;

public class OuterClass {
	
	private String str;
	public static String name="test";
	
	private void dosth(){
		System.out.println("test");
	}
	
	class InnerClass1{
		public String _name1= "test_InnerClass1";
        public void innerDisplay(){
            //使用外围内的属性
            str = "chenssy...";
            System.out.println(name+_name1);
            //使用外围内的方法
            dosth();
        }
		
	}
	
	static class InnerClass2{
		public static String _name2="test_InnerClass2";
		public void innerDisplay(){
			System.out.println(name+_name2);
		}
	} 
	
	public InnerClass1 getInnerClasss(){
		return new InnerClass1();
	}
	
	public void display(){
		System.out.println(InnerClass2._name2);
		new InnerClass2().innerDisplay();
		
		OuterClass.InnerClass1 inner1 = new OuterClass().new InnerClass1();
		System.out.println(inner1._name1);
		inner1.innerDisplay();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass oc = new OuterClass();
		//OuterClass.InnerClass1 ic = oc.new InnerClass1();
		//ic.innerDisplay();
		
		oc.display();

	}

}
