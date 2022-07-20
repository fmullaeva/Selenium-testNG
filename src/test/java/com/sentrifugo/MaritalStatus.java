package com.sentrifugo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MaritalStatus {
    public MaritalStatus(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//input[@title='Add'")
    public WebElement addButton;

    @FindBy(xpath="//div[@class='total-form-controller']//label")
    public List<WebElement> labels;

    @FindBy(id="maritalcode")
    public WebElement maritalCode;

    @FindBy(id="maritalstatusname")
    public WebElement maritalStatus;

    @FindBy(id="description")
    public WebElement submitButton;


    @FindAll({
            @FindBy(id="errors-maritalcode"),
            @FindBy(id="errors-maritalstatusname")
    })
    public List<WebElement> errorMessages;

    @FindBy(css="")
}
