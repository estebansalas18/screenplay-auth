package co.com.auth.tasks;

import co.com.auth.questions.VerifyRedirect;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckRedirect implements Task {

    private final String expectedUrl;

    public CheckRedirect(String expectedUrl) {
        this.expectedUrl = expectedUrl;
    }

    public static CheckRedirect to(String expectedUrl) {
        return new CheckRedirect(expectedUrl);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                seeThat("User is redirected", VerifyRedirect.to(expectedUrl), equalTo(true)));
    }
}