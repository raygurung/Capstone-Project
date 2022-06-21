package Testcases;

import Library.SelectBrowser;
import Pages.RegistrationPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogInTest {
    WebDriver driver;
    RegistrationPage registrationPage;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setupReport() {

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/LoginReport.html");
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
    public void invalidemailvalidpassword() throws InterruptedException {
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnAccount();
        registrationPage.inputemail("raja10@gmail.com");
        registrationPage.inputpassword("12345");
        registrationPage.pressloginfield();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void loginwithvaliduserid() throws InterruptedException {
        registrationPage = new RegistrationPage(driver);

        registrationPage.clickAccount();
        registrationPage.inputemail("ray23@gmail.com");
        registrationPage.inputpassword("12345");
        registrationPage.pressloginfield();
        Thread.sleep(5000);

    }
    @AfterSuite

    public void tearDown()
    {
        extent.flush();
    }
}
