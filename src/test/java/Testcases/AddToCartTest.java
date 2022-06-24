package Testcases;

import Library.SelectBrowser;
import Pages.AddToCartPage;
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

public class AddToCartTest {

    WebDriver driver;
    AddToCartPage addToCartPage;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setupReport() {

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/AddtoCartReport.html");
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
    public void verifyProductPrices() throws InterruptedException {
        test = extent.createTest("verify product", "Test Passed");
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.clickonproduct();
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void addProductToCart() throws InterruptedException {
        test = extent.createTest("addproductto cart", "Test Passed");

        addToCartPage = new AddToCartPage(driver);
        addToCartPage.productionDescription();
        Thread.sleep(3000);

    }
        @Test(priority=3)
        public void pressQuantiy() throws InterruptedException {
            addToCartPage.clickQuantity();
            addToCartPage.clickOnAddToCart();
            Thread.sleep(5000);

        }

       @Test(priority=4)
               public void refreshpage() throws InterruptedException {
           driver.navigate().refresh();
           Thread.sleep(3000);
           addToCartPage.topAddToCart();
           Thread.sleep(3000);
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
       public void changetoZero() throws InterruptedException {
           test = extent.createTest("blank product search", "Test Passed");
           addToCartPage.clearCart();
        Thread.sleep(3000);
        addToCartPage.changeQuantity("0");
        Thread.sleep(3000);
        addToCartPage.body();
        Thread.sleep(3000);
        driver.close();

    }
    @AfterSuite

    public void tearDown()
    {
        extent.flush();

    }


    }
