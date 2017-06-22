package easy;

import java.util.Arrays;

public class Q088 {
	public int[] solution(int[] a1,int m , int[] a2, int n){
		//sort a1
		Arrays.sort(a1);
		//sort a2
		Arrays.sort(a2);
		
		//set a1 from position (m+n)-1
		for(int i = (m+n-1); i >0; i--){
			int res;
			if(a1[m-1]>=a2[n-1]){
				res = a1[m-1];
				m--;
			}else{
				res = a2[n-1];
				n--;
			}
			a1[i]=res;
		}
		
		
		
		return a1;
	}
	
	public static void main(String[] args){
		
		Q088 instance = new Q088();
		
		int[] a1 = new int[20];
		Arrays.fill(a1, Integer.MAX_VALUE);
		int[] a1_b = {12,2,91,4,5,6,1,2};
		
		for(int i = 0; i <a1_b.length;i++){
			a1[i]=a1_b[i];
		}
		int[] a2 = {12,2,5,1,2,5};
		
		int m = a1_b.length;
		int n = a2.length;
		
		instance.solution(a1, m, a2, n);
		
		System.out.println(Arrays.toString(a1));
		
	}
	
}
