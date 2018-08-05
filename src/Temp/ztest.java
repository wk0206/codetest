package Temp;

public class ztest {
	public static int solution(int N, int K) {
		// input check
		if (N == 1) return 1;
		if(K>100) return 0;
		if(N>Math.pow(2, 32)-1) return 0;	

		// set parameter
		
		int Kcount = K;
		int round = 0;
		System.out.println("final         -->" + N);


		while (N > 1) {
			if (Kcount > 0) {
				if (N % 2 == 0) {
					N = N / 2;
					Kcount--;
					round++;
					System.out.println("he bet all in -->" + N);
				} else {
					N = N - 1;
					round++;
					System.out.println("he bet 1      -->" + N);
				}
			}else {
				round += N;
			}
		}
		return round;
	}

	public static void main(String[] args) {
		ztest t = new ztest();
		System.out.println(t.solution(112308,1) + " round needed");
	}

}
