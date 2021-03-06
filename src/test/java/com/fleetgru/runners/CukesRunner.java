package com.fleetgru.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features ="src/test/resources/features",
        glue = "com/fleetgru/step_definitions",
        dryRun= false,
        tags = "@FLEETG-666"

)

public class CukesRunner {
}
