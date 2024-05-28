package co.com.auth.tasks.register;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import co.com.auth.models.RegisterModel2;
import co.com.auth.ui.RegisterForm;

public class FillRegister2 implements Task {
    private final RegisterModel2 registerModel;

    public FillRegister2(RegisterModel2 registerModel) {
        this.registerModel = registerModel;
    }

    public static FillRegister2 with(RegisterModel2 registerModel) {
        return new FillRegister2(registerModel);
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(
                Enter.theValue(registerModel.getCountry()).into(RegisterForm.COUNTRY_INPUT),
                Enter.theValue(registerModel.getDepartment()).into(RegisterForm.DEPARTMENT_INPUT),
                Enter.theValue(registerModel.getCity()).into(RegisterForm.CITY_INPUT),
                Enter.theValue(registerModel.getAddress()).into(RegisterForm.ADDRESS_INPUT),
                Enter.theValue(registerModel.getEmail()).into(RegisterForm.EMAIL_INPUT),
                Enter.theValue(registerModel.getPassword()).into(RegisterForm.PASSWORD_INPUT),
                Enter.theValue(registerModel.getConfirmPassword()).into(RegisterForm.CONFIRM_PASSWORD_INPUT));
    }
}
