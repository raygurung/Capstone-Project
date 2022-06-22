package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;

public class HomePage {

    WebDriver driver;

    By homeP = By.id("navigation-home");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        driver.findElement(homeP).click();
    }

    public String getcurrentUrl() {
        String homePageurl = driver.getCurrentUrl();
        return homePageurl;
    }
}
