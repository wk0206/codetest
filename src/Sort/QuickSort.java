package Sort;

import java.util.Arrays;

public class QuickSort {
	public static int count = 0;
	public static void QuickSort(int[] arr, int head, int tail){
		count++;
		System.out.println(head+":"+tail+":"+Arrays.toString(arr));
		if (head >= tail || arr == null || arr.length <= 1) {
	    	return;
        }
		 
		int i = head, j = tail, pivot = arr[(head + tail) / 2];
		
		 while (i <= j) {
	            while (arr[i] < pivot) {
	                ++i;
	            }
	            while (arr[j] > pivot) {
	                --j;
	            }
	            if (i < j) {
	                int t = arr[i];
	                arr[i] = arr[j];
	                arr[j] = t;
	                ++i;
	                --j;
	            } else if (i == j) {
	                ++i;
	            }
	        }
		 
		 QuickSort(arr, head, j);
		 QuickSort(arr, i, tail);
	}
	
	

	public static void main(String[] args) {
		int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
		QuickSort(arr, 0, arr.length - 1);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println("after "+count+ " round");
        System.out.println(out);
    }
}
