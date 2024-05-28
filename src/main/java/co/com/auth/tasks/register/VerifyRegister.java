package co.com.auth.tasks.register;

import co.com.auth.questions.VerifyAlert;
import org.hamcrest.Matchers;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class VerifyRegister implements Task {

    private final String expectedMessage;

    public VerifyRegister(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    public static VerifyRegister withMessage(String expectedMessage) {
        return new VerifyRegister(expectedMessage);
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        user.should(
                seeThat("The register message is correct",
                        VerifyAlert.text(),
                        Matchers.equalTo(expectedMessage)));
    }
}