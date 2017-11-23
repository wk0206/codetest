package ExceptionTest;

public class FullConstructors {

	public static void f() throws MyException{
		System.out.println("test");
		throw new MyException();
	}
	
	public static void g() throws MyException{
		System.out.println("test2");
		throw new MyException("from g");
	}
	
	public static void main(String[] args) {
		try{
			f();
			
		}catch(MyException e){
			e.printStackTrace();
		}
		
		try{
			g();
			
		}catch(MyException e){
			e.printStackTrace(System.out);
		}finally{
			System.out.println("final");
		}
		
		String s =  null;
		try{
			s.length();
			
		}catch(Exception e){
			e.printStackTrace(System.out);
		}finally{
			System.out.println("final");
		}
		
		
		
	}

}
