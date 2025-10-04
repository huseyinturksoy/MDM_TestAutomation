package com.mdm.pages;

import com.mdm.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevicePage extends BasePage{

    public DevicePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//span[.='Devices'])[1]")
    public WebElement deviceMenuButton;

    @FindBy(xpath = "(//span[.='Devices'])[2]")
    public WebElement devicePageHeader;

    @FindBy(xpath = "//button[@id='action_export']")
    public WebElement exportButton;

    @FindBy(xpath = "//button[@id='button_export']")
    public WebElement startExportButton;

    @FindBy(xpath = "(//div[.='Export success'])[6]")
    public WebElement successMessage;



}
