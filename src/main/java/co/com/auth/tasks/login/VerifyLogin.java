package co.com.auth.tasks.login;

import co.com.auth.questions.VerifyAlert;
import org.hamcrest.Matchers;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class VerifyLogin implements Task {

    private final String expectedMessage;

    public VerifyLogin(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    public static VerifyLogin withMessage(String expectedMessage) {
        return new VerifyLogin(expectedMessage);
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        user.should(
                seeThat("The login message is correct",
                        VerifyAlert.text(),
                        Matchers.equalTo(expectedMessage)));
    }
}