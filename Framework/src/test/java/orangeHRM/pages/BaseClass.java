package orangeHRM.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import orangeHRM.factories.BrowserFactory;
import orangeHRM.factories.ConfigProvider;
import orangeHRM.factories.DataProviderFactory;
import orangeHRM.helper.Utility;

//BaseClass will have independent methods and annotation

public class BaseClass {
	
	public WebDriver driver;
	public static ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupReport()
	{
		System.out.println("LOG:INFO- Report is getting setup");
		ExtentHtmlReporter htmlreport=new ExtentHtmlReporter(System.getProperty("user.dir")+"./Report/ExtentReport.html");
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		System.out.println("LOG:INFO- Report setup is ready");
	}
	
	@AfterMethod
	public void tearDownReport(ITestResult result)
	{
		System.out.println("LOG:INFO- Test Executed - Test status is "+result.getStatus());
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			try 
			{
				logger.fail("Test failed "+result.getThrowable().getMessage(), 
						MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenshot(driver)).build());
			} 
			catch (IOException e) 
			{
				System.out.println("Unable to attach screenshot in report "+e.getMessage());
			}
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test Skipped");
		}
		report.flush();
	}
	
	@BeforeClass
	public void setUP() 
	{
		System.out.println("LOG:INFO- Setting up Browser and Application");
	    driver=BrowserFactory.getApplication(DataProviderFactory.getConfig().getValue("Browser"), DataProviderFactory.getConfig().getValue("StagingEnv"));
		driver.manage().window().maximize();
		System.out.println("LOG:INFO- Browser and Application is ready");
		
	}
	

	@AfterClass
	public void tearDown()
	{
		System.out.println("LOG:INFO- Terminating Browser");
		//WindowsUtils.killByName("chrome.exe");
		BrowserFactory.closeApplication(driver);
		System.out.println("LOG:INFO- Browser Terminated");
	}
	
	

}
