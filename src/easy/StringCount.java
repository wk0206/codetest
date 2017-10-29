package easy;

public class StringCount {
	static int i, c, res;
	
	static int length(String s){
		try{
			for(i = 0, c = 0; 0 <= i ; i++, c++){
				s.charAt(i);
			}
		}catch(Exception e){
			System.out.print("length is");
		}
		
		
		return c;
	}



	public static void main(String args[]){
		System.out.println("Original String is:");
		System.out.println("Alive is awesome");
		res = StringCount.length("Alive is awesome");
		System.out.println(res);
		
	}
}