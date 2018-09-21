package com.xero.test.cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/Features",
            glue = {"com.xero.test.stepdefinition"
            }
    )
    public class TestRunner  {
    }


