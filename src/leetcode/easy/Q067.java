package leetcode.easy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Q067 {

	public String BF(String a, String b) {
        if(a.length()==0 || b.length()==0) return "0";
		
        int MaxLength = Math.max(a.length(), b.length());
        int MinLength = Math.min(a.length(), b.length());
        //System.out.println(MaxLength);
        //System.out.println(MinLength);
        String LongerString = (a.length()>=b.length())?a:b;
        ArrayList<String> res = new ArrayList<>();
        int flip = 0;
        
        for(int i = 1; i <= MaxLength; i++){
//        	System.out.println(res.toString());
//            System.out.println(i);
//            System.out.println(a.charAt(a.length()-i));
//            System.out.println(b.charAt(b.length()-i));
        	if(i<=MinLength){
        		
            	
            	if(Character.getNumericValue(a.charAt(a.length()-i))+
            			Character.getNumericValue(b.charAt(b.length()-i))+
            			flip==0){
            		res.add(0, "0");
            		flip=0;
            		continue;
            		
            	}
            	if(Character.getNumericValue(a.charAt(a.length()-i))+
            			Character.getNumericValue(b.charAt(b.length()-i))+
            			flip==1){
            		res.add(0, "1");
            		flip=0;
            		continue;
            		
            	}
            	if(Character.getNumericValue(a.charAt(a.length()-i))+
            			Character.getNumericValue(b.charAt(b.length()-i))+
            			flip==2){
            		res.add(0, "0");
            		flip=1;
            		continue;
            	}
            	if(Character.getNumericValue(a.charAt(a.length()-i))+
            			Character.getNumericValue(b.charAt(b.length()-i))+
            			flip==3){
            		res.add(0, "1");
            		flip=1;
            		continue;
            	}
            }
        	else if(flip == 0){
        		res.addAll(Arrays.asList(LongerString.substring(0, LongerString.length()-i)));
        		break;
        		//res.add(0, String.valueOf(LongerString.charAt(LongerString.length()-i)));
        	}else{

             	if(Character.getNumericValue(LongerString.charAt(LongerString.length()-i))+
            			flip==1){
            		res.add(0, "1");
            		flip=0;
            		continue;
            		
            	}
             	if(Character.getNumericValue(LongerString.charAt(LongerString.length()-i))+
            			flip==2){
            		res.add(0, "0");
            		flip=1;
            		continue;
            		
            	}
        	}
    	}
        if(flip==1)res.add(0, "1");


		
		String output = res.toString();
		output=output.replaceAll(", ", "");
		output=output.substring(1, output.length()-1);
		
		return output;
	}
	
	
	//no way from Biginteger to Binary.
	public String M2(String a, String b) {
		String test = new BigInteger("12345678901234567890123456789012345678901234567890").toString(2);
		System.out.println(new BigInteger("12345678901234567890123456789012345678901234567890").bitCount());
		
		
		BigInteger value1 = BigInteger.valueOf(Long.parseLong(a, 10));
		BigInteger value2 = BigInteger.valueOf(Long.parseLong(b, 10));
		
		BigInteger sum = value1.add(value2);
		
		return test;
	}
	
	public String LC(String a, String b) {
		StringBuilder res = new StringBuilder();
		int i = a.length() - 1, j = b.length() -1, carry = 0;
		
		
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            res.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
	}
	
	public static void main(String[] args){
		
		Q067 instance = new Q067();
		String a = "1";
		String b = "1";
		
		String res = instance.M2(a, b);
		//res=res.replaceAll(", ", "");
		//res=res.substring(1, res.length()-1);
		
		System.out.println(res);
		
	}
}
