package mid;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q031 {

	
	public int BF(int[] nums){
	
			
			int[] input = nums;
			
			//Point 1 int array to integer array
			//this is JDK1.7 type
			//List<Object> you  = Arrays.stream( input ).boxed().collect( Collectors.toList() );
			
			//JDK 1.8
			Integer[] what = Arrays.stream( input ).boxed().toArray( Integer[]::new );
			List<Integer> list  = Arrays.stream( input ).boxed().collect( Collectors.toList() );
			
			Collections.sort(list);
			
			//Collections.sort(arrayList,new Comparator<Integer>);
			
			boolean flag= false;
			int length = nums.length;
			while(flag == false){
				
				int index = list.indexOf(nums[length-1]);
				
				length --;
				
			}
			
			return 0;
		}
	public int[] solutionWithMap(int[] nums){
		if(!inputcheck(nums)){
			if(nums == null)return null;
			if(nums.length == 1) return nums;
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>(); 
		for(int i = nums.length-1; i >-1; i--){
			int cur = nums[i];
			while(cur<=9){
				cur++;
				if(map.containsKey(cur)){
					int[] res = swap(nums, i, map.get(cur));
					//return convertIntArrayToInt(res);
					return res;
				}	
				
			}
			map.put(nums[i], i);

		}
		
		return nums;
	}
	public int solutionWith(int[] nums){
		
		return 0;
	}
	
	public int[] solution(int[] nums){
		
		int output =0;
		for(int i = nums.length-1; i >-1; i --){
			int cur = nums[i];
			//from i to nums.length if some digital is larger than cur, swap them
			for(int x = nums[i]+1; x<9; x++){
				for(int j =  nums.length-1; j >i; j--){
					if(x==nums[j]){
						nums[j] = nums[i];
						nums[i] = x;						
						//return convertIntArrayToInt(nums);
						return nums;
					}
				}
			}
			

		}

	/*	
		int[] input = nums;
		int[] digitals = {0,1,2,3,4,5,6,7,8,9};
		
		//Point 1 int array to integer array
		//this is JDK1.7 type
		//List<Object> you  = Arrays.stream( input ).boxed().collect( Collectors.toList() );
		
		//JDK 1.8
		Integer[] what = Arrays.stream( input ).boxed().toArray( Integer[]::new );
		List<Integer> list  = Arrays.stream( input ).boxed().collect( Collectors.toList() );
		
		//Collections.sort(list);
		
		for (int i=input.length-2; i>0; i--){
			int curDigi = input[i];
			
			//find
			while(curDigi!=9){
				int next = curDigi+1;
				if(list.indexOf(next)>i){
					//swap i and index
					int temp = input[i];
					input[i]=input[list.indexOf(next)];
					input[list.indexOf(next)] = temp;
					
					StringBuilder output = new StringBuilder("");
					int j = 0;
					while(j<input.length){
						output.append(input[j]);
						j++;
					}
					return Integer.valueOf(output.toString());
				}else{
					
				}
			}
		}
		
		//Collections.sort(arrayList,new Comparator<Integer>);
		
		boolean flag= false;
		int length = nums.length;
		while(flag == false){
			
			int index = list.indexOf(nums[length-1]);
			
			length --;
			
		}
		*/
		return nums;
	}
	
	private int convertIntArrayToInt(int[] input){
		Long res = 0L;
		StringBuilder digis = new StringBuilder("1");
		
		for(int i = input.length-1; i>-1; i--){
			res = res+(long) (input[i]*Long.valueOf(digis.toString()));
			digis.append(0);
		}
		try{
			if(res<=Integer.MAX_VALUE&&res>=Integer.MIN_VALUE){
				return Integer.valueOf(res.intValue()); 
			}else{
				return 0;
			}
		}catch(NumberFormatException e){
			//System.out.println(e.toString());
			return -1;
		}
		
	}
	
	private int[] swap(int[] input,int A, int B){
		
		int temp = input[A];
		input[A] = input[B];
		input[B] = temp;
		return input;
	}
	
	private boolean inputcheck(int[] input){
		if(input == null)return false;
		if(input.length == 1) return false;
		
		return true;
	}
	public static void main(String[] args){
		
		int[] test = {6,7,5,3,5,6,2,9,1,2,7,0,9};
		//675356291279
		//6753562912709
		Q031 instance = new Q031();
		int[] output = instance.solutionWithMap(test);
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < test.length; i++){
			res.append(output[i]);
		}
		System.out.println(res.toString());
	}
}
