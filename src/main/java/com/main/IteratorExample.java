package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class IteratorExample {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		List<Object[]> listOfArray = new ArrayList<Object[]>();
		list.add("ddd");
		list.add("zzz");
		
		
		//-----------------
		Object[] ob = {"no","name"};
		Object[] ob1 = {"1","XYZ"};
		Object[] ob2 = {"2","QWE"};
		
		listOfArray.add(ob);
		listOfArray.add(ob1);
		listOfArray.add(ob2);
		
		Iterator<Object[]> listItr1 = listOfArray.iterator();
		while(listItr1.hasNext())
		{
			System.out.println(Arrays.toString(listItr1.next()));
			//System.out.println(listItr1.next());
		}
		
			
		
		Iterator<Object> listItr = list.iterator();
		while(listItr.hasNext()) {
			System.out.println(listItr.next());
		}
		

	}

}
