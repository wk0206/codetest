package Sort;

public class Qsort171204 {

	public static int count = 0;
	public static void Qsort(int[] input, int head, int tail){
		count++;
		System.out.println(head+":"+tail);
		if(head >= tail || input.length <= 1 || input == null) return ;
		
		int pivot = input[head];
		int left = head;
		int right = tail;
		
		while(left<=right){
			while(input[left]<pivot){
				++left;
			}
			while(input[right]>pivot){
				--right;
			}
			
			if(left<right){
				int t = input[left];
				input[left]= input[right];
				input[right] = t;
				++left;
				--right;
			}
			else if(left==right){
				++left;
			}
		}
		
		
		
		Qsort(input, head, right);
		Qsort(input, left, tail);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
		Qsort(arr, 0, arr.length - 1);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }

        System.out.println("after "+count+ " round");
        System.out.println(out);

	}

}
