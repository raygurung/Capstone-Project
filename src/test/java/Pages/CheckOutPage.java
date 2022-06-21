package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    WebDriver driver;


    By shopboxfield= By.xpath("//a[@id='navigation-shop']");

    By colorbook= By.linkText("Color Recognition Early Education Cloth Book");

    By blackcolorbook=By.xpath("//label[contains(text(),'Black')]");

    By addcartbox=By.xpath("//body[1]/div[3]/div[1]/section[1]/div[1]/div[2]/div[1]/form[1]/div[4]/input[1]");

    By topcartbox=By.xpath("//header/div[1]/div[1]/div[2]/div[2]/a[1]");

    By chckoutbox=By.xpath("//span[contains(text(),'Checkout')]");

    By emailfieldcheckout=By.cssSelector("#checkout_email");

    By continuetoshoppingbutton=By.xpath("//span[contains(text(),'Continue to shipping')]");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void paymentsection() {
        driver.findElement(shopboxfield).click();
        driver.findElement(colorbook).click();
        driver.findElement(blackcolorbook).click();
        driver.findElement(addcartbox).click();
    }
        public void addcartcheckout()
        {

            driver.findElement(topcartbox).click();
            driver.findElement(chckoutbox).click();
        }
public void paymentfilloutblank()
{
    driver.findElement(emailfieldcheckout).sendKeys("ray23@gmail.com");
    driver.findElement(continuetoshoppingbutton).click();
}

    }


