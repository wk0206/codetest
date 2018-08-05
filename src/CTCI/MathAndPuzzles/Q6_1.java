package CTCI.MathAndPuzzles;

import java.util.Arrays;
import java.util.Random;

public class Q6_1 {
	public static int solution(boolean[] pills) {

		float sum = 0;
		for (int i = 0; i < pills.length; i++) {
			if (pills[i] == false) {
				sum += (i + 1) * 1.0f;
			} else {
				sum += (i + 1) * 1.1f;
			}
		}

		Float temp = (sum - 1.0f * 210) / 0.1f;
		int number = Math.round(temp);

		System.out.println("in number which is start from 1 :" + number);
		return number;

	}

	public static void main(String[] args) {
		boolean[] pills = new boolean[20];
		Arrays.fill(pills, false);
		int max = 20;
		int min = 0;
		int rand = (new Random().nextInt(max-min)) + min;
		System.out.println("in array which is start from 0 :" + rand);
		pills[rand] = true;
		for(int i = 0; i < 200; i ++) {
			//System.out.println((new Random().nextInt(max-min)) + min);
		}
		
		solution(pills);
	}
}
