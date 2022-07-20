package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
public class HorizontalSlider {
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
    void testSlider1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement sliderPoint = driver.findElement(By.xpath("//input[@type='range']"));
        System.out.println(sliderPoint.getLocation().getY());
        System.out.println(sliderPoint.getLocation().getX());

        actions.clickAndHold(sliderPoint).moveByOffset(55,0).release().perform();
        WebElement range = driver.findElement(By.cssSelector("span#range"));
        String maxRange = "5";
        Assert.assertEquals(range.getText(),maxRange);
        Thread.sleep(2000);
        actions.clickAndHold(sliderPoint).moveByOffset(-55,0).release().perform();
        String minRange = "0";
        assertTrue(range.getText().equals(minRange));
        actions.moveToElement(sliderPoint).sendKeys(Keys.RIGHT).perform();
    }
    //keep moving the slider towards the max range
    //it should move one step at the time
    @Test
    void sliderAllRangeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement sliderPoint = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.cssSelector("span#range"));
        actions.clickAndHold(sliderPoint).moveByOffset(-45,0).perform();
        while (!range.getText().equals("5")) {
            actions.sendKeys(Keys.UP)
                    .release()
                    .perform();
            Thread.sleep(1000);

        }
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }

    }


