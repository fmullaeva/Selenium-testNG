package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDairy {
    @Test
     public void TestDropdown() throws InterruptedException{
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        WebElement dropDown1= driver.findElement(By.cssSelector("select#Shirts"));
        Select select=new Select(dropDown1);
        System.out.println(select.getFirstSelectedOption().getText());
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Blue Shirt","Validate failed");
        select.selectByIndex(1);
        Thread.sleep(2000);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Red Shirt","Validate failed");
        select.selectByValue("yellow");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Yellow Shirt","Validate failed");
        select.selectByVisibleText("Blue Shirt");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Blue Shirts","Validation failed");

    }
    @Test
    public void testDropDownShirts() throws InterruptedException{
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        WebElement dropDown1=driver.findElement(By.cssSelector("select#Skirts"));
        Select select=new Select(dropDown1);
        System.out.println(select.getFirstSelectedOption().getText());
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Blue Skirt","Validate failed");
        select.selectByIndex(1);
        Thread.sleep(2000);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Red Skirt","Validate failed");
        select.selectByValue("YellowSkirt");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Yellow Skirt","Validate failed");
        select.selectByVisibleText("Blue Skirt");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Blue Skirt","Validation failed");


    }
}
