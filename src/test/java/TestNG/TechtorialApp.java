package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static utils.ElementsUtils.getText;

public class TechtorialApp {
    @Test
    void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Fatima/Desktop/Techtorial%20(2).html");
        List<WebElement> leftMenuOPrions = driver.findElements(By.cssSelector("tr.mouseOut"));
        List<String> expectedMenuOptions = Arrays.asList("Home", "Java", "Selenium", "Cucumber", "TestNG", "Rest Api", "SQL");
        List<String> actualMenuOptions = getText(leftMenuOPrions);
        Assert.assertEquals(actualMenuOptions, expectedMenuOptions);

    }

    @Test
    void HeaderInfromation() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Fatima/Desktop/Techtorial%20(2).html");
        driver.findElement(By.name("firstName")).sendKeys("Maria");
        driver.findElement(By.name("lastName")).sendKeys(("Joe"));
        driver.findElement(By.name("phone")).sendKeys("7548020098");
        driver.findElement(By.name("userName")).sendKeys("joe@gmail.com");
        driver.findElement(By.name("address1")).sendKeys("1833 S Ocean dr");
        driver.findElement(By.name("address1")).sendKeys("4101 Ravenwood");
        driver.findElement(By.name("city")).sendKeys("miami");
        driver.findElement(By.name("state")).sendKeys("florida");
        driver.findElement(By.name("postalCode")).sendKeys("33009");
        WebElement select = driver.findElement(By.name("country"));
        Select Selectcountry = new Select(select);
        Assert.assertEquals(Selectcountry.getFirstSelectedOption().getText(), "UNITED STATES");
        driver.close();
    }

    @Test
    void validateCountrySelection() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Fatima/Desktop/Techtorial%20(2).html");
        Select Selectcountry = new Select(driver.findElement(By.name("country")));
        Selectcountry.selectByIndex(0);
        Assert.assertEquals(Selectcountry.getFirstSelectedOption().getText(), "ALBANIA", "Test First Options");
        Selectcountry.selectByIndex(Selectcountry.getOptions().size() - 1);
        Assert.assertEquals(Selectcountry.getFirstSelectedOption().getText(), "ZIMBABWE", "Last Options");
        Selectcountry.selectByVisibleText("FINLAND");
        Assert.assertEquals(Selectcountry.getFirstSelectedOption().getText(), "FINLAND", "Visible Text");
        Selectcountry.selectByValue("210");
        Assert.assertEquals(Selectcountry.getFirstSelectedOption().getText(), "UGANDA", "Value Test");
        driver.close();
    }

    @Test
    void ValidateCountOfCountries() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Fatima/Desktop/Techtorial%20(2).html");
        Select Selectcountry = new Select(driver.findElement(By.name("country")));
        Assert.assertEquals(Selectcountry.getOptions().size(), 234, "Test count of countries failed");
        driver.close();
    }

    @Test
    void validateSortingOptions() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Fatima/Desktop/Techtorial%20(2).html");
        Select Selectcountry = new Select(driver.findElement(By.name("country")));
        List<WebElement> CountryElements = Selectcountry.getOptions();
        ArrayList<String> actual = new ArrayList<>();
        ArrayList<String> expectedList = new ArrayList<>();
        for (WebElement country : CountryElements) {
            actual.add(country.getText());
            expectedList.add(country.getText());

        }

        Collections.sort(expectedList);
        Assert.assertEquals(actual, expectedList);
        driver.close();
    }
}
