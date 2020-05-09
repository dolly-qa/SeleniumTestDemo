package com.herokuapp.theinternet;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="files")
	public static Object[][] files(){
		return new Object[][]{
			{1,"text2.txt"},
			{2,"text3.txt"}
			
		};
		
	}
	@DataProvider(name="data")
	public static Object[][] datas(){
		return new Object[][]{
			{"tomsmith","SuperSecretPassword!"},
			{"tomsmith","SuperSecretPassword!"}
			
		};
		
	}
}
