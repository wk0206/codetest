package mid;

public class Q537 {
	public String complexNumberMultiply(String a, String b) {
		int[] c1 = stringToComplex(a);
		int[] c2 = stringToComplex(b);

		int[] res = multiplyComplex(c1, c2);

		StringBuilder builder = new StringBuilder();
		builder.append(c1[0] * c2[0] - c1[1] * c2[1]);
		builder.append("+");
		builder.append(c1[0] * c2[1] + c1[1] * c2[0]);
		builder.append("i");
		
		return builder.toString();
//		String s = res[0] + "+" + String.valueOf(res[1]) + "i";
//		System.out.println(s);
//		return s;
	}

	private int[] stringToComplex(String s) {

		int plus = s.indexOf("+");
		int i = s.indexOf("i");
		int[] res = new int[2];

		res[0] = Integer.valueOf(s.substring(0, plus));
		res[1] = Integer.valueOf(s.substring(plus+1, i));

		return res;
	}

	
	public int[] getVal(String a)
    {
        String[] x = a.split("\\+");
        
        int[] val = new int[2];
        val[0] = Integer.parseInt(x[0]);
        
        val[1] = Integer.parseInt(x[1].replace("i",""));
        
        return val;
    }
	
	private int[] multiplyComplex(int[] c1, int[] c2) {
		int[] res = new int[2];

		res[0] = c1[0] * c2[0] - c1[1] * c2[1];
		res[1] = (c1[0] * c2[1] + c1[1] * c2[0]);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Q537 instance = new Q537();

		String a = "1+-1i";
		String b = "1+-1i";
		instance.complexNumberMultiply(a, b);

	}

}
