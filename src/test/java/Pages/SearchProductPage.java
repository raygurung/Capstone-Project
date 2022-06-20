package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProductPage {

WebDriver driver;
    By searchButton= By.xpath("//header/div[2]/div[4]/form[1]/input[2]");

    By searchBabyShoes= By.xpath("//input[@id='ispbxii_0']");

    public SearchProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSearch()
    {
        driver.findElement(searchButton).click();
    }

    public void searchByProductName()
    {
        driver.findElement(searchBabyShoes).sendKeys("Baby shoes");

    }

}
