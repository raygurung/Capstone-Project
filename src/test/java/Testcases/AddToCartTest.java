package Testcases;

import Library.SelectBrowser;
import Pages.AddToCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest {

    WebDriver driver;
    AddToCartPage addToCartPage;

    @BeforeTest
    public void launchBrowser() {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }

    @Test(priority = 1)
    public void verifyProductPrices() throws InterruptedException {
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.clickonproduct();
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void addProductToCart() throws InterruptedException {
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.productionDescription();

    }
        @Test(priority=3)
        public void pressQuantiy() throws InterruptedException {
            addToCartPage.clickQuantity();
            addToCartPage.clickOnAddToCart();
            Thread.sleep(5000);

        }

       @Test(priority=4)
               public void refreshpage() {
           driver.navigate().refresh();
           addToCartPage.topAddToCart();
       }

       @Test(priority = 5)
               public void quantityChange() throws InterruptedException {
           addToCartPage.clearCart();
           addToCartPage.changeQuantity("2");
           Thread.sleep(3000);
           addToCartPage.updateCart();
           Thread.sleep(3000);

       }

       @Test(priority = 6)
       public void changetoZero()

    {
        addToCartPage.clearCart();
        addToCartPage.changeQuantity("0");
        addToCartPage.body();

    }

    }
