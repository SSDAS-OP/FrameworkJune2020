package orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import orangeHRM.helper.Utility;

public class AdminPage {
	
	WebDriver driver;
	
	public AdminPage(	WebDriver driver) 
	{
		this.driver=driver;
	}
	
	By adminTab=By.xpath("//b[text()='Admin']");
	By addTab=By.id("btnAdd");
	By username=By.xpath("//*[contains(text(),'Username')]//following::input[1]");
	By empname=By.xpath("//*[contains(text(),'Employee Name')]//following::input[1]");
	By saveButton=By.id("btnSave");
	
	
	public void createUser()
	{
		Utility.waitForWebElement(driver, adminTab).click();
		Utility.waitForWebElement(driver, addTab).click();
		Utility.waitForWebElement(driver, empname).sendKeys("Jasmine Morgan");
		Utility.waitForWebElement(driver, username).sendKeys("Satya_55");
		Utility.waitForWebElement(driver, saveButton).click();
	}

}
