package orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import orangeHRM.helper.Utility;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
    
	By user=By.id("txtUsername");
	//@FindBy(id="txtUsername") WebElement user;
	By password=By.id("txtPassword");
	//@FindBy(name="txtPassword") WebElement pass;
	By loginButton=By.xpath("//input[@class='button']");
	//@FindBy(xpath="//input[@class='button']") WebElement loginbutton;
	
	public void VerifyUrlBeforeLogin() {
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Page does not conatin dashboard");
		
		
	}
	
public void VerifyUrlAfterLogin() {
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard Page does not conatin dashboard");
	}
	
	public void typeuserName() {
		Utility.waitForWebElement(driver, user).sendKeys("Admin");
		//user.sendKeys("Admin");
	}
	
	public void typePassword() {
		Utility.waitForWebElement(driver, password).sendKeys("admin123");
		//pass.sendKeys("admin123");
	}
	
	public void clickLogin() {
		Utility.waitForWebElement(driver, loginButton).click();
		//loginbutton.click();
	}
	
	public void loginToApplication(String userName,String passWord)
	{
		Utility.waitForWebElement(driver, user).sendKeys(userName);
		Utility.waitForWebElement(driver, password).sendKeys(passWord);
		Utility.waitForWebElement(driver, loginButton).click();
		/*user.sendKeys(userName);
		pass.sendKeys(passWord);
		loginbutton.click();*/
	}
	
	
	
}
