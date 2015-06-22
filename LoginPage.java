package com.wickes.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Applying <Page Object> pattern to Login page.
 * Login page contain elements locator, methods to work with
 * such element and webDriver object (webDriver already initialized).
 */
public class LoginPage {

    public static final String URL = MainPage.URL.replace("http", "https") + "login";

    private WebDriver webDriver;

    @FindBy(css="#j_username")
    private WebElement emailAddress;

    @FindBy(css="#j_username")
    private WebElement password;

    @FindBy(css="button[id*='button.login.login']")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    // open page
    public void open() {
        webDriver.get(LoginPage.URL);
    }

    public String getPageURL() {
        return webDriver.getCurrentUrl();
    }

    // check whether page opened
    public boolean isPageOpened() {
        if (!getPageURL().equals(LoginPage.URL)) {
            System.out.println("Current URL is " + getPageURL());
            System.out.println("But URL should be " + LoginPage.URL);

            return false;
        }
        return true;
    }
}
