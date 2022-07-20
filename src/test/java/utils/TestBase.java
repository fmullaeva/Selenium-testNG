package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utils.Driver;

public class TestBase {
    public static WebDriver driver;
   public SoftAssert softAssert;
    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        driver=Driver.getDriver(browser);
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
       driver.manage().window().maximize();
       softAssert = new SoftAssert();
    }
}
