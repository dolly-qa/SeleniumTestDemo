package com.pom.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.opencsv.CSVReader;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class CsvDataProvider {
	@DataProvider(name = "csvReader")
	public static Iterator<Object[]> csvReader(Method method) {
		List<Object[]> list = new ArrayList<Object[]>();
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator
				+ "DataProvider" + File.separator + "NegativeLogintests" + File.separator + "negativeLoginTest.csv";
		File file = new File(pathname);
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] keys = reader.readNext();
			//System.out.println("Datas: " + keys.toString());
			if (keys != null) {
				String[] dataParts;
				
				while ((dataParts = reader.readNext()) != null) {
					//System.out.println("Row: " + dataParts.toString());
					Map<String, String> testData = new HashMap<String, String>();
					for (int i = 0; i < keys.length; i++) {
						testData.put(keys[i], dataParts[i]);
						System.out.println("TestData" + testData + " ");
					}
//					Object[] t = {testData};
//					list.add(t);
					//System.out.println(t);
					
					list.add(new Object[] { testData });
					//System.out.println();
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + pathname + " was not found.\n" + e.getStackTrace().toString());
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathname + " file.\n" + e.getStackTrace().toString());
		}

		return list.iterator();
	}
	
	
}
