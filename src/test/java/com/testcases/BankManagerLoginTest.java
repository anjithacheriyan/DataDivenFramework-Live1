package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import com.base.TestBase;




public class BankManagerLoginTest extends TestBase{
	
	
		
		@Test
		public void bankManagerLoginTest() throws InterruptedException, IOException {
			
			System.setProperty("org.uncommons.reportng.escape-output","false");
		    
			verifyEquals("xyz","xyz");
			
			click("bankManagerLogin");
			
			 
			log.debug("navigated to bank manager !!!");
			Thread.sleep(3000);
			
			Assert.assertTrue(IsElementPrsent(By.xpath(OR.getProperty("addCustomerBtn"))), "Element not present !");
			log.debug("Add customer button found successfully !!!");
			
			
			
		/*	Reporter.log("Login successful");
			
			Reporter.log("<a target=\"_blank\" href=\"\\Users\\anji\\Documents\\Selenium\\screenshots\\error.jpg\"><img scr=\\\"\\\\Users\\\\anji\\\\Documents\\\\Selenium\\\\screenshots\\\\error.jpg\\\">Screenshot</a>");
		 
		*/
		 
		 
		 
	 }
	

}
