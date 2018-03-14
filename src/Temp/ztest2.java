package Temp;

public class ztest2 {

	public static int solution(String s) {
		// input check
		if (s.length() % 2 != 0)
			return 0;

		// set parameter
		int group = 0;
		int pair = 0;
		int len = s.length();

		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == 'L') {
				pair++;
				System.out.print("L");
			}
			if (s.charAt(i) == 'R') {
				pair--;
				System.out.print("R");
			}

			if (pair == 0) {
				group++;
				System.out.println("");
				System.out.println("---");
			}
		}

		return group;
	}

	public static void main(String[] args) {
		System.out.println(solution("RLRRLL") + " worker needed");

		System.out.println(solution("RLLLRRRLLR") + " worker needed");

		System.out.println(solution("RLRRLLRLRRLL") + " worker needed");
	}
}
