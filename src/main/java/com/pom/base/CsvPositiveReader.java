package com.pom.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;

public class CsvPositiveReader {
	
		@DataProvider(name = "csvPositiveReader")
//		public static Iterator<Object[]> csvPositiveReader(){
//			List<Object[]> list = new ArrayList<Object[]>();
//			String path = "/Users/maharshi/eclipse-workspace/selenium-for-beginner/src/test/resources/DataProvider/PositiveLoginTests/PositiveLoginTest.csv";
//			File file = new File(path);
//			try {
//				CSVReader csvReader = new CSVReader(new FileReader(file));
//				try {
//					String[] coloums = csvReader.readNext();
//					System.out.println(coloums);
//					String[] rows;
//					while((rows = csvReader.readNext()) != null) {
//						//Map<String,String> testData = new HashMap<String, String>();
//						Map<String,String> testData = new HashMap<>();
//						for(int i = 0; i<coloums.length;i++) {
//							testData.put(coloums[i], rows[i]);
//							//System.out.println(testData);
//						}
//						//System.out.println("this is test data: " + testData);
//						Object[] t = { testData };
//						
//						//list.add(testData);
//						list.add(t);
//						//(System.out.println("this is list: " + t);
////						for(Map.Entry<String,String> m : testData.entrySet()) {
////							System.out.println("Key: "+ m.getKey() + " and Value: " + m.getValue());
////						}
//						
////						
////						for(Object l: t) {
////							System.out.println("List : " + l);
////						}
//					}
//					for(Object[] li : list) {
//						for(Object l: li) {
//							System.out.println("List : " + l);
//						}
//						//System.out.println("List : " + li + "/n");
//					}
//					csvReader.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			return list.iterator();
//			
//		}
		//public static Iterator<Object[]> csvPositiveReader(){
		public Iterator<Object[]> csvPositiveReader(){
			List<Object[]> list = new ArrayList<Object[]>();
			String path = "/Users/maharshi/eclipse-workspace/seleniumProject/src/test/resources/DataProvider/PositiveLoginTests/PositiveLoginTest.csv";
			File file = new File(path);
			try {
				CSVReader csvReader = new CSVReader(new FileReader(file));
				try {
					String[] coloums = csvReader.readNext();
					System.out.println(coloums);
					String[] rows;
					while((rows = csvReader.readNext()) != null) {
						//Map<String,String> testData = new HashMap<String, String>();
						Map<String,String> testData = new HashMap<>();
						for(int i = 0; i<coloums.length;i++) {
							testData.put(coloums[i], rows[i]);
							//System.out.println(testData);
						}
						//System.out.println("this is test data: " + testData);
						Object[] t = { testData };
						
						//list.add(testData);
						list.add(t);
						//Arrays.toString(list.iterator());
						//System.out.println("this is list: " + Arrays.toString(list.));
//						for(Map.Entry<String,String> m : testData.entrySet()) {
//							System.out.println("Key: "+ m.getKey() + " and Value: " + m.getValue());
//						}
						
//					
//						for(Object l: t) {
//							System.out.println("List : " + l);
//						}
					}
					for(Object[] ob : list)
					{
						System.out.println(Arrays.toString(ob));
					}
//					for(Object[] li : list) {
//						for(Object l: li) {
//							System.out.println("List : " + l);
//						}
//						System.out.println("List : " + Arrays.toString(li) + "/n");
//					}
					csvReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list.iterator();
			
		}

}
