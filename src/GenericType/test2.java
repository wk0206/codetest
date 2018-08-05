package GenericType;

public class test2 {

	public static<T> void out(T first, T... args) {
		String res=first.toString();
        for (T t : args) {
        	res=res+t.toString();
            System.out.print(first);
            System.out.println(t);
            System.out.println(res);
        }
	}
	
	public static void main(String[] args) {
		test2 instance = new test2();
		
		
	/*	instance.out("findingsea");
        out(123);
        out(11.11);
        out(true);*/
        
        
        out("findingsea", 123, 11.11, true);
    }
}
