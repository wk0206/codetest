package CTCI.BItOperation;

public class Q5_2 {
	public static void solution(double input) {
		int count = 32;
		while(count > 0) {
			Double d = Math.floor(input*2);
			System.out.print(d.intValue());
			double di = input *2 ;
			input = di >=1?di-1:di;
			count --;
		}
		
		System.out.println("Error");
	}
	

	public static void main(String[] args) {
		solution(0.72);
	}
}
