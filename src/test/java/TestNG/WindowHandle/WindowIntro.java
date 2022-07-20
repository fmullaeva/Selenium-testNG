package TestNG.WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import static utils.BrowserUtils.closeWindows;

public class WindowIntro {
    WebDriver driver;
    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    void MainPage(){
        driver.get("file:///C:/Users/Fatima/Desktop/main.html");
        WebElement testLink=driver.findElement(By.xpath("//a[contains(@href,'tesla')]"));
        String parentId=driver.getWindowHandle();
        testLink.click();
        BrowserUtils.switchWindowByTitle(driver,"Elon Musk | Tesla");
        WebElement headingTesla=driver.findElement(By.cssSelector("'h1.section-title'"));
        Assert.assertEquals(headingTesla.getText(),"Elon Musk");
        closeWindows(driver,parentId);
    }
}