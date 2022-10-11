package org.makeMyTrip.dataprovider;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.makeMyTrip.constants.FrameworkConstants;
import org.makeMyTrip.utils.ReadExcelUtility;
import org.testng.annotations.DataProvider;

public class DataProviderUtil {

	Logger log = LogManager.getLogger(DataProviderUtil.class);
	@DataProvider(name = "testData")
	public Object[] getRequestPayloadData()
	{
		ReadExcelUtility xlutil=new ReadExcelUtility(FrameworkConstants.getTestDataFilePath());
		log.info("Opened Excel test Data file");
		int totalrows=0,totalcols=0;
		totalrows = xlutil.getRowCount("bookingDetails");
		
		totalcols=xlutil.getCellCount("bookingDetails",1);
		
//		XSSFSheet sheet = xlutil.getsheet("bookingDetails");
		Object[] testData = new Object[totalrows];
		Map <String, String> map;
		
		for(int i=1;i<=totalrows;i++) //1
		{
			map = new HashMap<String, String>();
			for(int j=0;j<totalcols;j++) //0
			{
				String key=xlutil.getCellData("bookingDetails", 0, j);
				String value=xlutil.getCellData("bookingDetails", i, j);
				map.put(key, value);
				testData[i-1]=map;
			}	
		}
		log.info("Test data is fetched from file");
		return testData;
	}
	
	
	
}
