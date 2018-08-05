package Sort;

import java.util.Arrays;

public class BubbleSort {
	
	public int[] BubbleSort(int[] item){
		int temp = 0;
		for(int i = 0; i < item.length-1; i++){
			if(item[i]>item[i+1]){
				temp = item[i];
				item[i]=item[i+1];
				item[i+1]=temp;				
			}
		}
		
		return item;
	}

	
	public static void main(String[] args){
		BubbleSort instance = new BubbleSort();
		
		int[] input = new int[]{8,2,3,4,5,6,9};
		int[] res = instance.BubbleSort(input);
		
		System.out.println(Arrays.toString(res));
	}

}
