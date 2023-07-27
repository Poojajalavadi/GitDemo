package testNgMavenframework.Tests;

import java.io.IOException;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestNgMavenframework.PageObjectModel.Confirmationpage;
import TestNgMavenframework.PageObjectModel.LoginPage;
import TestNgMavenframework.PageObjectModel.Orderpage;
import TestNgMavenframework.PageObjectModel.Productcatal;
import TestNgMavenframework.PageObjectModel.cartpage;
import TestNgMavenframework.PageObjectModel.checkoutpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import testNgMavenframework.basecomponents.BaseTest;

public class StandaloneTest extends BaseTest {
	String productName="ADIDAS ORIGINAL";
	@Test(dataProvider="getData", groups="purchase")
	public void submitorder(String email, String password) throws IOException {
		// TODO Auto-generated method stub
		
		
		String productName2="IPHONE 13 PRO";
		Productcatal Productca=loginpage.loginapplication(email, password);
		List<WebElement> list=Productca.getproductlist();
		Productca.addtocart(productName);
		cartpage cartobject=Productca.gotocartpage();
		Boolean match=cartobject.verifyproductdisplay(productName);
		Assert.assertTrue(match);
		checkoutpage checkoutobj = cartobject.gotocheckout();
		checkoutobj.selectcountry("india");
		Confirmationpage confirmobj= checkoutobj.submitorder();
		String confirmessage=confirmobj.gettextmessage();
		Assert.assertTrue(confirmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	@Test(dependsOnMethods= {"submitorder"})
	public void orderHistoryTest()
	{
		Productcatal Productca=loginpage.loginapplication("poojapooja@gmail.com", "Pooja@123");
		Orderpage orderspage=Productca.gotoorderspage();
		Assert.assertTrue(orderspage.verifyorderdisplay(productName));

	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"poojapooja@gmail.com","Pooja@123"},{"bharu@gmail.com", "Bharu@123"}};
	}

}
