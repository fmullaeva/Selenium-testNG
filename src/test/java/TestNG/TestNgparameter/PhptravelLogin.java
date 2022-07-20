package TestNG.TestNgparameter;

import utils.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PhptravelLogin  extends TestBase {
    @Test(dataProvider="credentials",dataProviderClass =PhpTravelsTestData.class)
void phpInTest(String username,String password){
    driver.navigate().to("https://phptravels.com/demo/");
    driver.findElement(By.xpath("//div[@class='form-group']/input[@name='email']")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button{@type='submit']")).click();
    }
}
