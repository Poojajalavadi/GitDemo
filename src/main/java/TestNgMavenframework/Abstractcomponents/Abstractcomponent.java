package TestNgMavenframework.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestNgMavenframework.PageObjectModel.Orderpage;
import TestNgMavenframework.PageObjectModel.cartpage;

public class Abstractcomponent {
	
	WebDriver driver;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*=myorders]")
	WebElement orderHeader;
	
	
	public Abstractcomponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void elementtoappear(By findby)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void webelementtoappear(WebElement findby)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findby));
	}
	public void waittoElementtodisappear(WebElement spin)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(spin));
	}
	
	public cartpage gotocartpage()
	{
		cartHeader.click();
		cartpage cartobject = new cartpage(driver);
		return cartobject;
	}
	public Orderpage gotoorderspage()
	{
		orderHeader.click();
		Orderpage orderpageobject = new Orderpage(driver);
		return orderpageobject;
	}
}
