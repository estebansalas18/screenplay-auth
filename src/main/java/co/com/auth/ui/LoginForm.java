package co.com.auth.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class LoginForm {
    public static final Target USER_INPUT = Target.the("User input").located(By.id("username"));
    public static final Target PASSWORD_INPUT = Target.the("Password input").located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .located(By.xpath("/html/body/div/div/div[1]/div[2]/form/div[3]/button"));
}
