package com.mdm.step_defs;

import com.mdm.pages.ActionTokenPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ActionTokenStepDefs {
    ActionTokenPage tokenPage = new ActionTokenPage();

    @And("User navigates to action token page")
    public void userNavigatesToActionTokenPage() {
        tokenPage.logsAndAccess.click();
        tokenPage.actionTokenMenuButton.click();
        Assert.assertTrue(tokenPage.actionTokenPageHeader.isDisplayed());

    }

    @And("User creates an action token for put in {string}")
    public void userCreatesAnActionTokenForPutInFleet(String tokenType) throws InterruptedException {
        tokenPage.newTokenButton.click();
        Assert.assertTrue(tokenPage.newTokenName.isDisplayed());
        tokenPage.newTokenName.sendKeys(tokenType);
        tokenPage.newTokenTypeDropDown.click();
        Thread.sleep(2000);
        switch (tokenType) {
            case "put in fleet":
                tokenPage.putinFleetOption.click();
                Thread.sleep(2000);
                tokenPage.addFleetDropDown.click();
                Thread.sleep(2000);
                tokenPage.fleetDropdownFirstOption.click();
                break;
            case "put in repair":
                tokenPage.putinRepairOption.click();
                break;
            case "put in stock":
                tokenPage.putinStockOption.click();
                break;
            case "reset device certificate":
                tokenPage.resetCertificateOption.click();
                break;
        }


        tokenPage.datePicker.click();

        /** the date here is hardcoded, it could be defined as random future date by using
        faker class as we have limited time for this project, I will use hardcoded date */
        tokenPage.datePicker.sendKeys("12122026");
        tokenPage.newTokenSaveButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(tokenPage.createTokenSuccessMessage.isDisplayed());

    }


    @Then("User performs bulk delete of all action tokens")
    public void userPerformsBulkDeleteOfAllActionTokens() throws InterruptedException {
        tokenPage.selectAllCheckbox.click();
        tokenPage.deleteButton.click();
        Assert.assertTrue(tokenPage.deleteConfirmButton.isDisplayed());
        tokenPage.deleteConfirmButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(tokenPage.bulkDeleteSuccessMessage.isDisplayed());

    }

}
