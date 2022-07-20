package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MDBMultipleSelectons {
    @Test
    public void testMultipleSelections(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://mdbootstrap.com/docs/standard/extended/multiselect/");
//        WebElement dropDown=driver.findElement(By.xpath("select select-initialized"));
////        Select select=new Select(dropDown);
////
//        dropDown.click();
    }
}
