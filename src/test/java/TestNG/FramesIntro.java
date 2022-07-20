package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class FramesIntro {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }

    @Test
    void testframe() {
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
        WebElement text = driver.findElement(By.id("tinymce"));
        Assert.assertEquals(text.getText(), "Your content goes here.");
        text.clear();
        text.sendKeys("the internet.hero.com");
        Assert.assertEquals(text.getText(), "the internet.hero.com");
        driver.switchTo().defaultContent();
        WebElement heading = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(heading.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");

    }

    @Test
    void testNestedIframe() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.tagName("body"));
        Assert.assertTrue(left.getText().equals("LEFT"));
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.id("content"));
        Assert.assertTrue(middle.getText().equals(("MIDDLE")));
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        Assert.assertTrue((right.getText().equals("RIGHT")));
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        Assert.assertTrue((bottom.getText().equals("BOTTOM")));


    }

    @Test
    void testIframe2() throws InterruptedException {
        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.switchTo().frame("Frame1");
        WebElement category2= driver.findElement(By.linkText("Category2"));
        category2.click();
        Thread.sleep(2000);
        BrowserUtils.switchWindowByTitle(driver,"BasicJava Archives - qavalidation");
        Assert.assertEquals(driver.getTitle(),"BasicJava Archives - qavalidation");
    }
}

