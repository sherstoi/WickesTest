package com.wickes.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Applying <Page Object> pattern to Login page.
 * Login page contain elements locator, methods to work with
 * such element and webDriver object (webDriver already initialized).
 */
public class LoginPage {

    public static final String URL = MainPage.URL.replace("http", "https") + "login";

    private WebDriver webDriver;

    private WebElement emailAddress;

    private WebElement password;

    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        // check that we are on right page
        // ??? I'm not sure that it's good idea to throw exception in constructor
        if (!getPageURL().equals(LoginPage.URL)) {
            System.out.println("Current URL is " + getPageURL());
            System.out.println("But URL should be " + LoginPage.URL);
            throw new NoSuchWindowException("This is not LoginPage");
        }
        this.emailAddress = webDriver.findElement(By.cssSelector("#j_username"));
        this.password = webDriver.findElement(By.cssSelector("#j_password"));
        this.submitButton = webDriver.findElement(By.cssSelector("button[id*='button.login.login']"));
        // why I got exception when using this string: By.cssSelector("#button.login.login")???
    }

    public String getPageURL() {
        return webDriver.getCurrentUrl();
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSubmitButton() { return submitButton;}
}
