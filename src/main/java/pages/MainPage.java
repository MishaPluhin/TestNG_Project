package main.java.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class MainPage extends BasePageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final static Logger Log = Logger.getLogger(MainPage.class);

    public void openRegisterPage() {
        findBy(By.xpath("//a[contains(text(),'Register')]")).click();
    }

    public void registerAsNewUser() {
        findBy(By.id("email")).sendKeys("test");
        findBy(By.name("password")).sendKeys("123");
        findBy(By.name("confirmPassword")).sendKeys("123");
        findBy(By.name("register")).click();
        Reporter.log("Log in performed", true);
    }

    public void openFlightsPage() {
        findBy(By.xpath("//a[contains(text(),'Flights')]")).click();
    }

    public void bookFlightInThePast() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date yesterday = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("d");
        Select dayDropdown = new Select(findBy(By.name("fromDay")));
        dayDropdown.selectByValue(dateFormat.format(yesterday));
        findBy(By.xpath("//input[contains(@value, 'oneway')]")).click();
        findBy(By.name("findFlights")).click();
        Reporter.log("Flight in the past selected", true);
    }

    public boolean verifyErrorMessageForPastDateIsPresent() {
        return findBy(By.name("errorMessage")).isDisplayed();
    }

}
