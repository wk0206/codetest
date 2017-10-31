package OnlyForTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
//import static net.Mildview.util.Range.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

class MyOperator<T> implements UnaryOperator<T>{  
	T varc1;  
	public T apply(T varc){  
		return varc1;  
	}  
} 

public class ListReplaceAllTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		ArrayList<String> color_list;  
		MyOperator<String> operator;  
		    
		color_list = new ArrayList<> ();  
		operator = new MyOperator<> ();  
		    
		operator.varc1 = "White";  
		    
		 // use add() method to add values in the list  
		color_list.add("White");  
		color_list.add("Black");  
		color_list.add("Red");  
		color_list.add("White");  
		color_list.add("Yellow");  
		color_list.add("White");  
		
		System.out.println("List of Colors");  
		System.out.println(color_list);  
		    
		 // Replace all colors with White color   
		color_list.replaceAll(operator);  
		System.out.println("Color list, after replacing all colors with White color :");  
		System.out.println(color_list);    
		
		System.out.println("------------------------");    
		
		List<String> tenisTournamnetNames = Arrays.asList("Wimbledon","French Open","Australian Open","US Open");
		 
		//will not work if list is unmodifiable
		List<String> tenisTournamnetList= new ArrayList<>(tenisTournamnetNames);
 
		//doesn't return anything
		tenisTournamnetList.replaceAll(String::toUpperCase);
 
		System.out.println(tenisTournamnetList.stream().collect(Collectors.joining(", ")));
	
		
		
	}
	
	public int lengthOfHashtable(Hashtable H){
		return H.size();
	}


}
