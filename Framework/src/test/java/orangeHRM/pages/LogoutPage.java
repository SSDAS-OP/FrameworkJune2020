package orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import orangeHRM.helper.Utility;

//This is page for Logout
public class LogoutPage {
	WebDriver driver;
	public LogoutPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	By adminText=By.xpath("//a[@id='welcome']");
	By logoutText=By.xpath("//a[text()='Logout']");

	public void LogoutFromApplicationWithAdminRole() 
	{
		Utility.waitForWebElement(driver, adminText).click();
		Utility.waitForWebElement(driver, logoutText).click();
		//driver.findElement(adminText).click();
		//driver.findElement(logoutText).click();
	}

}
