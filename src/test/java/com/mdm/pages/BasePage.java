package com.mdm.pages;

import com.mdm.utils.ConfigurationReader;
import com.mdm.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

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



    //login method
    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("loginUrl"));

        userName.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();

    }

    //csv method
    public File waitForCSV(String dir, String fileName, int timeoutSeconds) {
        File file = new File(dir + "/" + fileName);
        int counter = 0;
        while (!file.exists() && counter < timeoutSeconds) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
        return file;
    }



}
