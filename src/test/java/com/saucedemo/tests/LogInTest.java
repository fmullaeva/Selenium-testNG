package com.saucedemo.tests;

import com.saucedemo.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.TestBase;

import static utils.TestBase.driver;

public class LogInTest extends TestBase {
    LogInPage logInPage;

    @BeforeClass
    void setPages(){
        logInPage = new LogInPage(driver);
    }

    @Parameters({"username","password"})
    @Test(description = "Sentrifugo Log In Happy Pass")
    void logInTest(String userName,String password){
        driver.get("http://demo.sentrifugo.com/index.php/");
        logInPage.logIn(userName,password);
        Assert.assertTrue(driver.getCurrentUrl().contains("welcome"));
    }
}
