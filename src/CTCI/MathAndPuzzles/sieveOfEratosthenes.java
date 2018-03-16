package CTCI.MathAndPuzzles;

import java.util.Arrays;

public class sieveOfEratosthenes {
	
	public boolean[] solution(int max) {
		if(max<2) return null;
		
		boolean[] flags = new boolean[max+1];
		Arrays.fill(flags , true);
		flags[0]=false;
		flags[1]=false;
		
		int prime = 2;
		
		while(prime < Math.sqrt(max)) {
			crossOff(flags, prime);
			
			prime = getNextPrime(flags, prime);
		}
		
		return flags;
		
	}
	
	public void crossOff(boolean[] flags, int prime) {
		for(int i = prime * prime; i < flags.length; i+=prime) {
			flags[i] = false;
		}
	}
	
	public int getNextPrime(boolean[] flags , int prime) {
		int next = prime+1;
		while(next<flags.length &&!flags[next]) {
			next++;
		}
		
		return next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int input = (int) Math.pow(2, 30);
		input = 2047483640;
		sieveOfEratosthenes instance = new sieveOfEratosthenes();
		boolean[] res = instance.solution(input);
		//System.out.print(Arrays.toString(instance.solution(input)));
		for(int i = res.length-1; i >0; i--) {
			if(res[i]==true) {
				System.out.println(i);
				break;
			}
			//break;
		}
		
		
	}

}
