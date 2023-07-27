package testNgMavenframework.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestNgMavenframework.PageObjectModel.Productcatal;
import TestNgMavenframework.PageObjectModel.cartpage;
import testNgMavenframework.basecomponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		
		String productName="ADIDAS ORIGINAL";
		String productName2="IPHONE 13 PRO";
		loginpage.loginapplication("poojapooja@gmail.com", "Pooja");
		Assert.assertEquals("Incorrect email or password.", loginpage.getErrorMessage());

	}
	
	@Test
	public void ProductErrorValidation()
	{
		String productName="ADIDAS ORIGINAL";
		String productName2="IPHONE 13 PRO";
		Productcatal Productca=loginpage.loginapplication("bharu@gmail.com", "Bharubharu@123");
		List<WebElement> list=Productca.getproductlist();
		Productca.addtocart(productName);
		cartpage cartobject=Productca.gotocartpage();
		Boolean match=cartobject.verifyproductdisplay("ADIDAS");
		Assert.assertFalse(match);
		System.out.println("Error validation done");

	}
	
	

}
