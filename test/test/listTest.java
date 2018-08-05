package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class listTest {
	
	//https://www.cnblogs.com/DreamDrive/p/5650438.html
	//https://blog.csdn.net/gongchuangsu/article/details/51527042
	//result: don't use for loop in LinkedList.
	//		 for loop not very different in ArrayList
	
	
	//https://stackoverflow.com/questions/1879255/performance-of-traditional-for-loop-vs-iterator-foreach-in-java?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
	//Iterator is faster for collections with no random access (e.g. TreeSet, HashMap, LinkedList).
	//For arrays and ArrayLists, performance differences should be negligible.
	//the Iterator is way better for all List implementations that do not implement RandomAccess (example: LinkedList).
	
	public static List<Integer> aList = new ArrayList<>();
	
	public static List<Integer> lList = new LinkedList<>();
	
	
	public static void main(String[] args) {
		aList.add(1);
		
		lList.add(1);
		
		for(int i = 0; i < 200000; i ++	) {
			aList.add(i);
			lList.add(i);
		}
		
		long start = System.currentTimeMillis();
		Iterator<Integer> iterator = lList.iterator();
		while(iterator.hasNext()){
		    iterator.next();
		}
		long end = System.currentTimeMillis();
		System.out.println("Iterator:" + (end - start) +" ms");
		
		
		start = System.currentTimeMillis();
		for(int i = 0; i < lList.size(); i++){
			lList.get(i);
		}
		end = System.currentTimeMillis();
		System.out.println("for:" + (end - start) +" ms");
		
		
		start = System.currentTimeMillis();
		for(Integer i : lList);
		end = System.currentTimeMillis();
		System.out.println("for2:" + (end - start) +" ms");
		
		LinkedList<Integer> temp1 = new LinkedList<>();
		temp1.addAll(lList);
		start = System.currentTimeMillis();
		while(temp1.size() != 0){
		    temp1.pollFirst();
		}
		end = System.currentTimeMillis();
		System.out.println("pollFirst()��pollLast():" + (end - start) +" ms");
		
		
		LinkedList<Integer> temp2 = new LinkedList<>();
		temp2.addAll(lList);
		start = System.currentTimeMillis();
		while(temp2.size() != 0){
		    temp2.removeFirst();
		}
		end = System.currentTimeMillis();
		System.out.println("removeFirst()��removeLast():" + (end - start) +" ms");
		
		
		
		
		
		
		
		Collections.emptyList();
		
		
		start = System.currentTimeMillis();
		Iterator<Integer> aiterator = aList.iterator();
		while(aiterator.hasNext()){
		    aiterator.next();
		}
		end = System.currentTimeMillis();
		System.out.println("Iterator:" + (end - start) +" ms");
		
		
		start = System.currentTimeMillis();
		for(int i = 0; i < aList.size(); i++){
			aList.get(i);
		}
		end = System.currentTimeMillis();
		System.out.println("for:" + (end - start) +" ms");
		
		
		start = System.currentTimeMillis();
		for(Integer i : aList);
		end = System.currentTimeMillis();
		System.out.println("for2:" + (end - start) +" ms");
		
		
		Collections.sort(aList);
		
		List list= new ArrayList(); 
		list.add(new Object()); 
		list.add(new Object()); 
		list.add(new Object()); 
		
//		ArrayList<Integer> atemp1 = new ArrayList<>();
//		atemp1.addAll(aList);
//		start = System.currentTimeMillis();
//		while(temp1.size() != 0){
//		    atemp1.pollFirst();
//		}
//		end = System.currentTimeMillis();
//		System.out.println("pollFirst()��pollLast():" + (end - start) +" ms");
//		
//		
//		LinkedList<Integer> temp2 = new LinkedList<>();
//		temp2.addAll(lList);
//		start = System.currentTimeMillis();
//		while(temp2.size() != 0){
//		    temp2.removeFirst();
//		}
//		end = System.currentTimeMillis();
//		System.out.println("removeFirst()��removeLast():" + (end - start) +" ms");
	}

}
