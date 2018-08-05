package CTCI.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class Q2_5 {
	
	public static void main(String[] args) {
		Map<String, Integer> words = new HashMap<>();
		words.put("hello", 3);
		words.put("world", 4);
		words.computeIfPresent("hello", (k, v) -> v + 1);
		System.out.println(words.get("hello"));
		
		words.forEach((key, value) -> System.out.println(key + value));
	}
	

}
