package com.ap.ui.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_XSL {
	
	public String fileName;
	public FileInputStream ipstr = null;
	public FileOutputStream opstr = null;
	private XSSFWorkbook wb = null;
	private XSSFSheet ws = null;
	List<String>list = new ArrayList<String>();
	
	public Read_XSL(String fileName, String relativePath){
		this.fileName = fileName;
		try{
			ipstr = new FileInputStream(relativePath+fileName);
			wb = new XSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);
			ipstr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//retrieveNoOfRows
	//retrieveNoOfCol
	public int retrieveNoOfRows(String wsName){
		int sheetIndex = wb.getSheetIndex(wsName);
		if(sheetIndex==-1)
			return 0;
		else{
			ws=wb.getSheetAt(sheetIndex);
			int rowCount = ws.getLastRowNum() +1;
			return rowCount;
		}
	}
		public int retrieveNoOfCol(String wsName){
			int sheetIndex = wb.getSheetIndex(wsName);
			if(sheetIndex==-1)
				return 0;
			else{
				ws=wb.getSheetAt(sheetIndex);
				int colCount = ws.getRow(0).getLastCellNum() + 1;
				return colCount;
			}
	}
		public String retrieveToRunFlag(String wsName, String ColName, String rowName){
			int sheetIndex = wb.getSheetIndex(wsName);
			if(sheetIndex==-1)
				return null;
			else{
				int rowNum = retrieveNoOfRows(wsName);
				int ColNum = retrieveNoOfCol(wsName);
				int colnumber = -1;
				int rownumber = -1;
				
				XSSFRow Suiterow = ws.getRow(0);
				for(int i = 0;i<ColNum;i++){
					if(Suiterow.getCell(i).getStringCellValue().equals(ColName.trim())){
						colnumber = i;
					}
				}
				if(colnumber==-1){
					return "";
		}
			for(int j=0; j<rowNum;j++){
				XSSFRow Suitecol = ws.getRow(j);
				if(Suitecol.getCell(0).getStringCellValue().equals(rowName.trim())){
					rownumber=j;
				}
			}
			if(rownumber==-1){
				return "";
			}
			XSSFRow row = ws.getRow(rownumber);
			XSSFCell cell = row.getCell(colnumber);
			if(cell==null){
				return "";
			}
			String value = cellToString(cell);
			return value;
			}
		}
		@SuppressWarnings("deprecation")
		public List<String>retrieveTestData(String wsName){
			int sheetIndex = wb.getSheetIndex(wsName);
			if(sheetIndex==-1)
			return null;
			else{
				int rowNumber = retrieveNoOfRows(wsName);
				int colNumber = retrieveNoOfCol(wsName);
				
				Object data [] = new Object[rowNumber -1][colNumber];
				
				for(int i=0; i<rowNumber; i++){
					XSSFRow row = ws.getRow(i);
					for(int j = 0;j<colNumber;j++){
						if(row==null){
							list = null;
						}else{
							XSSFCell cell = row.getCell(j);
							if(cell==null){
								list=null;
							}
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String value = cellToString(cell);
							System.out.println(value);
							list.add(value);
						}
					}
						
				}
				
			}
			return list;
			
		}
		@SuppressWarnings("deprecation")
		public static String cellToString(XSSFCell cell){
			int type;
			Object result;
			type=cell.getCellType();
			switch (type){
			case 0:
				result = cell.getStringCellValue();
				break;
				
			default:
				throw new RuntimeException("Unsupported cell.");
			}
			return result.toString();
			}
		public Object[][] retrieveTestData1(String string) {
			// TODO Auto-generated method stub
			return null;
		}
		}
	
	
	
	
	

