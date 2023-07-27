package TestNgMavenframework.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestNgMavenframework.Abstractcomponents.Abstractcomponent;

public class Confirmationpage extends Abstractcomponent{
	
WebDriver driver;
	


	public Confirmationpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmessage;
	
	public String gettextmessage()
	{
		return confirmessage.getText();
	}

}
