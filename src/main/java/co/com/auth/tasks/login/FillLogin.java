package co.com.auth.tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import co.com.auth.models.LoginModel;
import co.com.auth.ui.LoginForm;

public class FillLogin implements Task {
    private final LoginModel loginModel;

    public FillLogin(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    public static FillLogin with(LoginModel loginModel) {
        return new FillLogin(loginModel);
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(
                Enter.theValue(loginModel.getUser()).into(LoginForm.USER_INPUT),
                Enter.theValue(loginModel.getPassword()).into(LoginForm.PASSWORD_INPUT));
    }
}
