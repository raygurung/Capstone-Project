package Testcases;

import Library.SelectBrowser;
import Pages.SearchProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchProductPageTest {

    WebDriver driver;
    SearchProductPage productPage;

    @BeforeTest
    public void launchBrowser() {
        driver = SelectBrowser.StartBrowser("EdgeExplore");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }


    @Test(priority=1)
    public void blankSearch()

    {
        productPage=new SearchProductPage(driver);
        productPage.clickSearch();
    }

    @Test(priority = 2)
            public void searchForProduct()
    {
        productPage.searchByProductName();
        productPage.clickSearch();
    }

}
