package TestNgMavenframework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestNgMavenframework.Abstractcomponents.Abstractcomponent;

public class Orderpage extends Abstractcomponent {
	
	WebDriver driver;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> oorderedproducts;
	
	
	
	public Orderpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyorderdisplay(String productName)
	{
		   Boolean match=oorderedproducts.stream().anyMatch(orderpro->orderpro.getText().equalsIgnoreCase(productName));
		   return match;
	}
	

	
}
