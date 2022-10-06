package org.makeMyTrip.dataprovider;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.makeMyTrip.utils.ReadExcelUtility;
import org.testng.annotations.DataProvider;

public class DataProviderUtil {

//	private DataProviderUtil()
//	{
//		
//	}
	
	@DataProvider(name = "testData", parallel=false)
	public Object[] getRequestPayloadData()
	{
		ReadExcelUtility xlutil=new ReadExcelUtility("./src/test/resources/testData/testData1.xlsx");
		
		int totalrows=0,totalcols=0;
		totalrows = xlutil.getRowCount("Sheet2");
		
		totalcols=xlutil.getCellCount("Sheet2",1);
		
		XSSFSheet sheet = xlutil.getsheet("Sheet2");
		Object[] testData = new Object[totalrows];
		Map <String, String> map;
		
		for(int i=1;i<=totalrows;i++) //1
		{
			map = new HashMap<String, String>();
			for(int j=0;j<totalcols;j++) //0
			{
				String key=xlutil.getCellData("Sheet2", 0, j);
				String value=xlutil.getCellData("Sheet2", i, j);
				map.put(key, value);
				testData[i-1]=map;
			}	
		}
		
		return testData;
	}
	
	@DataProvider(name="ABC")
	public Object[][] demo()
	{
		Object[][] data = {
				{"MJ","1995"},
				{"AD", "1995"}			
		};
		return data;
	}
	@DataProvider(name="test")
	public Object[][] testMethod()
	{
		return new Object[][] {{"mj","mj"},{"DJ","DJ"}};
		
	}
	
	
}
