package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    WebDriver driver;


    By shopboxfield = By.xpath("//a[@id='navigation-shop']");

    By colorbook = By.linkText("Color Recognition Early Education Cloth Book");

    By blackcolorbook = By.xpath("//label[contains(text(),'Black')]");

    By addcartbox = By.xpath("//body[1]/div[3]/div[1]/section[1]/div[1]/div[2]/div[1]/form[1]/div[4]/input[1]");

    By topcartbox = By.xpath("//header/div[1]/div[1]/div[2]/div[2]/a[1]");

    By chckoutbox = By.xpath("//span[contains(text(),'Checkout')]");

    By emailfieldcheckout = By.cssSelector("#checkout_email");

    By continuetoshoppingbutton = By.cssSelector("#continue_button");

    By firstnamefield = By.id("checkout_shipping_address_first_name");

    By lastnamefield = By.id("checkout_shipping_address_last_name");

    By addressfield = By.xpath("//input[@id='checkout_shipping_address_address1']");

    By cityfield = By.xpath("//input[@id='checkout_shipping_address_city']");

    By zipzodefield = By.xpath("//input[@id='checkout_shipping_address_zip']");

    By phonenumberfield = By.id("checkout_shipping_address_phone");

    By continuetopaymentfield= By.id("continue_button");

    By paynowfield=By.cssSelector("#continue_button");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void paymentsection() {
        driver.findElement(shopboxfield).click();
        driver.findElement(colorbook).click();
        driver.findElement(blackcolorbook).click();

    }

    public void addtothecartoncheckout() {

        driver.findElement(addcartbox).click();
    }

    public void addcartcheckout() {

        driver.findElement(topcartbox).click();
        driver.findElement(chckoutbox).click();
    }

    public void paymentfilloutblank() {
        driver.findElement(emailfieldcheckout).sendKeys("ray23@gmail.com");

    }

    public void buttonforcontinue() {
        driver.findElement(firstnamefield).sendKeys("Raja");
        driver.findElement(lastnamefield).sendKeys("Guru");
        driver.findElement(addressfield).sendKeys("1234 newton");
    }

        public void restofaddress()
        {
            driver.findElement(cityfield).sendKeys("Arvada");
            driver.findElement(zipzodefield).sendKeys("80003");
            driver.findElement(phonenumberfield).sendKeys("7207777777");
            driver.findElement(continuetoshoppingbutton).click();
        }

        public void paymentfinal()
        {
            driver.findElement(continuetopaymentfield).click();
            driver.findElement(paynowfield).click();
        }


    }



