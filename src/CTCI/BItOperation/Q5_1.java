package CTCI.BItOperation;

public class Q5_1 {

	public int solution(int M, int N, int i, int j) {
		//to be insert
		int insertMask = (N << i);

		int clearIntervalMask =  (-1 << (j+1));

		int lastBit = ((0 << i)) | M;

		return (M & clearIntervalMask) | insertMask | lastBit;
	}

	public static void main(String[] args) {
		Q5_1 instance = new Q5_1();
		Double d = Math.pow(2, 11);
		Integer i = d.intValue();
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(19));
		Integer res = instance.solution(d.intValue(), 19, 2, 6);
		
		System.out.println(Integer.toBinaryString(res));
	}
}

