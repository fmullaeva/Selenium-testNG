package TestNG;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AirTicket {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        actions=new Actions(driver);
        driver.get("http://blazedemo.com/purchase.php");
    }

    @Test
    void testTicket(){
        driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("David");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("2000 E devon Ave");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Chicago");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("IL");
        driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("60625");
        Select listOfCards = new Select(driver.findElement(By.tagName("select")));
        listOfCards.selectByIndex(2);
        driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("1234 1526 8965 2579");
        driver.findElement(By.xpath("//input[@id='creditCardMonth']")).clear();
        driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("09");
        driver.findElement(By.xpath("//input[@id='creditCardYear']")).clear();
        driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2024");
        driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("David Trump");
        driver.findElement(By.xpath("//label[@class='checkbox']")).click();
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://blazedemo.com/confirmation.php", "failed");

        String currentTitle = driver.getTitle();
        Assert.assertEquals(currentTitle,"BlazeDemo Confirmation", "failed");

        WebElement headerMessage = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(headerMessage.getText(),"Thank you for your purcssshase today!","failed");


    }





}


