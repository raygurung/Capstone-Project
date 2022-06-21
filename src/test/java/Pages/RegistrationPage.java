package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    By accounttextfield = By.id("customer_login_link");

    By registerField = By.xpath("//a[contains(text(),'Register')]");

    By firstnamefield = By.cssSelector("#ispbxii_1");

    By lastnamefield = By.cssSelector("#ispbxii_2");

    By emailfield = By.cssSelector("#ispbxii_3");

    By passswordfield = By.xpath("//body/div[@id='keyboard-nav-3']/div[2]/form[1]/div[4]/input[1]");

    By registerfullyfield = By.xpath("//body/div[@id='keyboard-nav-3']/div[2]/form[1]/div[5]/input[1]");

    By getAccounttextfield = By.xpath("//header/div[1]/div[1]/div[2]/div[1]/a[1]");

    By emailloginfield = By.xpath("//input[@id='ispbxii_1']");

    By passwordloginfield = By.xpath("//body/div[@id='keyboard-nav-3']/div[2]/div[1]/form[1]/div[2]/input[1]");

    By loginfield = By.xpath("//body/div[@id='keyboard-nav-3']/div[2]/div[1]/form[1]/div[3]/input[1]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccount() {

        driver.findElement(accounttextfield).click();
    }

    public void clickonRegistration() {
        driver.findElement(registerField).click();


    }

    public void enterFirstName(String arg) {

        driver.findElement(firstnamefield).sendKeys(arg);
    }

    public void enterLastName(String arg) {
        driver.findElement(lastnamefield).sendKeys(arg);
    }

    public void enterEmail(String arg) {
        driver.findElement(emailfield).sendKeys(arg);
    }

    public void enterPassword(String arg) {
        driver.findElement(passswordfield).sendKeys(arg);
    }

    public void clickRegisterAgain() {
        driver.findElement(registerfullyfield).click();
    }

    public void clickOnAccount() {
        driver.findElement(getAccounttextfield).click();
    }


    public void inputemail(String arg) {
        driver.findElement(emailloginfield).sendKeys(arg);
    }

    public void inputpassword(String arg) {
        driver.findElement(passwordloginfield).sendKeys(arg);
    }

    public void pressloginfield() {
        driver.findElement(loginfield).click();
    }


}
