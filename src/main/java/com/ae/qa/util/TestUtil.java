package com.ae.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ae.qa.base.TestBase;
import com.google.common.io.Files;

public class TestUtil extends TestBase{
	public static long IMPLICIT_WAIT=20;
	public static long PAGE_LOAD_TIMEOUT=40;

	public void switchToFrame() {
		driver.switchTo().frame("xyz");
	}
	public static String TESTDATA_SHEET_PATH="C:\\Users\\Kalyani\\eclipse-workspace\\AutomationEdgePortal\\src\\main\\java\\com\\ae\\qa\\testdata\\TestData_AE.xlsx";
	
	
	static Workbook book;
	static Sheet sheet;
	
   public static Object[][] getTestData(String sheetName) {
	FileInputStream file=null;
			try {
				file=new FileInputStream(TESTDATA_SHEET_PATH);
			} catch(FileNotFoundException e) {
			e.printStackTrace();
             } 
			try {
			book= WorkbookFactory.create(file);
			}catch(InvalidFormatException e) {
		        e.printStackTrace();
            }
			catch(IOException e) {
		        e.printStackTrace();
            }
			sheet=book.getSheet(sheetName);
			Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					}
			}
			return data;
		}
   public static void CapturingScreenshot(WebDriver driver,String ScreenshotName) throws IOException {
			try {
				TakesScreenshot ts = (TakesScreenshot)driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				Files.copy(source, new File ("./Screenshots/"+ScreenshotName+".png"));
				System.out.println("scnshot taken");
			} catch (Exception e) {
				System.out.println("Exception hile taking screenshot" +e.getMessage());
			}
   }
}
