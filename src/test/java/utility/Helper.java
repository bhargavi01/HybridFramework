package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	public static String captureScreenshot(WebDriver driver,String screenshotname){
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest="D:\\Selenium_Workspace\\com.automation.hybrid\\Screenshots\\"+screenshotname+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(src, new File(dest));
		} catch (IOException e) {
			System.out.println("failed to capture screenshot "+e.getMessage());
		}
		return dest;
	}

}
