package easy;

import java.util.Arrays;

public class Q066 {
    public int[] plusOne(int[] digits) {
        
        int i = 0;
        while(i <= digits.length-1){
            if(digits[i]!=9){
                break;
            }
            i++;
            if(i==digits.length){
                int[] res = new int[digits.length+1];
                for(int m = 0; m < res.length; m++){
                    res[m]=0;
                }
                res[0]=1;
                return res;
            }
        }
        
        for(int j = digits.length-1 ; j >=0 ; j--){
            if(digits[j]!=9){
                digits[j]=digits[j]+1;
                return digits;
            }else{
                digits[j]=0;
            }
            
        }
        
        return digits;
    }
    
    public static void main(String[] args){
    	Q066 instance = new Q066();
    	
    	int[] digits = new int[]{9,9,9,9};
    	int[] res = instance.plusOne(digits);
    	System.out.println(Arrays.toString(res));
    }
}
