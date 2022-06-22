package Testcases;

import Library.SelectBrowser;
import Pages.HomePage;
import Pages.SearchProductPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SearchProductPageTest {

    WebDriver driver;
    SearchProductPage productPage;

    HomePage homePage;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setupReport() {

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/SearchproductReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", " ray.home-server.local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("UserName", "Ray Gurung");

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Google search test");
        htmlReporter.config().setReportName(" search report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);

    }

    @BeforeTest
    public void launchBrowser() {
        driver = SelectBrowser.StartBrowser("EdgeExplore");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }
    @Test(enabled = false)
    public void blankSearch()

    {
        productPage=new SearchProductPage(driver);
        productPage.clickSearch();
    }

    @Test(enabled = false)
            public void searchForProduct() throws IOException {
        productPage.searchByProductName();
        productPage.clickSearch();
        Assert.assertEquals("BABY SHOES | Alex + Nova",driver.getTitle());
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/screanShots/.png"));

    }

    @Test(enabled = true)
    public void openHomePage() throws IOException {
        homePage = new HomePage(driver);
        homePage.goToHomePage();
        String actualUrl = homePage.getcurrentUrl();
        String expectedUrl = "https://www.alexandnova.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/screanShots/Urlscreenshot.png"));

    }
    @AfterSuite

    public void tearDown()
    {
        extent.flush();
    }

}

