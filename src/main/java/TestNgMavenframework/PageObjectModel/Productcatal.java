package TestNgMavenframework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestNgMavenframework.Abstractcomponents.Abstractcomponent;

public class Productcatal extends Abstractcomponent {

	
	WebDriver driver;
	


public Productcatal(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(css=".card-body")
List<WebElement> products;


@FindBy(css=".ng-animating")
WebElement spinner;

By productsby=By.cssSelector(".card-body");
By addtocart = By.cssSelector(".card-body button:last-of-type");
By toastmessage= By.cssSelector("#toast-container");

  public List<WebElement> getproductlist()
  {
	  elementtoappear(productsby);
	  return products;
  }

  public WebElement getproductbyname(String productname)
  {
		WebElement prod=getproductlist().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
  }
  
  public void addtocart(String productname)
  {
		
	  WebElement prod=getproductbyname(productname);
	  prod.findElement(addtocart).click();
	  elementtoappear(toastmessage);
	  waittoElementtodisappear(spinner);
	  
  }

}
