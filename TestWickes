package test;

import com.wickes.Pages.MainPage;
import com.wickes.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Testing scenarios class for Main and Login pages
 */
public class TestWickes {

    private WebDriver webDriver;

    @BeforeSuite
    public void initDriver() throws Exception {
        webDriver = new FirefoxDriver();
    }

    @AfterSuite
    public void destroyDestroy() throws Exception {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void testWickesSite() {
        webDriver.get(MainPage.URL);
        // Create Main Page object
        MainPage mainPage = new MainPage(webDriver);
        // Check that mainPage is not null or we could get NPE in other cases
        Assert.assertNotNull(mainPage);
        // Move to login page
        LoginPage loginPage = mainPage.forwardToLoginPage();
        // Check that loginPage is not null or we could get NPE in other cases
        Assert.assertNotNull(loginPage);
        // Check that web elements on login page are exists
        Assert.assertNotNull(loginPage.getEmailAddress());
        Assert.assertNotNull(loginPage.getPassword());
        Assert.assertNotNull(loginPage.getSubmitButton());
    }
}
