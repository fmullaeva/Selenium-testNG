package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    // WebDriver driver;
    public LogInPage(WebDriver driver) {
        //PageFactory is a supporting class for Page Object Model
        //initElements is used to initialize the web elements
        // this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.ID, using = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "input#loginsubmit")
    private WebElement loginButton;


    public void logIn(String username, String password) {
        userName.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

}