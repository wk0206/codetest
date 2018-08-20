package leetcode.easy;


//Palindrome Number
public class Q009 {

	public Object clone(){
		return this;
	}
	
	public Q009(){
		System.out.println("test~~~");
	}
	
    public boolean isPalindrome(int x) {
        if(x<0|| (x!=0 &&x%10==0)) return false;
        int sum=0;
        while(x>sum)
        {
        	System.out.println("sum "+sum);
        	System.out.println("x   "+x);
            sum = sum*10+x%10;
            x = x/10;
        }
        
        System.out.println("sum "+sum);
    	System.out.println("x   "+x);
        return (x==sum)||(x==sum/10);
    }
    
    public static void main(String[] args){
    	Q009 instance = new Q009();
    	
    	int s = 1234554321;
    	boolean res = instance.isPalindrome(s);
    	

    	
    	System.out.println(res);
    	//System.out.println("a".indexOf(" "));
    }
}
