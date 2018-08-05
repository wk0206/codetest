package Sort;

import java.util.Arrays;

public class MergeSort171204 {

	
	public int[] MergeSort(int[] item){
		if(item.length<2)return item;
		
		int middle = item.length/2;
		int[] left = new int[middle];
		int[] right = new int[item.length-middle];
		
		for(int i = 0; i < middle ; i ++){
			left[i] = item[i];
		}
		
		for(int i = 0; i < item.length-middle ; i ++){
			right[i] = item[middle+i];
		}
		
		return Merge(MergeSort(left),MergeSort(right));
	}
	
	public int[] Merge(int[] item1, int[] item2){
		
		int len1 = item1.length;
		int len2 = item2.length;
		
		int len = len1+len2;
		int i = 0;
		int lf = 0;
		int rf = 0;
		int[] res = new int[len];
		while (i < len){
			if(lf < len1 && rf < len2){
				if(item1[lf] < item2[rf]){
					res[i] = item1[lf];
					i++;
					lf++;
				}else{
					res[i] = item2[rf];
					i++;
					rf++;
				}
			}
			
			if(lf>=len1){
				res[i] = item2[rf];
				rf++;
				i++;
				continue;
			}
			
			if(rf>=len2){
				res[i] = item1[lf];
				lf++;
				i++;
				continue;
			}
			
		}
		
		
		return res;
	}
	
	public static void main(String[] args) {
		MergeSort171204 instance = new MergeSort171204();
		
		int[] input = new int[]{8,2,7,4,15,6,9};
		int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
		
		int[] res = instance.MergeSort(arr);
		
		System.out.println(Arrays.toString(res));

	}

}
