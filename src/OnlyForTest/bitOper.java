package OnlyForTest;

public class bitOper {

	static final int MAXIMUM_CAPACITY = 1 << 31;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		System.out.println("bit AND");
//		System.out.println(bNumber(12));
//		System.out.println(bNumber(25));
//		System.out.println("--------");
//		System.out.println(bNumber(12&25));
//		System.out.println("########");
		
		bitOper(12,25, "AND");
		bitOper(12,25, "OR ");
		bitOper(12,25, "XOR");
		
		System.out.println("complement = -(n+1)");
		System.out.println("000000000000000000000000"+bNumber(35));
		System.out.println(Integer.toBinaryString(~35));
		
		
//		System.out.println(~35);
//		System.out.println(12^25);
//		System.out.println(11&11);
//		System.out.println(11|11);
//
//		System.out.println(MAXIMUM_CAPACITY);
//		System.out.println(MAXIMUM_CAPACITY-1);
//		
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
		for (int i = 0; i <= 32; i++){
			//System.out.println((1 << i)-1);
		}
		
	}
	
	public static void bitOper(int num1, int num2, String oper){
		String sNum1 = bNumber(num1);
		String sNum2 = bNumber(num2);
		
		String result = "";
		
		if(oper=="AND"){
			result = bNumber(num1&num2);
		}
		
		if(oper=="OR "){
			result = bNumber(num1|num2);
		}
		
		if(oper=="XOR"){
			result = bNumber(num1^num2);
		}
		
		System.out.println("——————————");
		System.out.println("|bit "+oper+" |");
		System.out.println("|"+sNum1+"|");
		System.out.println("|"+sNum2+"|");
		System.out.println("|--------|");
		System.out.println("|"+result+"|");
		System.out.println("——————————");
		
	}
	
	public static String bNumber(Integer num){
		String base = "00000000";
		String result = base.substring(0,8-Integer.toBinaryString(num).length())
				+Integer.toBinaryString(num);
		
		return result;
	}

}
