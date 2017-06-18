package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q038 {
	/*
	public String solution(int n){
		StringBuilder curr=new StringBuilder("1");
    	StringBuilder prev;
    	int count;
    	char say;
        for (int i=1;i<n;i++){
        	prev=curr;
 	        curr=new StringBuilder();       
 	        count=1;
 	        say=prev.charAt(0);
 	        
 	        for (int j=1,len=prev.length();j<len;j++){
 	        	if (prev.charAt(j)!=say){
 	        		curr.append(count).append(say);
 	        		count=1;
 	        		say=prev.charAt(j);
 	        	}
 	        	else count++;
 	        }
 	        curr.append(count).append(say);
        }	       	        
        return curr.toString();
	}
	*/
	
	public String solution(int n){
		//n=1
		if(n==1) return "1";
		List<Integer> currentList = new ArrayList<>();
		
		List<List> res = new ArrayList<>();
		
		//int[] FirstList = {1,1};
		List<Integer> FirstList = Arrays.asList(1,1);
		
		res.add(FirstList);
		int[] cell = {0,0};//{key , count}
		System.out.println(res.size());	
		while(res.size()<=n){
			currentList = res.get(res.size()-1);
			List<Integer> newList = new ArrayList<>();

			for(int i =0; i < currentList.size();i++){
				if(i != currentList.size()-1){
					if(cell[0]==0){
						cell[0] = currentList.get(i);
						cell[1] = 1;
						continue;
					}
					
					if(cell[0]==currentList.get(i)){
						cell[1] = cell[1]+1;
					}else{
						newList.add(cell[1]);
						newList.add(cell[0]);
						cell[0] = 0;
						cell[1] = 0;
					}


				}
				else{
					if(cell[0]==0){
						cell[0] = currentList.get(i);
						cell[1] = 1;
						newList.add(cell[1]);
						newList.add(cell[0]);
						cell[0] = 0;
						cell[1] = 0;
						break;
					}else if(cell[0]==currentList.get(i)){
						cell[1] = cell[1]+1;
						newList.add(cell[1]);
						newList.add(cell[0]);
						cell[0] = 0;
						cell[1] = 0;
						break;
					}

				}
			}
			
			res.add(newList);
		}
		
		return res.get(res.size()-1).toString();
	}
	
	
	public String solution3(int n){
		//n=1
		if(n==1) return "1";

		List<Integer> FirstList = Arrays.asList(1);
		List<Integer> SecondList = Arrays.asList(1,1);
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> curList = new ArrayList<>();
		int key=0, count = 0;
		
		
		
		res.add(FirstList);
		//res.add(SecondList);
		
		while(res.size()<n){
			curList = res.get(res.size()-1);
			List<Integer> newList = new ArrayList<>();
			for(int i = 0; i < curList.size(); i++){
				if(key == curList.get(i)){
					count++;
				}else{
					//update
					if(key!=0){
						newList.add(count);
						newList.add(key);
						
							
					}
					
					key = curList.get(i);
					count = 1;
				}
				
				//last element , force to update
				if(i == curList.size()-1){
					//update
					newList.add(count);
					newList.add(key);
					
					key = 0;
					count = 0;
				}
			}
			
			res.add(newList);
		}
		StringBuilder output = new StringBuilder();
		for(int i = 0; i < res.get(n-1).toArray().length; i++){
			output.append(res.get(n-1).toArray()[i]);
		}
		return output.toString();
	}	
	public static void main(String[] args){
		
		Q038 instance = new Q038();
		
		int n = 5;
		while(n>0){
			System.out.println(instance.solution3(n));	
			n--;
		}
		
		
	}
}
