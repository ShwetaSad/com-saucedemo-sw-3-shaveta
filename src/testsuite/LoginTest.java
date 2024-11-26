package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

   @Before
    public void open(){
        openBrowser(baseUrl);
    }

@Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        //* Enter “standard_user” for the username
        sendTextToElement(By.id("user-name"), "standard_user");

        //Enter “secret_sauce” for the password
sendTextToElement(By.id("password"),"secret_sauce");


        // Find the login link element and click on login link element
        clickOnElement(By.id("login-button"));

        // Verifying the text products
String expectedText   ="Products";
String actualText = getTextFromElement(By.xpath("//span[@class=\"title\"]"));
    Assert.assertEquals("Not directed to Products page",expectedText,actualText);


    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //* Enter “standard_user” for the username
        sendTextToElement(By.id("user-name"), "standard_user");

        //Enter “secret_sauce” for the password
        sendTextToElement(By.id("password"),"secret_sauce");


        // Find the login link element and click on login link element
        clickOnElement(By.id("login-button"));

        // Verify 6 products are displayed on page
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int numberOfProducts = products.size();
        System.out.println(numberOfProducts);

        int expectedproducts =6;
        int actualproducts = products.size();
        Assert.assertEquals("wrong number od products",expectedproducts,actualproducts);

    }
    @After
    public void close(){
       closeBrowser();
    }
}
