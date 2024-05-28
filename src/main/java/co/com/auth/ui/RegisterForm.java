package co.com.auth.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class RegisterForm {
    public static final Target FIRST_NAME_INPUT = Target.the("First name input").located(By.id("first-name-input"));
    public static final Target LAST_NAME_INPUT = Target.the("Last name input").located(By.id("last-name-input"));
    public static final Target ID_TYPE_SELECT = Target.the("Id type select").located(By.id("id-type-dropdown"));
    public static final Target ID_NUMBER_INPUT = Target.the("Id number input").located(By.id("identification-input"));
    public static final Target PHONE_NUMBER_INPUT = Target.the("Phone number input")
            .located(By.id("phone-number-input"));
    public static final Target BIRTH_DATE_INPUT = Target.the("Birth date input").located(By.id("birthday"));
    public static final Target CONTINUE_BUTTON = Target.the("Continue button")
            .located(By.xpath("//*[@id=\"footer\"]/div[2]/button"));
    public static final Target COUNTRY_INPUT = Target.the("Country input").located(By.id("country-input"));
    public static final Target DEPARTMENT_INPUT = Target.the("Department input").located(By.id("region-input"));
    public static final Target CITY_INPUT = Target.the("City input").located(By.id("city-input"));
    public static final Target ADDRESS_INPUT = Target.the("Address input").located(By.id("address-input"));
    public static final Target EMAIL_INPUT = Target.the("Email input").located(By.id("email-input"));
    public static final Target PASSWORD_INPUT = Target.the("Password input").located(By.id("password-input"));
    public static final Target CONFIRM_PASSWORD_INPUT = Target.the("Confirm password input")
            .located(By.id("confirm-password-input"));
    public static final Target REGISTER_BUTTON = Target.the("Register button")
            .located(By.xpath("//*[@id=\"footer\"]/div[2]/button"));
}
