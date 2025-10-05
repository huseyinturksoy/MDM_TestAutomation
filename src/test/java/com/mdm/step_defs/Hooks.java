package com.mdm.step_defs;

import com.mdm.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;

public class Hooks {

    @BeforeStep
    public void horizontalLineStart(Scenario scenario){
        System.err.println("------------------- START STEP -------------------");

        String featureName = scenario.getName().toString();
        System.out.println("Running feature: " + featureName);


    }



    @After
    public void tearDown(Scenario scenario){

        //if scenario fails, it takes screenshot
        if (scenario.isFailed()){
            byte[] screenshot = ( (TakesScreenshot) Driver.getDriver() ).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        //for closing the browser
        Driver.closeDriver();
    }
}
