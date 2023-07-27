package TestNgMavenframework.PageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestNgMavenframework.Abstractcomponents.Abstractcomponent;

public class LoginPage extends Abstractcomponent{

	
	WebDriver driver;
	


public LoginPage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(id="userEmail")
WebElement username;

@FindBy(id="userPassword")
WebElement password;

@FindBy(id="login")
WebElement submit;

@FindBy(css="[class*='flyInOut']")
WebElement errormessage;

public Productcatal loginapplication(String email, String pass)
{
	username.sendKeys(email);
	password.sendKeys(pass);
	submit.click();
	Productcatal Productca = new Productcatal(driver);
	return Productca;
	
}

public String getErrorMessage()
{
	webelementtoappear(errormessage);
	return errormessage.getText();
	 
}
public void gotomain()
{
	driver.get("https://rahulshettyacademy.com/client");

}
}
