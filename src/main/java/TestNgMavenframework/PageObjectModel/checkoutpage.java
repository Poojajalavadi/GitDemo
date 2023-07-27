package TestNgMavenframework.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestNgMavenframework.Abstractcomponents.Abstractcomponent;

public class checkoutpage extends Abstractcomponent {
	
	WebDriver driver;
	


	public checkoutpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectcountry;
	
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	
	
	public void selectcountry(String countryname)
	{
		  	Actions a = new Actions(driver);
		  	a.sendKeys(country, countryname).build().perform();
		  	elementtoappear(results);
		  	selectcountry.click();
		
	}

	public Confirmationpage submitorder()
	{
		submit.click();
		Confirmationpage confirmobj=new Confirmationpage(driver);
		return confirmobj;
	}
}
