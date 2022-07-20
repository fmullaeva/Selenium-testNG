package com.sentrifugo;

import com.saucedemo.pages.LogInPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.TestBase;

import java.util.Arrays;
import java.util.List;

import static org.bouncycastle.cms.RecipientId.password;
import static utils.ElementUtils.getTexts;

public class MaritalStatusTest extends TestBase {
    LogInPage loginPage;
    WelcomePage welcomepage;
    Gender gender;
    MaritalStatusTest maritalStatus;

    @BeforeClass
    void setPage(){
        LogInPage LoginPage = new LoginPage(driver);
        welcomepage=new WelcomePage(driver);
        Gender=new gender(driver);
        maritalStatus=new maritalStatus(driver);
        @Parameters({"username","password"})
                @Test
        void maritalStatusPageTest(String username,String password){
            driver.get("");
            LoginPage.logIn(username,password);
            welcomepage.genderButton.click
                    gender.maritalStatus.addButton.click
                            List<String> actualLabels=getTexts(maritalStatus.labels);
            List<String> expectedLabels= Arrays.asList("Marital Code","Marital Status","Description");
            softAssert.assertEquals(actualLabels,expectedLabels,"MaritalStatus Label Test Failed");
            maritalStatus.submitButton.click();
            String actualErrors=
            softAssert.assertEquals();

            
        }

    }
}
