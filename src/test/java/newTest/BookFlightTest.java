package test.java.newTest;

import main.java.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BookFlightTest extends TestBase {

    MainPage mainPage;


    @BeforeClass
    public void testInit() {
        mainPage = initElements(driver, MainPage.class);
    }

    @Test
    public void flightCanNotBeBookedInThePast() {
        driver.get("http://newtours.demoaut.com/");
        mainPage.openRegisterPage();
        mainPage.registerAsNewUser();
        mainPage.openFlightsPage();
        mainPage.bookFlightInThePast();
        Assert.assertTrue(mainPage.verifyErrorMessageForPastDateIsPresent(),"Flight should not be booked in the past");
    }

}

