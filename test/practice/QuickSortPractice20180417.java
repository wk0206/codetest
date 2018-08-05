package practice;

import java.util.Arrays;

public class QuickSortPractice20180417 {

	static int count = 0;

	QuickSortPractice20180417() {

	}

	public static void QuickSortPractice20180417(int[] arr, int start, int end) {
		count++;
		System.out.println(start + ":" + end + ":\t" + Arrays.toString(arr));

		// input check
		if (start >= end || arr == null || arr.length <= 1) {
			return;
		}

		int i = start, j = end, pivot = arr[(start + end) / 2];

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}

			if (i < j) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				exchange(arr, i, j, start, end , pivot);
				i++;
				j--;

			} else if (i == j) {
				i++;
			}
		}

		QuickSortPractice20180417(arr, start, j);
		QuickSortPractice20180417(arr, i, end);

	}

	public static void exchange(int[] arr, int i, int j, int start, int end , int pivot) {

		//StringBuilder builder = new StringBuilder();
//		for (int index = 0; index < arr.length; index++) {
//			if (index == 0 && i != 0) {
//				builder.append(mode(1, " "));
//			} else if (index < i) {
//				builder.append(mode(1, replace(arr[index])));
//			} else if (index == i) {
//				builder.append(mode(2, replace(arr[index])));
//			} else if (index > i && index < j) {
//				builder.append(replace(arr[index]));
//			} else if (index == j) {
//				builder.append(mode(3, replace(arr[index])));
//			} else {
//				builder.append(mode(1, replace(arr[index])));
//			}
//
//		}
		
		
		String s =  Arrays.toString(arr);
		s = s.replaceAll("[0-9]", " ");
		StringBuilder builder = new StringBuilder(s);
		
		
		//System.out.println(start + ":" + end + ":\t" +s);
		int count =0;
		for (int index = 1; index < s.length()-1; index++) {

			if (count < i) {
				builder.setCharAt(index, ' ');
			} else if (count == i) {
				builder.setCharAt(index, '|');
			} else if (count > i && count < j) {
				builder.setCharAt(index, '_');
			} else if (count == j) {
				builder.setCharAt(index, '|');
			} else {
				builder.setCharAt(index, ' ');
			}
			if(s.charAt(index)==',')count++;
		}
//
		//System.out.println(start + ":" + end + ":\t[" + builder.toString() + "]");
		System.out.println(start + ":" + end + ":\t" + Arrays.toString(arr) +"   "+ pivot+"\t"+arr[i]+"\texchange\t"+arr[j]);
		System.out.println(start + ":" + end + ":\t" +builder.toString() );
	}

	private static String replace(int i) {
		if (i < 10) {
			return "___";
		} else {
			return "____";
		}
	}

	private static String mode(int m, String s) {
		switch (m) {
		case 1:
			return s.replace("_", " ");
		case 2:
			return "|" + s;
		case 3:
			return s + "|";
		default:
			return "";
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10 };
		QuickSortPractice20180417(arr, 0, arr.length - 1);
		String out = "";
		for (int digit : arr) {
			out += (digit + ",");
		}
		System.out.println("after " + count + " round");
		System.out.println(out);
	}
}
