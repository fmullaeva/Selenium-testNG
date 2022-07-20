package com.sentrifugo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Gender {
    public Gender(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="87")
    public WebElement maritalStatusButton;
}
