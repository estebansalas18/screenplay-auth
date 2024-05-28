package co.com.auth.tasks.register;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import co.com.auth.models.RegisterModel1;
import co.com.auth.ui.RegisterForm;

public class FillRegister1 implements Task {
    private final RegisterModel1 registerModel;

    public FillRegister1(RegisterModel1 registerModel) {
        this.registerModel = registerModel;
    }

    public static FillRegister1 with(RegisterModel1 registerModel) {
        return new FillRegister1(registerModel);
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(
                Enter.theValue(registerModel.getFirstName()).into(RegisterForm.FIRST_NAME_INPUT),
                Enter.theValue(registerModel.getLastName()).into(RegisterForm.LAST_NAME_INPUT),
                SelectFromOptions.byVisibleText(registerModel.getIdType()).from(RegisterForm.ID_TYPE_SELECT),
                Enter.theValue(registerModel.getIdNumber()).into(RegisterForm.ID_NUMBER_INPUT),
                Enter.theValue(registerModel.getPhoneNumber()).into(RegisterForm.PHONE_NUMBER_INPUT),
                Enter.theValue(registerModel.getBirthDate()).into(RegisterForm.BIRTH_DATE_INPUT));
    }
}
