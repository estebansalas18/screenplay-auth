package co.com.auth.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class VerifyRedirect implements Question<Boolean> {

    private final String expectedUrl;

    public VerifyRedirect(String expectedUrl) {
        this.expectedUrl = expectedUrl;
    }

    public static VerifyRedirect to(String expectedUrl) {
        return new VerifyRedirect(expectedUrl);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        return currentUrl.equals(expectedUrl);
    }
}