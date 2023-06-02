package com.indiaKababReno.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility 
{
	public FileInputStream fileIP;
	public FileOutputStream fileOP;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public XLUtility(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		fileIP=new FileInputStream(path);
	workbook=new XSSFWorkbook(fileIP);
	sheet=workbook.getSheet(sheetName);
	int rowCount=sheet.getLastRowNum();
	fileIP.close();
	return rowCount;
	}
	
	public int getCellcount(String sheetName,int rownum) throws IOException
	{
		fileIP=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileIP);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fileIP.close();
		return cellCount;
	}
	
	
	public Object[][] twoDArray(String sheet) throws IOException
	{
		int rowNum=getRowCount(sheet);
		int cellNum=getCellcount(sheet, 1);
		
		Object data[][]=new String[rowNum][cellNum]; 
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<cellNum;j++)
			{
				data[i-1][j]=getCellData(sheet,i ,j );
			
			}
		}
		return data;
	}
	
	public String getCellData(String sheetName,int rownum, int colnum) throws IOException
	{
		fileIP=new FileInputStream(path);
		workbook=new XSSFWorkbook(fileIP);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try {
	        if(cell.getCellType() == CellType.BLANK) {
	            data = "";
	        } else {
	            data = formatter.formatCellValue(cell);
	        }
	    } catch (Exception e) {
	        data = "";
	    }
		workbook.close();
		fileIP.close();
		return data;
		
	}
	
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())//If File does not exist then create new file 
		{
			workbook=new XSSFWorkbook();
			fileOP=new FileOutputStream(path);
			workbook.write(fileOP);
			
		}
		fileIP=new FileInputStream(path);
		workbook= new XSSFWorkbook(fileIP);
		
		if(workbook.getSheetIndex(sheetName)==-1)//If sheet not exist then create new Sheet
			workbook.createSheet(sheetName);
		sheet=workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null) //If row does not exist then create new row
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fileOP=new FileOutputStream(path);
		workbook.write(fileOP);
		workbook.close();
		fileIP.close();
		fileOP.close();
		
	}
	
	public void filleGreenColor(String sheetName, int rownum, int colnum) throws IOException
	{
		fileIP= new FileInputStream(path);
		workbook= new XSSFWorkbook(fileIP);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fileOP);
		workbook.close();
		fileIP.close();
		fileOP.close();
			
	}
	
	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException
	{
		fileIP= new FileInputStream(path);
		workbook= new XSSFWorkbook(fileIP);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fileOP);
		workbook.close();
		fileIP.close();
		fileOP.close();
		
	}

}
