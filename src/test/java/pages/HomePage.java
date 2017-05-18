package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver ldriver){
		this.driver=ldriver;
	}
	@FindBy(xpath="//a[text()='Signup']")WebElement signuplink;
	@FindBy(xpath="//a[text()='Log In']")WebElement loginlink;
	@FindBy(xpath="//a[@class='_3NFO0d']")WebElement cartlink;
	public void clickonSignupLink(){
		signuplink.click();
	}
	public void clickonLoginLink(){
		loginlink.click();
	}
	public void clickonCartLink(){
		cartlink.click();
	}
	public String getAppicationTitle(){
		return driver.getTitle();
	}
	

}
