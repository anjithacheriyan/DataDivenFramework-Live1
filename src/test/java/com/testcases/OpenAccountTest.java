package com.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.utilities.TestUtil;

public class OpenAccountTest extends TestBase {
	
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void openAccountTest(Hashtable <String,String> data) throws InterruptedException{
	
		
		click("openAccountBtn");
		select("customerName","anjitha cheriyan");
		select("currency","Dollar");
		click("processBtn");
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		
		Thread.sleep(3000);
		
		alert.accept();
		
		
	}
	
		
		
	
	
	
	
	
	
	
	
	

}
