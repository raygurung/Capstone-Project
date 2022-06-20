package Testcases;

import Library.SelectBrowser;
import Pages.RegistrationPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class RegistrationPageTest {

    WebDriver driver;

    RegistrationPage registrationPage;


    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setupReport() {

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/AlexandNovaReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", " ray.home-server.local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("UserName", "Ray Gurung");

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Google search test");
        htmlReporter.config().setReportName("Google search report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);

    }

    @BeforeTest
    public void launchBrowser() {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }

    @Test(priority = 1)



        public void clickAccount() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickAccount();
    }
        @Test(priority=2)

        public void registerNewUser() throws InterruptedException {

        registrationPage.clickonRegistration();
        registrationPage.enterFirstName("Dhiraj");
        registrationPage.enterLastName("Gurung");
        registrationPage.enterEmail("ray23@gmail.com");
        registrationPage.enterPassword("12345");
        registrationPage.clickRegisterAgain();
        Thread.sleep(3000);

    }
    @Test(priority = 3)
    public void invalidLogin()

    {
        registrationPage.clickOnAccount();
        registrationPage.inputemail("ray23@gmail.co");
        registrationPage.inputpassword("12345");
        registrationPage.pressloginfield();
    }

    @Test(priority = 4)
    public void leaveBlank()

    {
        registrationPage.pressloginfield();
    }

    @Test(priority = 5)
public void invalidpassword()
    {
        registrationPage.clickOnAccount();
        registrationPage.inputemail("ray23@gmail.com");
        registrationPage.inputpassword("23456352@@@@!");
        registrationPage.pressloginfield();
    }

}

