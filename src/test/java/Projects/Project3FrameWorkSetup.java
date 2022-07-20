package Projects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.bouncycastle.crypto.tls.ContentType.alert;

public class Project3FrameWorkSetup {
    WebDriver driver;
    Actions actions;
    SoftAssert softAssert;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        softAssert = new SoftAssert();
    }

    @Test(description = "click new button")

    public void testCase2() throws InterruptedException {
        driver.get("http://uitestpractice.com/Students/Index");
        WebElement button = driver.findElement(By.linkText("Create New"));
        button.click();
        Thread.sleep(6000);
        actions.click();
        actions.perform();
        Thread.sleep(6000);
        String currentUrl = driver.getWindowHandle();
        Set<String> ids=driver.getWindowHandles();
        for (String id:ids) {
            if (!id.equals(currentUrl)){
                driver.switchTo().window(id);
            }
        }

        driver.findElement(By.name("FirstName")).sendKeys("Tony2");
        driver.findElement(By.name("LastName")).sendKeys("Montana");
        driver.findElement(By.name("EnrollmentDate")).sendKeys("December 25 2022");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //  driver.switchTo().window(currentUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String currentUrl2 = driver.getWindowHandle();
        Set<String> ids2=driver.getWindowHandles();
        for (String id:ids2) {
            if (!id.equals(currentUrl2)){
                driver.switchTo().window(id);
            }
        }
        System.out.println(driver.getCurrentUrl());

        WebElement searchButton = driver.findElement(By.xpath("//input[@class='form-control']"));
        searchButton.sendKeys("Tony");
        driver.findElement(By.xpath("//input[@value='Find']")).click();



        WebElement actualName = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[2]/td[1]"));
        Assert.assertEquals(actualName.getText(), "Tony", "failed");







    }

}
