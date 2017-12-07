package Sort;

import java.util.Arrays;

public class MergeSort171130 {
	
	public static int round = 0;
	public int[] Merge(int[] item1, int[] item2){
		round++;
		System.out.println("round "+round);
		System.out.println(Arrays.toString(item1));
		System.out.println(Arrays.toString(item2));
		int len = item1.length + item2.length;
		int i = 0;
		int j = 0;
		int index = 0;
		int[] res = new int[len];
		
		while(index < len){
			if(i < item1.length && j < item2.length){
				if(item1[i]<item2[j]){
					res[index]= item1[i];
					i++;
					index++;
				}
				else{
					res[index]= item2[j];
					j++;
					index++;
				}
			}
			
			if(i >= item1.length){
				res[index] = item2[j];
				j++;
				index++;
				continue;
			}
			if(j >= item2.length){
				res[index] = item1[i];
				i++;
				index++;
				continue;
			}
		}
		System.out.println(Arrays.toString(res));
		return res;
	}
	
	public int[] MergeSort(int[] item){
		if(item.length==1) return item;
		
		int middle = item.length/2;
		int[] left = new int[middle];
		int[] right = new int[item.length-middle];
		
		for(int i = 0 ; i < left.length ; i++){
			left[i]	= item[i];
		}
		
		for(int i = 0 ; i < right.length ; i++){
			right[i]	= item[middle+i];
		}
		
		return Merge(MergeSort(left),MergeSort(right));
	}

	
	public static void main(String[] args){
		MergeSort171130 instance = new MergeSort171130();
		
		int[] input = new int[]{8,2,7,4,15,6,9};
		int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
		
		int[] res = instance.MergeSort(arr);
		
		System.out.println(Arrays.toString(res));
	}
}
