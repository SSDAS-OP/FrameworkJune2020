package orangeHRM.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import orangeHRM.factories.DataProviderFactory;
import orangeHRM.factories.ExcelProvider;
import orangeHRM.pages.BaseClass;
import orangeHRM.pages.LoginPage;
import orangeHRM.pages.LogoutPage;


public class Loginscenarios extends BaseClass{
	
	LoginPage login;
	LogoutPage logout;
	
	@Test(priority=0)
	public void verifyPage()
	{
		
		login=PageFactory.initElements(driver, LoginPage.class);
		logout=PageFactory.initElements(driver, LogoutPage.class);
		logger=report.createTest("URL validation");
		login.VerifyUrlBeforeLogin();
		logger.info("Validating URL");
	}
	
	@Test(priority=1,dependsOnMethods="verifyPage")
	public void LoginToApplication() {
		logger=report.createTest("Login as admin");
		login.loginToApplication(DataProviderFactory.getExcel().getcelldata("OrangeHRM", 1, 0),DataProviderFactory.getExcel().getcelldata("OrangeHRM", 1, 1));
		login.VerifyUrlAfterLogin();
		logger.info("Logged in");
	}
	
	@Test(priority=2,dependsOnMethods="LoginToApplication")
	public void logoutFromApplication() 
	{
		logger=report.createTest("Logout");
	   logout.LogoutFromApplicationWithAdminRole();
	   logger.info("Logout done");
	}
}
	
	
