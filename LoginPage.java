package com.wickes.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Applying <Page Object> pattern to Main page.
 * Main page contain elements locator, method to work with
 * such element and webDriver object.
 */
public class MainPage {
    // URL to main page
    public static final String URL = "http://www.wickes.co.uk/";
    // reference to web driver
    private WebDriver webDriver;
    // reference to "login/register" link element
    @FindBy(css="#header_login_link")
    private WebElement linkLoginElement;

    // constructor
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    // get page title
    public String getPageURL() {
        return webDriver.getCurrentUrl();
    }

    // open page
    public void open() {
        webDriver.get(MainPage.URL);
    }

    // check whether page opened
    public boolean isPageOpened() {
        if (!getPageURL().equals(MainPage.URL)) {
            System.out.println("Current URL is " + getPageURL());
            System.out.println("But URL should be " + MainPage.URL);

            return false;
        }
        return true;
    }
}
