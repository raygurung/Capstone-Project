package Testcases;

import Library.SelectBrowser;
import Pages.AddToCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class GiftCardTest {
    WebDriver driver;
    AddToCartPage addToCartPage;

    @BeforeTest
    public void launchBrowser() {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }

    @Test(priority = 1)
    public void giftcardinput() throws InterruptedException {
        addToCartPage=new AddToCartPage(driver);
        addToCartPage.clickonproduct();
        addToCartPage.productionDescription();
        addToCartPage.clickQuantity();
        addToCartPage.clickOnAddToCart();
        Thread.sleep(5000);
        addToCartPage.topAddToCart();
        addToCartPage.clickoncheckout();
        addToCartPage.inputgiftcardinfo("VT_RHBWJS6FMZ");
        Thread.sleep(3000);
        addToCartPage.clickonapplygiftcard();



    }

}

