package leetcode.easy;

public class Q007 {

	public int reverse(int x){
		
		if(inputcheck(x)) return 0;
		
		boolean Flag = true;
		if(x < 0){
			Flag = false;
			x = -x;
		}
		
		Integer X = x;
		String s = X.toString();
		String reverse = new StringBuilder(new String(s)).reverse().toString();
		x = Integer.valueOf(reverse);
		
		if(Flag==true) {return x;}
		else return -x;
	}
	
	public int reverse2(int x){
       if(!inputcheck(x)) return 0;
        if(x==0)return 0;
		Integer X = x;
		if(x>0){
			try { 
				int l = Integer.valueOf(new StringBuilder(X.toString()).reverse().toString());
				return l;
	        } catch (NumberFormatException e) { return 0; }
			
			//return l>Integer.MAX_VALUE?0:Integer.valueOf(new StringBuilder(X.toString()).reverse().toString());
		}else{
			try { 
				X=-X;
				int l = Integer.valueOf(new StringBuilder(X.toString()).reverse().toString());
				return -l;
	        } catch (NumberFormatException e) { return 0; }
			
			//return -Integer.valueOf(new StringBuilder(X.toString()).reverse().toString())<Integer.MIN_VALUE?0:-Integer.valueOf(new StringBuilder(X.toString()).reverse().toString());
		}
	}
	
	public int reverse3(int x){
       if(!inputcheck(x)) return 0;
        if(x==0)return 0;
		Integer X = x;
		if(x>0){
			try { 
				int l = Integer.valueOf(new StringBuilder(X.toString()).reverse().toString());
				return l;
	        } catch (Exception e) { return 0; }
			
			//return l>Integer.MAX_VALUE?0:Integer.valueOf(new StringBuilder(X.toString()).reverse().toString());
		}else{
			try { 
				X=-X;
				int l = Integer.valueOf(new StringBuilder(X.toString()).reverse().toString());
				return -l;
	        } catch (Exception e) { return 0; }
			
			//return -Integer.valueOf(new StringBuilder(X.toString()).reverse().toString())<Integer.MIN_VALUE?0:-Integer.valueOf(new StringBuilder(X.toString()).reverse().toString());
		}
	}
	
	public int reverse4(int x){
		Long result=0L;
		while(x!=0){
			int digital = x%10;
			x=x/10;
			result=result*10+digital;
			
			if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)return 0;
		}

		
		return Integer.valueOf(result.intValue());
	}
	
	private boolean inputcheck(int x){
		if (x==0) return true;
		if (x>Math.pow(2, 31)-1 || x<-Math.pow(2, 31)){return false;}
		
		return true;
	}
	
	public static void main(String[] args){
		Q007 instance = new Q007();
		int x = instance.reverse4(534236469);
		
		System.out.println(x);
	}
}
