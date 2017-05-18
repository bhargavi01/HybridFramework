package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {
	public class VerifyHomePage {
		WebDriver driver;
		@BeforeMethod
		public void setUp(){
		     driver=BrowserFactory.getBrowser("chrome");
			driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		}
		@Test
		public void testHomePage(){
			HomePage home=PageFactory.initElements(driver,HomePage.class);
			String title=home.getAppicationTitle();
			Assert.assertTrue(title.contains(" Books"));
			home.clickonLoginLink();
			LoginPage login=PageFactory.initElements(driver,LoginPage.class);
			login.loginApplication("7411160546","dadforever");
			login.verifyContactusLink();

		}
		@AfterMethod
		public void tearDown(){
			BrowserFactory.closeBrowser(driver);
		}

	}

}
