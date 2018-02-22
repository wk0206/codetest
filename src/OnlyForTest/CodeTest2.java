package OnlyForTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.function.IntBinaryOperator;
//import static net.Mildview.util.Range.*;

public class CodeTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		
		//test: hold all key and value
		Hashtable <String , Integer> test = new Hashtable<String, Integer>();
		
		//put first value
		test.put("1", 1);
		
		//repeat put value, from 0 to 100
		for(int i=0 ; i<100 ; i++){
			test.put(String.valueOf(i), i);
		}
		System.out.println("--------------");
		int[] a = new int[10];
		Arrays.fill(a, 0);
		for(int i = 0 ; i < 10; i++){
			a[i]=i;
		}
		System.out.println(Arrays.toString(a));
		
		System.out.println("--------------");
		String S = "test";
		System.out.println(Arrays.binarySearch(a, 4));
		Arrays.parallelPrefix(a, new IntBinaryOperator()
        {
			//left代表数组前一个索引处的元素，计算第一个元素时，left为1
            //right代表数组中当前索引处的元素
            public int applyAsInt(int left,int right)
            {
                return (left-right)*2;
            }
        });
		
		System.out.println(Arrays.toString(a));
		
		ArrayList<Integer> tes = new ArrayList<Integer>();
		
		//Arrays.parallelPrefix(a, )
		
		

		
		//output
		//System.out.println(test.toString());
		//System.out.println(test.size());
		
		
	}
	
	public int lengthOfHashtable(Hashtable H){
		return H.size();
	}


}
