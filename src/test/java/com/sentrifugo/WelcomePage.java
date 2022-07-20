package com.sentrifugo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WelcomePage {
    public WelcomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath="//a[title='Departments']")
    public WebElement departmentButton;
    @FindBy(xpath = "//ul[@id='main_ul']/li")
    public List<WebElement> menuOptions;
    @FindBy(className="member_name")
    public WebElement memberName;

    @FindBy(css="div.interview_shed_box span")
    public WebElement interviewDate;
    @FindBy(id="b-id")
    public WebElement profileName;
    @FindBy(partialLinkText = "Logout")
    public WebElement logOutOption;
}


