package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Buttons {
    WebDriver driver;
    Actions actions;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        actions=new Actions(driver);
    }
    @Test(description="test for dymanic click.")
        void TestClick(){
        driver.get("https://demoqa.com/buttons");
        WebElement clickButton=driver.findElement(By.xpath("//button[.='Click Me']"));
        assertTrue(clickButton.isEnabled(),"Test click Failed");
        actions.click(clickButton).perform();
        WebElement clickMessage= driver.findElement(By.id("dynamicClickMessage"));
        assertEquals(clickMessage.getText(),"You have done a dynamic click","test click failed");



    }
    @Test
    void testRightClick(){
        WebElement RightClick=driver.findElement(By.xpath("//button[.='Right Click Me']"));
        assertTrue(RightClick.isEnabled(),"Test Right click Failed");
        actions.contextClick(RightClick).perform();
        WebElement RightClickMessage= driver.findElement(By.id("rightClickMessage"));
        assertEquals(RightClickMessage.getText(),"You have done a right click","test  right click failed");



    }
      @Test
    void testDoubleClick(){
          WebElement DoubleClick=driver.findElement(By.xpath("//button[contains(.,'Double Click')]"));
          assertTrue(DoubleClick.isEnabled(),"Test Double click Failed");
          actions.doubleClick(DoubleClick).perform();
          WebElement DoubleClickMessage= driver.findElement(By.id("doubleClickMessage"));
          assertEquals(DoubleClickMessage.getText(),"You have done a double click","test double click failed");


      }
      @AfterClass
    void tearDown(){
        driver.quit();
      }
}
