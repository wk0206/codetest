package CTCI.OOD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q7_1 {

	public static void solution() {
		Map<Character, Integer> m = new HashMap();

		m.putIfAbsent('1', 2);

		m.replace('1', 3);

		m.replace('1', 3, 4);

		m.getOrDefault('2', 9);

		m.putIfAbsent('2', 6);

		m.putIfAbsent('3', 8);

		m.putIfAbsent('4', 9);

		m.putIfAbsent('5', 10);

		m.computeIfAbsent('1', key -> 999);

		m.computeIfAbsent('6', key -> 999);

		m.forEach((key, value) -> System.out.println(Integer.valueOf(key.toString())));
		m.forEach((key, value) -> System.out.println(value));
		m.forEach((key, value) -> System.out.println(Integer.valueOf(key) + value));

	}

	public enum color {
		diamond, spade, heart, club
	}

	public enum number {
		one("A", 1), two("2", 2), three("3", 3), four("5", 4), five("5", 5), six("6", 6), seven("7", 7), eight("8",
				8), nine("9", 9), ten("J", 10), eleven("Q", 11), twelve("K", 12);
		private String name;
		private int index;

		private number(String name, int index) {
			this.name = name;
			this.index = index;
		}

	}

	public static class cards {
		private color c;
		private number n;

		private cards(color c, number n) {
			this.c = c;
			this.n = n;
		}
	}

	public static class deck {
		private static deck _instance = null;

		public static deck getInstance() {
			if (_instance == null) {
				_instance = new deck();
			}
			return _instance;
		}

		//cards[] aDeck = new cards[52];
		ArrayList<cards> aDeck = new ArrayList();
		private color c;
		private number n;

		private deck() {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 12; j++) {
					aDeck.add( new cards(c.valueOf(String.valueOf(i)), n.valueOf(String.valueOf(j))));
				}
			}
		}

		private void rnd() {

		}
		
		private boolean isEmpty() {
			return aDeck.isEmpty();
		}
	}

	public class player {
		ArrayList<cards> cardsInHand = new ArrayList();
		boolean finish = false;
		private int sum = 0;

		public int getSum() {
			return this.sum;
		}

		public void getCard(cards aCard) {
			cardsInHand.add(aCard);
			addNumber();
		}

		private void addNumber() {
			sum += cardsInHand.get(cardsInHand.size()).n.index;
		}

		private void clear() {
			cardsInHand.clear();
			sum = 0;
		}
		
		private void win() {
			if (sum==21) {
				System.out.println("win game");
				this.clear();
			}
		}
	}

	public void checkWin(player[] p) {
		int[] res = new int[p.length];
		boolean flag = false;
		for(int i = 0 ; i < p.length; i++) {
			res[i] = p[i].sum;
		}
		
		for(int i = 0 ; i < p.length; i++) {
			if(res[i]==21) {
				flag = true;
				System.out.println("winner" + i);
			}
		}
		
		if(flag == false	) {
			int winner = 0;
			int min = 0;
			for(int i = 0 ; i < p.length; i++) {
				if(res[i]>21)continue;
				if(21-res[i]<min) {
					min = 21-res[i];
					winner = i;
				}
			}
		}
	}
	
	public player makPlayer(){
        player p = new player();
        return p;
    }
	
	public static void main(String[] args) {
		solution();

		 Q7_1 i = new Q7_1();

		deck d = new deck();

		// random deck
		d.rnd();
	

		player p1 = i.makPlayer();
		player p2 = i.makPlayer();
		player p3 = i.makPlayer();
		player p4= i.new player();
		Q7_1.player p5 = new Q7_1().new player();
		while(!d.isEmpty()) {
			
		}
	}

}
