package easy;

import java.util.ArrayList;
import java.util.List;

public class Q412 {

	public List<String> fizzBuzz (int n) {
		
		List<String> result = new ArrayList<String>();
		
		for(int i = 1; i <= n ; i++){
			if(i%3==0 && i %5==0){
				result.add(i-1, "BF");
			}
			else if(i%3 == 0){
				result.add(i-1, "F");
			}
			else if(i%5 == 0){
				result.add(i-1, "B");
			}
			else result.add(i-1, String.valueOf(i));
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q412 instance = new Q412();
		
		System.out.println(instance.fizzBuzz(165));

	}

}
