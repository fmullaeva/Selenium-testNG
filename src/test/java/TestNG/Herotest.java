package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Herotest {
    @Test

    void herokuHover(){
        WebDriverManager.chromedriver().setup();
        WebDriver chrome=new ChromeDriver();
        chrome.get("https://the-internet.herokuapp.com/hovers");
        //chrome.manage().window().maximize();
      //  WebElement user1=chrome.findElement(By.xpath(""));
       // Actions actions=new Actions(chrome);
       // actions.moveToElement(user1).perform();
       // chrome.close();
        List<WebElement> users=chrome.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<WebElement> userHeadings=chrome.findElements(By.tagName("h5"));
        Actions action=new Actions(chrome);
        int i=0;
        for(WebElement user:users){
            action.moveToElement(user).perform();
            Assert.assertTrue(userHeadings.get(i++).getText().contains("name:user"));
        }



    }
}
