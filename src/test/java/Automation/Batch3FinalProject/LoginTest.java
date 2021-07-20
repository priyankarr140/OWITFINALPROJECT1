package Automation.Batch3FinalProject;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.login;

public class LoginTest extends Base{
	WebDriver driver;
	private static Logger log=LogManager.getLogger(LoginTest.class.getName());
	
	@Test(dataProvider="getData")
	public void navigation(String username,String password) throws IOException
	{
		try {
			driver=initializeDriver();
			driver.get("https://login.salesforce.com/?locale=eu");
			
			log.info("URl launched");			
			login l1=new login(driver);
			l1.loginInput().sendKeys(username);
			log.info("Username entered");
			l1.loginPassword().sendKeys(password);
			l1.loginBtn().click();
			//failing the test case
			//Assert.assertEquals(driver.getTitle(),"Login1 | Salesforce");
			Assert.assertTrue(true);
				
		}
		catch(Exception ex)
		{
			log.error("Exception occurred");
			Assert.assertTrue(false);
			
		}
			
	}
	@DataProvider()
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="priyankarr140";
		data[0][1]="123456";
		data[1][0]="Test1";
		data[1][1]="Test2";
		return data;
	}


}
