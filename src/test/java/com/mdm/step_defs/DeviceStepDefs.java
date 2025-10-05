package com.mdm.step_defs;

import com.mdm.pages.DevicePage;
import com.mdm.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

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

        /**
          we can make any assertions here by calling the CVS content as string,
          also we can convert it any other data formats by manipulating the string
          */
        String csvContent = Driver.csvContent;

        /** for example we can assert the table headers are included properly or not */
        Assert.assertTrue(csvContent.contains("Famoco ID"));
        Assert.assertTrue(csvContent.contains("Device Note"));
        Assert.assertTrue(csvContent.contains("IMEI"));
        Assert.assertTrue(csvContent.contains("Fleet"));




    }
}
