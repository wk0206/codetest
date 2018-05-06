package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q118 {
	
	public List<List<Integer>>  solution(int rnd) {
		
		if(rnd == 0) return new ArrayList<>();
		
		List<List<Integer>> res = new ArrayList<>();
		//List<Integer> r1 = Arrays.asList(new Integer[] {1});
		//res.add
		res.add( Arrays.asList(new Integer[] {1}));
		for(int i =1; i < rnd ; i++) {
			List<Integer> current = res.get(res.size()-1);
			List<Integer> temp = new ArrayList<>(current.size()+1);
			temp.add(1);
			for(int j = 0; j< current.size()-1; j++) {
				int p1 = current.get(j);
				int p2 = current.get(j+1);
				
				temp.add(p1+p2);
			}
			
			temp.add(1);
			
			res.add(temp);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Q118 instance = new Q118();
		instance.solution(5).forEach(i->System.out.println(i.toString()));;

	}

}
