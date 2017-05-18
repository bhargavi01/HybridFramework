package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPageWithReport1 {
	public class VerifyHomePage {
		WebDriver driver;
		ExtentReports report;
		ExtentTest logger;
		@BeforeMethod
		public void setUp(){
			report=new ExtentReports("./Reports/LoginPageReport.html",true);
			logger=report.startTest("verify test login");
		     driver=BrowserFactory.getBrowser("chrome");
			driver.get(DataProviderFactory.getConfig().getApplicationUrl());
			logger.log(LogStatus.INFO,"Application is up and running");
		}
		@Test
		public void testHomePage(){
			HomePage home=PageFactory.initElements(driver,HomePage.class);
			String title=home.getAppicationTitle();
			Assert.assertTrue(title.contains(" Books"));
			logger.log(LogStatus.PASS,"Home Page loaded and verified");
			home.clickonLoginLink();
			logger.log(LogStatus.INFO,"clicked on signin link");
			LoginPage login=PageFactory.initElements(driver,LoginPage.class);
			login.loginApplication("7411160546","dadforever");
			logger.log(LogStatus.INFO,"Login to application");
			login.verifyContactusLink();
			logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"validation2")));
			logger.log(LogStatus.PASS,"My account link is present");

		}
		@AfterMethod
		public void tearDown(ITestResult result){
			if(result.getStatus()==ITestResult.FAILURE){
				String path=Helper.captureScreenshot(driver,result.getName());
				logger.log(LogStatus.FAIL,logger.addScreenCapture(path));
			}
			BrowserFactory.closeBrowser(driver);
			report.endTest(logger);
			report.flush();
		}

	}

}
