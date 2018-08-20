package leetcode.hard;

import java.util.Stack;

public class Q84 {

	public static void solution() {

	}

	public static int largestRectangleArea(int[] heights) {
		// validate input
		if (heights == null || heights.length == 0) {
			return 0;
		}

		// init
		int n = heights.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int result = 0;

		// build left
		left[0] = 0;
		for (int i = 1; i < n; i++) {
			int currentLeft = i - 1;
			while (currentLeft >= 0 && heights[currentLeft] >= heights[i]) {
				currentLeft = left[currentLeft] - 1;
			}

			left[i] = currentLeft + 1;
		}

		// build right
		right[n - 1] = n - 1;
		for (int i = n - 2; i >= 0; i--) {
			int currentRight = i + 1;
			while (currentRight < n && heights[i] <= heights[currentRight]) {
				currentRight = right[currentRight] + 1;
			}

			right[i] = currentRight - 1;
		}

			// compare height
			for (int i = 0; i < n; i++) {
				result = Math.max(result, (right[i] - left[i] + 1) * heights[i]);
			}

		// return
		return result;
	}

	public static int solution(int[] heights) {
        //solution from leetcode
        if(heights==null) return 0;
        if(heights.length==1) return heights[0];
        
        int length  = heights.length;
        int max = 0;
        int[] left = new int[length];
		int[] right = new int[length];

        
        //build left
        left[0]=0;
        for (int i = 1; i <length; i++) {
			int currentLeft = i - 1;
			while (currentLeft >= 0 && heights[currentLeft] >= heights[i]) {
				currentLeft = left[currentLeft] - 1;
			}

			left[i] = currentLeft + 1;
		}
        
        
        //build right
        right[length - 1] = length - 1;
		for (int i = length - 2; i >= 0; i--) {
			int currentRight = i + 1;
			while (currentRight < length && heights[i] <= heights[currentRight]) {
				currentRight = right[currentRight] + 1;
			}

			right[i] = currentRight - 1;
		}
        
        // compare height
		for (int i = 0; i < length; i++) {
			max = Math.max(max, (right[i] - left[i] + 1) * heights[i]);
		}
        
        return max;
        
	}
	
	public static int statkSolution(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
	
	public static void main(String[] args) {
		//Q084 instance = new Q084();
		statkSolution(new int[] {2,1,5,6,2,3});
	}

}
