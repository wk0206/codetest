package easy;


//Climbing Stairs
public class Q070 {
	
	//fibnacchi 
	//only two ways to get n
	//from n-1
	//from n-2 
	//forget you can reach n from n-2 by two*1 step
	//this is covered by "from n-1"
	//so get n = (n-1)+(n-2)
	//then for N=n+1
	//the previous n now is N-1
	//the previous n-1 now is N-2
	//the previous n-2 is abandoned	
    public int climbStairs(int n) {
        if(n==0||n==1||n==2) return n;
        
        int one_step=2;
        int two_step=1;
        int sum = 0;
        
        for(int i = 2; i < n; i++){
        	sum = one_step+two_step;
        	two_step=one_step;
        	one_step=sum;
        }
    	
    	return sum;
    }
}
