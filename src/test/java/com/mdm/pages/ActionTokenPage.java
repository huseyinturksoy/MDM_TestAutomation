package com.mdm.pages;

import com.mdm.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionTokenPage {

    public ActionTokenPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[.='Logs & Access']")
    public WebElement logsAndAccess;

    @FindBy(xpath = "(//span[.='Action Tokens'])[1]")
    public WebElement actionTokenMenuButton;

    @FindBy(xpath = "(//span[.='Action Tokens'])[2]")
    public WebElement actionTokenPageHeader;
    @FindBy(xpath = "//button[@id='create_action']")
    public WebElement newTokenButton;
    @FindBy(xpath = "//input[@id='add_form_name_input']")
    public WebElement newTokenName;
    @FindBy(xpath = "//input[@id='add_form_token_type_dropdown']")
    public WebElement newTokenTypeDropDown;

    @FindBy(xpath = "//div[@id='add_form_token_type_dropdown_item_0']")
    public WebElement putinFleetOption;

    @FindBy(xpath = "//div[@id='add_form_token_type_dropdown_item_1']")
    public WebElement putinRepairOption;

    @FindBy(xpath = "//div[@id='add_form_token_type_dropdown_item_2']")
    public WebElement putinStockOption;

    @FindBy(xpath = "//div[@id='add_form_token_type_dropdown_item_3']")
    public WebElement resetCertificateOption;

    @FindBy(xpath = "//input[@id='add_form_date_picker_field_input']")
    public WebElement datePicker;

    @FindBy(xpath = "//input[@id='add_form_fleet_dropdown']")
    public WebElement addFleetDropDown;

    @FindBy(xpath = "//div[@id='add_form_fleet_dropdown_item_0']")
    public WebElement fleetDropdownFirstOption;

    @FindBy(xpath = "//button[@id='add_form_save_button']")
    public WebElement newTokenSaveButton;

    @FindBy(xpath = "(//div[.='New action token created'])[6]")
    public WebElement createTokenSuccessMessage;

    @FindBy(xpath = "//input[@id='checkbox_select_all_checkbox']")
    public WebElement selectAllCheckbox;

    @FindBy(xpath = "(//button[@id='action_delete'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@id='action_delete_dialog_submit']")
    public WebElement deleteConfirmButton;

    @FindBy(xpath = "//div[@id='toast_title']")
    public WebElement bulkDeleteSuccessMessage;





}
