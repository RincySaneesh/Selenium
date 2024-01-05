package com.sevenrmartsupermarket.base;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelRead;

public class DataProviders
{
	ExcelRead excelread=new ExcelRead();
	@DataProvider(name="LoginData")
	  public Object[][] userLogin()
	  {
	    return new Object [][]
	    		{
	    	{"hema","hema","Hema"},
	    	{"suresh","suresh","Suresh"},
	    	{"gopi","gopi","Gopi"}
	    	};
	  }
	
	@DataProvider(name="LoginData2")
	  public Object[][] userLogin2()
	  {
		excelread.setExcelFile("LoginData","login");
		Object data[][] =excelread.getMultidimentionalData(3, 3);
		return data;
		
	    	
	  }
	
}
