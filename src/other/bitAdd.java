package other;

public class bitAdd {

	public int bitAdd(int a, int b){

		if(b==0)return a;
		int sum = a^b;
		int carry = (a&b)<<1;
		
		int res = bitAdd(sum, carry);

		return res;
	}
}
