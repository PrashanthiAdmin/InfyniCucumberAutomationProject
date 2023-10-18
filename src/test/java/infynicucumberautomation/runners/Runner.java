package infynicucumberautomation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"Features"},
                                        glue = {"infynicucumberautomation.stepdefinitions"},
                                        plugin = {"pretty", "html:target/cucumber-reports/cucumberreport.html"},
                                        tags = "@logintest",
                                        monochrome = true
                                        )
public class Runner extends AbstractTestNGCucumberTests{

}
