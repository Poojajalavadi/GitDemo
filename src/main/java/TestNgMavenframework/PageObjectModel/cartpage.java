package TestNgMavenframework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestNgMavenframework.Abstractcomponents.Abstractcomponent;

public class cartpage extends Abstractcomponent {
	
	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(css="ul button[type='button']")
	WebElement checkout;
	
	public cartpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyproductdisplay(String productName)
	{
		   Boolean match=cartproducts.stream().anyMatch(cartpro->cartpro.getText().equalsIgnoreCase(productName));
		   return match;
	}
	
	public checkoutpage gotocheckout()
	{
		checkout.click();
		checkoutpage checkoutobj=new checkoutpage(driver);
		return checkoutobj;
		
	}
	
}
