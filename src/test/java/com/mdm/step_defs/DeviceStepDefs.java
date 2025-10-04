package com.mdm.step_defs;

import com.mdm.pages.DevicePage;
import com.mdm.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeviceStepDefs {

    DevicePage devicePage = new DevicePage();

    @Given("User logs in to the application")
    public void userLogsInToTheApplication() {
        devicePage.login();
        Assert.assertTrue(devicePage.deviceMenuButton.isDisplayed());
    }

    @And("User navigates to device page")
    public void userNavigatesToDevicePage() {

        devicePage.deviceMenuButton.click();
        Assert.assertTrue(devicePage.devicePageHeader.isDisplayed());

    }

    @When("User makes a bulk export of all devices")
    public void Usermakesabulkexportofalldevices() throws InterruptedException {

        devicePage.exportButton.click();
        devicePage.startExportButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(devicePage.successMessage.isDisplayed());

    }

    @Then("User validates the cvs file contains the related datas")
    public void userValidatesTheCvsFileContainsTheRelatedDatas() {
    }
}
