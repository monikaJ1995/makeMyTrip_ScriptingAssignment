package org.ravi.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelUtility {
	public static FileInputStream fi;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;   
	String path ;
	int rowcount,cellcount;
	String data;
	
	/*This will accept the excel file location to read data from it*/
	public ReadExcelUtility(String path)
	{
		this.path=path;
	}
		
	/*This method will fetch the sheet from which we want to read data
	 * Input: Sheet name to read
	 * return: reference of sheet to access*/
	public XSSFSheet getsheet(String sheetName)
	{
		try {
			fi=new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			System.out.println("workbook instance created");

			sheet=workbook.getSheet(sheetName);
			workbook.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sheet;
	}
	
	/*This method will accept sheet name from which want to get total count of rows
	 * input: sheet name
	 * return: total count of rows containing data*/
	public int getRowCount(String sheetName)
	{
		try {
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			rowcount=sheet.getLastRowNum();
			workbook.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rowcount;		
	}

	/*This method will accept sheet name & row number from which want to get total count of rows
	 * input: sheet name, row number
	 * return: total count of cells containing data*/
	public int getCellCount(String sheetName,int rownum)
	{
		try {
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rownum);
			cellcount=row.getLastCellNum();
			workbook.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cellcount;
	}
	
	/*This method will accept sheet name, row number & cell number from which want to get total count of rows
	 * input: sheet name, row number, cell number
	 * return: data from specific cell*/
	public String getCellData(String sheetName,int rownum,int colnum)
	{
		try {
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rownum);
			cell=row.getCell(colnum);
			
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
			workbook.close();
			fi.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return data;
	}	
}
