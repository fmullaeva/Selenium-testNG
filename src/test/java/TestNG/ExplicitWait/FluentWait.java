package TestNG.ExplicitWait;

import utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public  class FluentWait extends TestBase {

    @Test(description = "Heroku app - fluent wait test")
    void fluentTest1(){
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove = driver.findElement(By.xpath("//button[text()='Remove']"));
        remove.click();
        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))//total time to wait
                .pollingEvery(Duration.ofSeconds(3))//frequency to check
                .ignoring(NoSuchElementException.class);//ignoring the exception

        WebElement message = wait.until(e -> e.findElement(By.id("message")));
        String actualMessage = message.getText();
        String expectedMessage = "It's gone!";
        Assert.assertEquals(actualMessage,expectedMessage);


    }
}

