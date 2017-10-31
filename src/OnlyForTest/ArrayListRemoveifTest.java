package OnlyForTest;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.function.Predicate;
//import static net.Mildview.util.Range.*;

public class ArrayListRemoveifTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    list.removeIf(s -> s%2==0);               // 过滤掉模2等于0的数
	    list.forEach(s -> System.out.println(s));
		//Arrays.parallelPrefix(a, )
		
		
	    List<String> strings = new ArrayList<>();
	    strings.add("ab");
	    strings.add("ac");
	    strings.add("bc");
	    strings.add("cd");
	    Predicate<String> predicate = (s) -> s.startsWith("a"); // 这里单独定义了过滤器
	    strings.removeIf(predicate);                            // 过滤掉以"a"开头的元素
	    strings.forEach(s -> System.out.println(s));
		
		//output
		//System.out.println(test.toString());
		//System.out.println(test.size());
		
		
	}
	
	public int lengthOfHashtable(Hashtable H){
		return H.size();
	}


}
