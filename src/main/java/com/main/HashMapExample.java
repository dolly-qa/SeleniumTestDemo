package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> data = new HashMap<String, String>();
		List<Object[]> list = new ArrayList<Object[]>();
		//List<String[]> list = new ArrayList<String[]>();
		data.put("1", "DDD");
		data.put("2", "sss");
		data.put("3", "rrrr");
		data.put("4", "www");
		data.put("5", "bbb");
		data.put("6", "ggg");
		
		
		/* 
		 * First way to iterate
		 */
		Iterator<Entry<String, String>> it = data.entrySet().iterator();
		
		while(it.hasNext())
		{
			 System.out.println(it.next());

		}
		
		/* 
		 * Second way to iterate
		 */
		Iterator iterator = data.entrySet().iterator();
		while(iterator.hasNext())
		{
			 Map.Entry me2 = (Map.Entry) iterator.next();
	         System.out.println("Key: "+me2.getKey() + " & Value: " + me2.getValue());
			
		}
	
		
		/* 
		 * Using List Iterator to iterate
		 */
		list.add(new Object[] {data} );
		for(int i=1; i<=3; i++)
		{
			list.add(new Object[] {data} );
		}
			//int s = j;
			
			System.out.println(data);
			//list.add(data);
//			Object[] s1 = { data };
//			list.add(s1);
//			list.add(new String[] {data});
			
			//list.add(new Object[] { testData });
		
		
		//list.add(new Object[] {data});
	
		for(Object[] ob : list)
		{
			//System.out.println("this...." + list.listIterator());
			System.out.println("this is list: " + Arrays.toString(ob));
		}
		
		
		
		//System.out.println(list);
		
}

}
