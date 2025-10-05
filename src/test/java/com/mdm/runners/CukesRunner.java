package com.mdm.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
               // "rerun:target/rerun.txt",
                "json:target/cucumber.json"
        },
        features = "src/test/resources",
        glue = "com/mdm/step_defs",
        dryRun = false,
        tags = "@device"

)
public class CukesRunner {

}
