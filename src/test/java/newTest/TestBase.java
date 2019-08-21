package test.java.newTest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


/**
 * Base class for all the TestNG-based test classes
 */
public class TestBase {


    public static WebDriver driver;
    public static String browser;

    private final static Logger Log = Logger.getLogger(TestBase.class);

    private static final String F_S = System.getProperty("file.separator");

    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void init(@Optional("chrome") String browser) {
        TestBase.browser = browser;
        System.setProperty("webdriver.chrome.driver", "TestProject" + F_S + "chromedriver_win32" + F_S + "chromedriver.exe");
        driver = new ChromeDriver();
        Reporter.log("Chrome browser launched", true);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        Reporter.log("tearDown", true);
        if (driver != null) {
            driver.quit();
        }
    }

}