package com.sentrifugo;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static utils.ElementUtils.*;
import static utils.ElementUtils.getTexts;

public class DepartmentPage {
    LogInPage logInPage;
    DepartmentPage departmentPage;
    WelcomePage welcomePage;

    @BeforeClass
    void setPages() {
        logInPage = new LogInPage(driver);
        welcomePage = new WelcomePage(driver);
        departmentPage = new DepartmentPage(driver);
    }

    @Parameters({"username", "password"})
    @Test(description = "Sentrifugo Department Creation Test")
    void departmentCreationTest(String username, String password) {
        driver.get("http://demo.sentrifugo.com/index.php/");
        logInPage.logIn(username, password);
        welcomePage.departmentButton.click();
        departmentPage.addNewButton.click();
        departmentPage.departmentName.sendKeys("Finance");
        departmentPage.departmentCode.sendKeys("FN");
        departmentPage.timeZone.click();
        click(departmentPage.timeZoneOptions, "America/Detroit [EDT]");
        departmentPage.city.click();
        departmentPage.miami.click();
        departmentPage.saveButton.click();
        Assert.assertTrue(visibilityOf(driver, 3, departmentPage.successMessage).isDisplayed());
    }


    @Parameters({"username", "password"})
    @Test(description = "Add Department - Required Field Test")
    void requiredFieldTest(String username, String password) {
        driver.get("http://demo.sentrifugo.com/index.php/");
        logInPage.logIn(username, password);
        welcomePage.departmentButton.click();
        departmentPage.addNewButton.click();
        List<String> actualLabels = getTexts(departmentPage.formLabels);
        List<String> expectedLabels = Arrays.asList("Department Name", "Business Unit", "Department Code",
                "Department Head", "Started On", "Time Zone", "Country", "State", "City", "Street Address 1",
                "Street Address 2", "Street Address 3", "Description");
        softAssert.assertEquals(actualLabels, expectedLabels);
        departmentPage.timeZone.click();
        click(departmentPage.timeZoneOptions, "Select Time zone");
        departmentPage.country.click();
        click(departmentPage.countries, "Select country");
        departmentPage.address1.clear();
        visibilityOf(driver, 4, departmentPage.saveButton).click();
        List<String> actualErrors = getTexts(departmentPage.errors);
        List<String> expectedErrors = Arrays.asList("Please enter department name.", "Please enter department code.",
                "Please select time zone.", "Please select country.", "Please select state.", "Please select city.",
                "Please enter street address.");
        softAssert.assertEquals(actualErrors, expectedErrors);
        String redColor = "rgba(255, 0, 0, 1)";
        for (WebElement error : departmentPage.errors) {
            softAssert.assertEquals(error.getCssValue("color"),redColor);
        }
        softAssert.assertAll();
    }


}
}
