package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Q127 {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		List<String> Queue = new ArrayList<>();
		int rnd = 1;
		Queue.add(beginWord);

		while (!wordList.isEmpty()) {
			rnd++;
			List<String> TempQ = new ArrayList<>();
			for (String s : Queue) {
				for (String t : wordList) {

					if (differ(s, t)) {
						TempQ.add(t);
					}
				}
			}
			if (TempQ.contains(endWord))
				return rnd;

			if (TempQ.size() == 0)
				return -1;
			Queue.clear();
			Queue.addAll(TempQ);
			wordList.removeAll(TempQ);
			TempQ.clear();
		}

		return -1;
	}

	public static int solutionWithArray(String beginWord, String endWord, List<String> wordList) {
		List<String> Queue = new ArrayList<>();
		int rnd = 1;
		Queue.add(beginWord);

		while (!wordList.isEmpty()) {
			rnd++;
			// List<String> TempQ = new ArrayList<>();
			String[] TempQ = new String[beginWord.length()];
			int index = 0;
			for (String s : Queue) {
				for (String t : wordList) {
					if (s == "")
						continue;
					if (differ(s, t)) {
						// TempQ.add(t);
						TempQ[index] = t;
						index++;
					}
				}
			}
			for (String s : TempQ) {
				if (s == endWord)
					return rnd;
			}
			// if (TempQ.contains(endWord))
			// return rnd;

			// if (TempQ.size() == 0)
			// return -1;
			int count = 0;
			for (String s : TempQ) {
				if (s != "")
					count++;
			}
			if (count == 0)
				return 0;
			Queue.clear();
			Queue.addAll(new ArrayList<>(Arrays.asList(TempQ)));
			wordList.removeAll((new ArrayList<>(Arrays.asList(TempQ))));
			Arrays.fill(TempQ, "");
		}

		return 0;
	}

	// from leetcode
	// 先来写一个单向查找：BFS。先把beginWord加进来，dist初始值设为1. poll，然后把所有edit
	// distance为1且在dict里面的都加进来，同时把dict里面的这个词remove，起到mark
	// visited的作用。如果poll出来的又endWord，则返回当前的distance。如果queue空了还是没有找到endWord，说明不可能找到了。返回0.
	public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		// corner case
		if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0)
			return 0;

		// dict preprocessing: list --> set
		Set<String> dict = new HashSet(wordList);
		if (!dict.contains(endWord))
			return 0; // 又一个corner case：如果endWord不在dict里，直接就不要做了。

		Queue<String> queue = new LinkedList();
		queue.offer(beginWord);
		int dist = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				String curr = queue.poll();
				if (curr.equals(endWord))
					return dist;

				char[] chars = curr.toCharArray();
				for (int i = 0; i < chars.length; i++) { // 找到valid nexts，并加到queue里面。
					char cache = chars[i]; // cache, for setting back
					for (char ch = 'a'; ch <= 'z'; ch++) {
						if (ch == cache)
							continue;
						chars[i] = ch;
						String next = String.valueOf(chars);
						if (dict.contains(next)) {
							queue.offer(next);
							dict.remove(next);
						}
					}
					chars[i] = cache; // set back
				}
			}
			dist++;
		}

		return 0;
	}

	public static boolean differ(String s1, String s2) {
		int dif = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				dif++;
		}

		if (dif == 1)
			return true;

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = new String[] { "hot", "dot", "dog", "lot", "log", "cog" };

		Long start = System.currentTimeMillis();
		int res = ladderLength2(beginWord, endWord, new ArrayList<String>(Arrays.asList(wordList)));
		Long end = System.currentTimeMillis();
		System.out.println(res);
		System.out.println(end-start);
		

	}

}
