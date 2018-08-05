package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Q030 {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();

		// 1.input check
		if (s.length() == 0)
			return new ArrayList();
		if (words.length == 0)
			return new ArrayList();
		int wLength = words[0].length();

		if (s.length() < wLength)
			return new ArrayList();

		for (String word : words) {
			if (word.length() != wLength)
				return new ArrayList();
		}
		// 2.sbustring into TWL length
		int index = 0;
		HashMap<Integer, String> wMap = new HashMap<>();
		while (index + wLength * words.length <= s.length()) {
			wMap.put(index, s.substring(index, index + wLength * words.length));
			index++;
		}

		// 3.0
		HashMap<String, Integer> wordsToMap = new HashMap<>();
		for (String word : words) {
			wordsToMap.put(word, wordsToMap.getOrDefault(word, 0) + 1);
		}

		// 3.compare n times TWL with words
		HashMap<String, Integer> cMap = new HashMap<>();
		Iterator it = wMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> pair = (Map.Entry) it.next();
			String currentString = pair.getValue();

			// compare this 'currentString' with 'words'

			// 3.1. cut currentString put into cMap
			for (int i = 0; i < words.length; i++) {
				String word = currentString.substring(0 + i * wLength, (1 + i) * wLength);
				cMap.put(word, cMap.getOrDefault(word, 0) + 1);
			}
			// 3.2 compare
			if (cMap.equals(wordsToMap)) {
				res.add(pair.getKey());

			}
			cMap.clear();
		}

		return res;
	}

	public static List<Integer> solution2(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if(words == null || words.length == 0 || s.length() == 0) return res;
        int wordLen = words[0].length();
        int numWord = words.length;
        int windowLen = wordLen * numWord;
        int sLen = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        for(int i = 0; i < wordLen; i++) {  // Run wordLen scans
            HashMap<String, Integer> curMap = new HashMap<>();
            for(int j = i, count = 0, start = i; j + wordLen <= sLen; j += wordLen) {  // Move window in step of wordLen
                // count: number of exceeded occurences in current window
                // start: start index of current window of size windowLen
                if(start + windowLen > sLen) break;
                String word = s.substring(j, j + wordLen);
                if(!map.containsKey(word)) {
                    curMap.clear();
                    count = 0;
                    start = j + wordLen;
                }
                else {
                    if(j == start + windowLen) { // Remove previous word of current window
                        String preWord = s.substring(start, start + wordLen);
                        start += wordLen;
                        int val = curMap.get(preWord);
                        if(val == 1) curMap.remove(preWord);
                        else curMap.put(preWord, val - 1);
                        if(val - 1 >= map.get(preWord)) count--;  // Reduce count of exceeded word
                    }
                    // Add new word
                    curMap.put(word, curMap.getOrDefault(word, 0) + 1);
                    if(curMap.get(word) > map.get(word)) count++;  // More than expected, increase count
                    // Check if current window valid
                    if(count == 0 && start + windowLen == j + wordLen) {
                        res.add(start);
                    }
                }
            }
        }
        return res;

	}

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = { "foo", "bar" };
		// String s = "a";
		// String[] words= {};

		System.out.print(solution2(s, words).toString());
	}
}