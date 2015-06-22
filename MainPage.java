package com.wickes.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private WebElement linkLoginElement;

    // constructor
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        // ??? I call PatternFactory.initElements from constructor, not sure that it's a good idea
        PageFactory.initElements(webDriver, this);

        // check that we are on right page
        // ??? I'm not sure that it's good idea to throw exception in constructor
        if (!getPageURL().equals(MainPage.URL)) {
            System.out.println("Current URL is " + getPageURL());
            System.out.println("But URL should be " + MainPage.URL);
            throw new NoSuchWindowException("This is not MainPage");
        }
        // before take element we should use PageFactory.initElements
        this.linkLoginElement = webDriver.findElement(By.cssSelector("#header_login_link"));
    }

    // get page title
    public String getPageURL() {
        return webDriver.getCurrentUrl();
    }

    // get login/register element
    public WebElement getLinkLoginElement() {
        return linkLoginElement;
    }

    /**
     * Moving to Login page from Main page
     * @return Login page object
     */
    public LoginPage forwardToLoginPage() {
        linkLoginElement.click();
        // prepare control element from login page
        LoginPage loginPage = new LoginPage(webDriver);
        PageFactory.initElements(webDriver, loginPage);
        // return login page object
        return loginPage;
    }
}
