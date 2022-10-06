//package org.ravi.tests;
//
//import org.apache.log4j.Logger;
//import org.testng.annotations.Test;
//
//
//public class DataProviderWithExcel {
//	
//	final static Logger log = Logger.getLogger(DataProviderWithExcel.class);
////	@Test(dataProvider="getData")	
////	public void test(String uname, String fnmae, String lname) {
////		
////		System.out.println("User Name"+uname);
////		System.out.println("First Name"+uname);
////		System.out.println("Last Name"+uname);
////	}
////	
////	@DataProvider
////	public Object[][] getData() throws IOException {
////		FileInputStream fis = new FileInputStream("F:\\Personal\\Automation\\SelAutomationFramework\\src\\test\\resources\\UserCredentials.xlsx");
////		XSSFWorkbook workBook = new XSSFWorkbook(fis);
////		XSSFSheet sheet= workBook.getSheet("TestData");
////		
////		int rownum = sheet.getLastRowNum();
////		System.out.println(rownum);
////		int colnum = sheet.getRow(0).getLastCellNum();
////		System.out.println(colnum);
////		
////		Object[][] data = new Object[rownum][colnum];
////		for (int i=1;i<=rownum;i++) {
////			for(int j=0;j<colnum;j++) {
////				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
////			}
////		}
////		
////		return data;
////	}
////	
////	@Test(dataProvider="getData1")
////	public void test(Map<String, String> map) {
////		
////		System.out.println("User Name"+map.get("User Name"));
////		System.out.println("First Name"+map.get("First Name"));
////		System.out.println("Last Name"+map.get("Last Name"));
////	}
////	
////	@DataProvider
////	public Object[] getData1() throws IOException {
////		FileInputStream fis = new FileInputStream("F:\\Personal\\Automation\\SelAutomationFramework\\src\\test\\resources\\UserCredentials.xlsx");
////		XSSFWorkbook workBook = new XSSFWorkbook(fis);
////		XSSFSheet sheet= workBook.getSheet("TestData");
////		
////		int rownum = sheet.getLastRowNum();
////		System.out.println(rownum);
////		int colnum = sheet.getRow(0).getLastCellNum();
////		System.out.println(colnum);
////		
////		Object[] data = new Object[rownum];
////		Map <String, String> map;
////		for (int i=1;i<=rownum;i++) {
////			
////			
////			map = new HashMap<String, String>();
////			for(int j=0;j<colnum;j++) {
////				String key= sheet.getRow(0).getCell(j).getStringCellValue();
////				String value= sheet.getRow(i).getCell(j).getStringCellValue();
////				map.put(key, value);
////				data[i-1]=map;
////			}
////		}
////		
////		return data;
////	}
//
//	//@Test
////	public void testLogging() {
////			
////		log.debug("D");
////		log.info("I");
////		log.trace("T");
////		log.warn("W");
////		log.fatal("F");
////		
////	}
//
//}
