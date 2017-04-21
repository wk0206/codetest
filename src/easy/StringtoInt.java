package easy;

public class StringtoInt {
	public static void main(String args[]){
		String convertingString = "-12345123";
		System.out.println("String Before Conversion:");
		int output = StringToInt(convertingString);
		
		System.out.println("");
        System.out.println("");
        System.out.println("int value as output "+ output);
        System.out.println("");
	}

	public static int StringToInt(String str){
		int i = 0, number = 0;
		boolean isNegative = false;
		int len = str.length();
		
		if(str.charAt(0)=='-'){
			isNegative = true;
			i = 1;
		}
		
		while(i < len){
			number *= 10;
			number += (str.charAt(i++)-'0');
		}
		
		if(isNegative){
			number = -number;
			}
		
		return number;
	}
}
