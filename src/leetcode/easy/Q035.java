package leetcode.easy;

import java.util.Arrays;
import java.util.Random;

public class Q035 {

	public int solution(int[] nums , int target){
		int end = nums.length;
		int start = 0;
		int res = realFunc(nums, target, start, end);
		
		return res;
	}
	
	public int realFunc (int[] N, int t , int start , int end){
		int index = (end-start)/2;
		int res;
		if(N[index]==t)return index;
		if(N.length>1){
			if(N[index] > t){
				start = start;
				end = index;				
			}
			else{
				start = index;
				end = end;
			}
			
			res = realFunc(N,t,start,end);
			
		}
		else{
			return index;
		}
		
		
		return res;
	}
	
	public int solution2(int[] nums, int target){
		int start = 0;
		int end = nums.length-1;
		

		
		if(nums.length==0){
			System.out.print("start "+start + ";");
			System.out.print("end   "+end + ";");
			return 0;
			
		}
		if(nums.length==1){
			System.out.print("start "+start + ";");
			System.out.print("end   "+end + ";");
			return nums[0]>=target?0:1;
		}
		while(end-start>=1){
			int index;
			if(end-start==1){
		        index = start+1;
		    }else{
			    index = start + (end-start)/2;
		    }
			System.out.print("start "+start + ";");
			System.out.print("end   "+end + ";");
			System.out.print("index "+index + ";");
			System.out.println("nums["+index+"] ="+nums[index]);
			

			if(nums[index] > target){
				start = start;
				end = index;				
			}
			else if(nums[index] < target){
				start = index;
				end = end;
			}
			else{
				return index;
			}
		}
		
		if(nums[end]<target){
			return end+1;
		}

		return end;
	}
	
	//log(n)
	public int solution3(int[] nums, int target){
		if(nums==null||nums.length==0){
			return 0;
			
		}
		int start = 0;
		int end = nums.length-1;
		

		

		if(nums.length==1){
			return nums[0]>=target?0:1;
		}
		
		while(end>start){
			int index;
			if(end-start==1){
				if(nums[start] >= target){
					start = start;
					end = start;	
					break;
				}
				else if(nums[end] <= target){
					start = end;
					end = end;
					break;
				}else break;
		    }

		    index = start + (end-start)/2;
		    
			System.out.print("start "+start + ";");
			System.out.print("end   "+end + ";");
			System.out.print("index "+index + ";");
			System.out.println("nums["+index+"] ="+nums[index]);		

			if(nums[index] > target){
				start = start;
				end = index;				
			}
			else if(nums[index] < target){
				start = index;
				end = end;
			}
			else{
				end = index;
				break;
			}
		}
		
		if(end == nums.length-1){
			if(nums[end]<target){
				end = end +1;
			}
			
		}
		
		return end;
	}
	
	//log(n)
	public int solution4(int[] nums, int target){
		if(nums==null||nums.length==0){
			return 0;
		}
		
		int start = 0, end = nums.length-1;

		while(end>=start){
			
			int index = (end+start)/2;
			System.out.print("start "+start + ";");
			System.out.print("end   "+end + ";");
			System.out.print("index "+index + ";");
			System.out.println("nums["+index+"] ="+nums[index]);	
			if(nums[index]==target)return index;
			else if(nums[index]>target){
				end = index-1;
			}else {
				start = index+1;
			}
		
		}
		
		
		return start;
	}
	
	//O(n)
	public int solution5(int[] nums, int target){
		int res=0;
		for (int i = 0, j = nums.length-1; i<j;){
			if(nums[i]>=target){
				return i;
			}
			if(nums[j]<target){
				return j+1;
			}else if(nums[j]==target){return j;}
			res = j;
			i++;
			j--;

		}
		
		
		return res;
	}
	
	public static void main(String[] args){
		int[] nums = {1,3,5,6,7,9,99};
		int[] nums2= new int[1000];
		Random rn = new Random();
		int i = 0;
		while(i<1000){
			nums2[i] = i;
			System.out.println(nums2[i]);
			i++;
		}
		Arrays.sort(nums2);
		//nums = null;
		//,5,6,7,9,99
		
		//int target = 2;
		int target = rn.nextInt(2000);
		
		System.out.println(target);
		//System.out.println((2-1)/2);
		Q035 instance = new Q035();
		System.out.println(instance.solution4(nums2, target));
		
		
	}
}
