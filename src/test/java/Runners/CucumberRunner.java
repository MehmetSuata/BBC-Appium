package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "Test_Steps",
        features = "src/test/resources/features",
        dryRun = false,
        tags = "@bbc",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports/cucumber1.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:target/default-report",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }

)
public class CucumberRunner {


}