package com.mdm.pages;

import com.mdm.utils.ConfigurationReader;
import com.mdm.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='kc-login']")
    public WebElement loginButton;





    //--------------------- Methods ---------------------

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("loginUrl"));

        userName.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();

    }

}
