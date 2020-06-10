package com.pom.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;

public class CsvReaderPractise {
@DataProvider(name="csv")
	public Iterator<Object[]> csvReaderPractise() {
		
		List<Object[]> list = new ArrayList<Object[]>();
		String path = "/Users/maharshi/eclipse-workspace/selenium-for-beginner/src/test/resources/DataProvider/PositiveLoginTests/positiveLoginDataProviderPractice.csv";
		File file = new File(path);
		try {
			CSVReader csvRead = new CSVReader(new FileReader(file));
			try {
				Object[] row;
				while((row = csvRead.readNext()) != null){
					//Object[] value = Arrays.toString(row);
					list.add(row);
				}
				
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
