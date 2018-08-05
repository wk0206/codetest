package Sort;

public class MergeSort {

	public MergeSort() {
		
	}

	public int[] merge(int[] left, int[] right){
		int[] res= new int[left.length+right.length];
		int i = 0;
		int lp = 0, rp =0;
		while(i < left.length+right.length){
			if(lp<left.length && rp<right.length){
				if(left[i] < right[i]){
					res[i]=left[i];
					lp++;
					i++;				
				}else {
					res[i]=right[i];
					rp++;
					i++;
				}	
			}else{
				if(lp>=left.length){
					while (rp < right.length) {
                        res[i] = right[rp];
                        i++;
                        rp++;
                    }
				}
				
				if(rp>=right.length){
					while (lp < left.length) {
                        res[i] = left[lp];
                        i++;
                        lp++;
					}
				}
			}
			
		}
		
		
		return res;
	}
	
	public int[] mergeSort(int[] item){
		if(item.length<=1)return item;
		
		int middle = Math.floorDiv(item.length, 2);
		int[] left = new int[middle];
		int[] right = new int[item.length-middle];
		for(int i = 0; i < middle; i++){
			left[i] = item[i];
		}
		for(int i = middle; i < item.length; i++){
			right[i] = item[i];
		}
				
		return merge(mergeSort(left), mergeSort(right));

	}
	
	static Integer[] intToInteger(int[] item){
		Integer[] res = new Integer[item.length];
		
		for(int i = 0;i < item.length; i++){
			res[i] = Integer.valueOf(item[i]);
		}
		
		return res;
	}
}
