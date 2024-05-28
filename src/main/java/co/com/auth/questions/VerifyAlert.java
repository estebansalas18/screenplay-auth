package co.com.auth.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;

public class VerifyAlert implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        Alert alert = BrowseTheWeb.as(actor).getDriver().switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public static VerifyAlert text() {
        return new VerifyAlert();
    }
}