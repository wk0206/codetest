package mid;

import java.util.HashMap;
import java.util.Map;

public class Q343 {
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int integerBreak(int n) {
        if(n == 1)return 1;
      
        if(map.containsKey(n)){
          return map.get(n);
        }
      
        int res = 0;
      
        for (int i = 1; i <= n-1; i ++){
          res = Math.max(res, Math.max(i*(n-i), i*integerBreak(n-i)));
        }
      
        map.put(n, res);
      
        return res;
    }
    public static int integerBreak2(int n) {
    	int[] dp = new int[n+1];
    	dp[1]=1;
    	for(int i = 1; i <= n; i++) {
    		for(int j = 1; j < i; j++) {
    			int a= j*(i-j);
    			int b = j* dp[i-j];
    			dp[i] = Math.max(dp[i],Math.max(a, b));
    		}
    	}
    	
    	return dp[n];
    }
    
    public static void main(String[] args) {
    	Long start = System.currentTimeMillis();
    	System.out.println(integerBreak(150));
    	Long mid = System.currentTimeMillis();
    	System.out.println(integerBreak2(150));
    	Long end = System.currentTimeMillis();
    	
    	System.out.println(mid-start);
    	System.out.println(end-mid);

    }
    
}
