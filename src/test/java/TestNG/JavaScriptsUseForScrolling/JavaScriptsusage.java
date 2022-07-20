package TestNG.JavaScriptsUseForScrolling;

import utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptsusage extends TestBase {
    @Test
    void tutorialshut() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://tutorialshut.com/demo-website-for-selenium-automation-practice/'");
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        js.executeScript("document.getElementById('comment').value='Hello! I wrote this using Javascript!';");
        WebElement name = driver.findElement(By.xpath("//input[@name='author']"));
        js.executeScript("arguments[0].value='John'", name);
        js.executeScript("document.getElementById('email').value='john@gmail.com';");
        WebElement website = driver.findElement(By.xpath("//input[@name='url']"));
        js.executeScript("arguments[0].value='techtorial.com'", website);
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='wp-comment-cookies-consent']"));
        js.executeScript("document.getElementById('wp-comment-cookies-consent').checked=true;");
        js.executeScript("document.getElementById('submit').click();");
        WebElement commentResult = driver.findElement(By.xpath("//*[@id='comment-994']/div/div[2]/div/header/div[1]/cite/b/a"));

    }
}
