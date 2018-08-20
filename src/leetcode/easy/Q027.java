package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class Q027 {
	
	public int removeElement(int[] nums, int val){
        //array's element can not be deleted, only to set to some number 
        //this question only require a number of the length.
        //this length will be easily find after sorting
        //but it is O(n)
		if(nums.length==0)return 0;
        Arrays.sort(nums);
        
        int i = 0;
        while(i<=nums.length-1&&nums[i]< val){
        	i++;
        }
        
        int j = nums.length-1;
        while(j>=0 && nums[j]> val){
        	j--;
        }
        System.out.println(i);
        System.out.println(j);
        return nums.length-(j-i+1);

		
		//return nums;
	}
	
	public int removeElementLT(int[] A, int elem) {
		   int m = 0;    
		   for(int i = 0; i < A.length; i++){
		       
		       if(A[i] != elem){
		           A[m] = A[i];
		           m++;
		       }
		   }
		   
		   return m;
		}
	
	public static void main(String[] args){
		
		Q027 instance = new Q027();
		
		//int[] nums = {1,2,4,5,6};
		int[] nums = {2};
		
		int res = instance.removeElement(nums, 3 );
		

		int[] stuNum={100,200,100,200,199,199,199,199,199};
		Arrays.sort(stuNum);

		//System.out.println(Arrays.toString(stuNum));
		//System.out.println(Arrays.binarySearch(stuNum, 199));

	
		System.out.println(res);
	}

}
