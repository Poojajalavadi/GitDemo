package testNgMavenframework.basecomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import TestNgMavenframework.PageObjectModel.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LoginPage loginpage;
	
	public WebDriver initializedriver() throws IOException
	
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\testNgMavenframework\\resources\\GlobalData.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		
		if(browsername.contains("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}
		else if(browsername.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browsername.contains("firefox"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage luanchapplication() throws IOException
	{
		driver=initializedriver();
		loginpage = new LoginPage(driver);
		loginpage.gotomain();
		return loginpage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.close();
	}
	
}
