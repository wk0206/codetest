package redis;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;


public class test{
	public static void main(String[]args){

		Jedis jedis=new Jedis("localhost");
		System.out.println("Connection to server sucessfully");

		System.out.println("Server is running:"+jedis.ping());
		//System.out.println("Server is running:"+jedis.ping());
		

		jedis.set("tutorial-name", "Redis tutorial"); 
		System.out.println("Stored string in redis:: "+ jedis.get("tutorial-name")); 
		
		
		jedis.lpush("tutorial-list", "Redis"); 
	    jedis.lpush("tutorial-list", "Mongodb"); 
	    jedis.lpush("tutorial-list", "Mysql"); 
	    List<String> list = jedis.lrange("tutorial-list", 0 ,5); 
	    
	    for(int i = 0; i<list.size(); i++) { 
	        System.out.println("Stored string in redis:: "+list.get(i)); 
	    } 
	      
	    Set<String> list2 = jedis.keys("*"); 

	    
	    Iterator it = list2.iterator();
	    while(it.hasNext()){
	    	System.out.println("List of stored keys:: "+it.next()); 
	    }

	}
}
