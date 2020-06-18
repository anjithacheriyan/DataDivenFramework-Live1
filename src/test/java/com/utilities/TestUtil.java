package com.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.base.TestBase;

public class TestUtil extends TestBase {

	
	public static String ScreenshotPath;
	public static String ScreenshotName;
	
	
	public static void CaptureScreenshot() throws IOException {
		Date d=new Date();
		ScreenshotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		ScreenshotPath=System.getProperty("user.dir")+"/target/surefire-reports/html/"+ScreenshotName;
		
		File scfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scfile, new File(System.getProperty("user.dir")+"/target/surefire-reports/html/"+ScreenshotName));
		
		
		
	}
	
	
	
	
	/*------------------------------- Excel Reader DataProvider---------------------------------------*/
	
	
	
		@DataProvider(name="dp")
		public Object[][] getData(Method m){
		
			String sheetname=m.getName();
			
			int rowcount=excel.getRowCount(sheetname);
			int colcount=excel.getColumnCount(sheetname);
			
			
			Object[][] data =new Object[rowcount-1][1];
			Hashtable <String,String> table=null;
			
			for(int rows=2;rows<=rowcount;rows++)
			{
				table=new Hashtable <String,String>();
				
				for(int cols=0;cols<colcount;cols++) {
				
					
					table.put(excel.getCellData(sheetname, cols, 1), excel.getCellData(sheetname,cols,rows));
					data[rows-2][0]=table;
					
					
					
				}
				
				
				
			}
			
			
			
			
			
			
			return data;
		}
		
		
	/*----------------------------------------IsRunnable----------------------------*/
		
		
		
		public static boolean isRunnable(String TestName) {
			
			
			String SheetName="test_suite";
			
			int rowcount=excel.getRowCount(SheetName);
			
			
			for(int rowNum=2;rowNum<=rowcount;rowNum++) {
				
			   String TestCase=excel.getCellData(SheetName,"TCID", rowNum);
			   
			
			if(TestCase.equalsIgnoreCase(TestName)) {
				
				String Runmode=excel.getCellData(SheetName, "RUNMODE", rowNum);
				
				if(Runmode.equalsIgnoreCase("Y")){
					
				return true;
					
				}else
					
				return false;
						
						
				}
				
			}
			return false;
			
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
	

