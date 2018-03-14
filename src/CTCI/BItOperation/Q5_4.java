package CTCI.BItOperation;

public class Q5_4 {
	public static void solution(int num) {
		
		if(inputcheck(num)) return;
		int bitOne = Integer.bitCount(num);
		
		int temp = num+1;
		while(Integer.bitCount(temp)!= bitOne) {
			System.out.println(Integer.toBinaryString(temp) + " : "+Integer.bitCount(temp));
			temp++;
		}
		System.out.println(Integer.toBinaryString(temp) + " : "+Integer.bitCount(temp) + ":"+temp);
		
		System.out.println(Integer.toBinaryString(num)+"------------");
		System.out.println(Integer.toBinaryString(temp));

		
		
		temp = num-1;
		while(Integer.bitCount(temp)!= bitOne) {
			System.out.println(Integer.toBinaryString(temp) + " : "+Integer.bitCount(temp));
			temp--;
		}
		System.out.println(Integer.toBinaryString(temp) + " : "+Integer.bitCount(temp) + ":"+temp);
		
//		System.out.println(Integer.toBinaryString(num));
//		System.out.println(Integer.toBinaryString(temp));
		System.out.println("100010101001"+" : "+Integer.parseInt("100010101001" ,2));
		System.out.println("100010101100"+" : "+Integer.parseInt("100010101100" ,2));
		
		
	}
	
	
	public void solution2(int num) {
	//the next smallest , is the exchange last 1 with rightmost 0
	int indexOfLast1 = Integer.toBinaryString(num).lastIndexOf("1");
		
	//the next larest, is exchange 
		
		
	}
	
	public static boolean inputcheck(int num) {
		if(num == 0) return false;
		if(num == Integer.MAX_VALUE) return false;
		return true;
	}
	public static void main(String[] args) {
		solution(15);
	}
}
