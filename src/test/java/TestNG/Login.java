package TestNG;

import utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Login extends TestBase{
     @Test(description = "Log in Test practicetestautonaton.com")
     void TestLogIn(){
          driver.navigate().to("https://practicetestautomation.com/practice-test-login///");
          WebElement username=driver.findElement(By.id("username"));
          WebElement password=driver.findElement(By.id("password"));
          WebElement submitButton=driver.findElement(By.id("submit"));
          username.sendKeys("student");
          password.sendKeys("Password123");
          submitButton.click();
          driver.getCurrentUrl();
          String expectedURL=("https://practicetestautomation.com/logged-in-successfully/");
          Assert.assertTrue(expectedURL.contains(driver.getCurrentUrl()));
          WebElement title=driver.findElement(By.className("post-title"));
          WebElement content=driver.findElement(By.tagName("post-content"));
          List<WebElement> listOfMenuItems=driver.findElements(By.xpath(""));
          String expectedTitle=("Logged In Successfully");
          String expectedContent=("Congratulations student. You successfully logged in!");
          SoftAssert softAssert=new SoftAssert();
          softAssert.assertEquals(title.getText(),expectedTitle,"Title is failed");
          softAssert.assertEquals(content.getText(),expectedContent,"Content is failed");
          softAssert.assertAll();



     }



      }


