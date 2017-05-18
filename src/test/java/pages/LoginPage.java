package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver){
		this.driver=ldriver;
	}
	@FindBy(xpath="//input[@class='_2zrpKA']")WebElement username;
	@FindBy(xpath="//input[@type='password']")WebElement password;
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")WebElement loginbutton;
	By contactus=By.xpath("//a[text()='My Account']");
	public void loginApplication(String user,String pswd){
		username.sendKeys(user);
		password.sendKeys(pswd);
		loginbutton.click();
	}
	public void verifyContactusLink() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(contactus));
		String text=ele.getText();
		Assert.assertEquals(text,"My Account","contact us link is not verified properly");
		
	}


}
