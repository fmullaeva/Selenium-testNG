package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Horizontal$Vertical {
    WebDriver driver;
    Actions actions;
    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }
    @Test
    void testH$V() {
       driver.get("https://demos.telerik.com/kendo-ui/slider/angular");
       WebElement dragPointer = driver.findElement(By.xpath("//span[@aria-orientation='vertical']"));
       WebElement tenpoint = driver.findElement(By.xpath("div[contains(@class,'slider-vertical')]//li[@title='10']"));
       WebElement zeropoint=driver.findElement(By.xpath("div[contains(@class,'slider-vertical')]//li[@title='0']"));

        Point locationTen=tenpoint.getLocation();
        Point locationZero=zeropoint.getLocation();
        System.out.println(locationTen.getX()+","+locationTen.getY());
        System.out.println(locationZero.getX()+","+locationTen.getY());
        System.out.println(locationTen.getY()- locationZero.getY());

        actions.clickAndHold(dragPointer).moveByOffset(0,-95).release().perform();
        actions.clickAndHold((dragPointer)).moveByOffset(0,50).release().perform();
    }
    }
