package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class streamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> a = new ArrayList<>();
		Arrays.asList(a);
		
		int[] array = new int[4];
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		array[3] = 3;
		
		
		
		List<Integer> intA = new ArrayList<>();
		intA.add(0);
		intA.add(1);
		intA.add(2);
		intA.add(3);
		
		intA.stream().mapToDouble(item->item).forEach(System.out::println);
		
		
		Stream.of(1,2,3,4,5).map(item->item*item).forEach(System.out::println);;
	}

}
