package TestNG.Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.MBeanAttributeInfo;

public class authenticatedPopup{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //driver.get("http://the-internet.herokuapp.com/basic_auth");
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        // in order to pass popup window use
        //admin:admin@the-internet.herokuapp.com/basic_auth");
        //user:password@URL


    }
}
