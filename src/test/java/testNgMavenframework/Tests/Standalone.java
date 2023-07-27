package testNgMavenframework.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestNgMavenframework.PageObjectModel.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName1="ADIDAS ORIGINAL";
		String productName2="IPHONE 13 PRO";
		System.setProperty("webdriver.chrome.driver", "D:/Automation_Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("poojapooja@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pooja@123");
		driver.findElement(By.id("login")).click();
		LoginPage obj = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));
		List<WebElement> products=driver.findElements(By.cssSelector(".card-body"));
	
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName1)).findFirst().orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		/*Thread.sleep(5);
		WebElement prod1=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName2)).findFirst().orElse(null);
        prod1.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		Thread.sleep(5);
		//wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("[routerlink*='cart']")));*/
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		Thread.sleep(4);
	   List<WebElement> cardprod= driver.findElements(By.cssSelector(".cartSection h3"));
	   Boolean match=cardprod.stream().anyMatch(cartpro->cartpro.getText().equalsIgnoreCase(productName1));
	   Assert.assertTrue(match);
	   driver.findElement(By.cssSelector("ul button[type='button']")).click();
	   Actions a = new Actions(driver);
	   a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	   driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	   driver.findElement(By.cssSelector(".btnn ")).click();
	 String confirmmessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
	 Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
