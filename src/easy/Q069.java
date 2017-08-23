package easy;

//Sqrt(x)
public class Q069 {

	public int BF(int x) {    
		for(long i = 0; i <= x ; i ++){
			if(i*i==x)return (int)i;
			if(i*i>x)return (int)i-1;
		}
		return 0;
    }
	
	public int M2(int x){
		long res = Integer.toUnsignedLong(x);
		
		while(res*res>x){
			res = (res + x/res) / 2;;
		}
		
		return (int)res;
	}
	
	public int M3(int x){
		//long res = Integer.toUnsignedLong(x);
		int left = 1; 
		int right = x;
		int res=0;
		
		while(left<=right){
			int mid = left+(right-left)/2;
			if(mid <= x / mid){
				left = mid+1;
				res = mid;
			}else{
				right = mid-1;
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args){
		Q069 instace = new Q069();
		int input = (int)Math.pow(11, 2);
		int res = instace.BF(input);
		
		System.out.println(res);
	}
}
