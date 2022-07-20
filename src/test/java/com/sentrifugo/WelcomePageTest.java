package com.sentrifugo;

import com.saucedemo.pages.LogInPage;
import utils.TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static utils.ElementUtils.getTexts;
import static utils.ElementUtils.visibilityOf;

public class WelcomePageTest extends TestBase {
    LogInPage logInPage;
    WelcomePage welcomePage;

    @BeforeClass
    void setPages(){
       logInPage = new LogInPage(driver);
        welcomePage=new WelcomePage(driver);
    }
    @Parameters({"username","password"})
    @Test (description = "Welcome Page-Menu Options Page")
    void menuOptionsTest(String username,String password){
       driver.get("http://demo.sentrifugo.com/index.php/welcome");
       logInPage.logIn(username,password);
       List<String> actualMenuOprions=getTexts(welcomePage.menuOptions);
        List<String> expectedMenuOptions= Arrays.asList("Dashboard", "Self Service", "Service Request", "HR", "Appraisals", "Recruitments", "Background Check", "Organization", "Analytics", "Site Config", "Modules", "Expenses", "Assets", "Disciplinary", "Time", "Logs"
       softAssert.assertTrue(driver.getCurrentUrl().endsWith("welcome"));
        softAssert.assertEquals(actualMenuOprions,expectedMenuOptions);
        softAssert.assertEquals(welcomePage.memberName.getText(),"Super Admin");
        softAssert.assertEquals(welcomePage.interviewDate.getText().toUpperCase(),getExpectedDate(18));
        softAssert.assertAll();
        welcomePage.profileName.click();
        visibilityOf(driver,3,welcomePage.logOutOption).click();


    }
    public String getExpectedDate(int date){
        LocalDate currentDate = LocalDate.now();
        Month month = currentDate.getMonth();
        int year = currentDate.getYear();
        DayOfWeek dayOfWeek=LocalDate.of(year,month,date).getDayOfWeek();
        return String.format("%s, %s  %d",dayOfWeek.toString().substring(0,3),month.toString().substring(0,3),year);
    }
}
