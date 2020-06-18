package com.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.utilities.TestUtil;

public class AddCustomerByBankManagerLogin extends TestBase {
	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addCustomerByBankManagerLogin(Hashtable <String,String> data) throws InterruptedException{
	
		if(!data.get("runmode").equalsIgnoreCase("y")) {
			
			throw new SkipException("Skipping the parameter");
		}
		
		
		click("addCustomerBtn");
		
		
		
		type("firstnameBtn",data.get("firstname"));
		type("lastNamebtn",data.get("lastname"));
		type("PostCodebtn",data.get("postcode"));
		
		
		click("AddcustomerFormBtn");
	
		
		wait =new WebDriverWait(driver,10);
		
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	
		
		
		//Assert.assertTrue(alert.getText().contains(alert_msg));
		Thread.sleep(10);
		
		alert.accept();
		waitForVisibility("openAccountBtn");

		
		
		
	}

		
		
		
		
	
	
	
	

	

}
