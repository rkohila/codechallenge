package com.kano;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.kano.stepdef",
        features = "src/test/resources/",
        format ={"json:target/codechallenge/codechallenge.json","pretty", "html:target/codechallenge"})
public class CodeChallengeRunner {
}
