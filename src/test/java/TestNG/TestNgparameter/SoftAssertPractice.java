package TestNG.TestNgparameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
        public class SoftAssertPractice {
            WebDriver driver;
            SoftAssert softAssert;
            @BeforeClass
            void setUp(){
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                softAssert=new SoftAssert();
                driver.manage().window().maximize();
            }
            @Parameters({"username","password"})
            @Test(description = "testing verification and validation of log in functionality")
            void testLogIn(String username, String password){
                driver.get("https://www.saucedemo.com/");
                WebElement userName = driver.findElement(By.xpath("//input[@name='user-name']"));
                userName.sendKeys(username);
                WebElement passWord = driver.findElement(By.cssSelector("#password"));
                passWord.sendKeys(password);
                driver.findElement(By.xpath("//input[@type='submit']")).click();
                WebElement burgerButton= driver.findElement(By.cssSelector("#react-burger-menu-btn"));
                burgerButton.click();
                Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed());
                List<WebElement> items = driver.findElements(By.className("inventory_item"));
                for (WebElement item: items){
                    softAssert.assertTrue(item.getText().contains("Backpack"));
                }
                softAssert.assertAll();

            }

        }