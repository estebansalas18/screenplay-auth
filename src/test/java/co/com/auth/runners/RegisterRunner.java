package co.com.auth.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/register.feature", glue = "co.com.auth.stepdefinitions.register", snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RegisterRunner {

}
