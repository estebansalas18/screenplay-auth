package co.com.auth.stepdefinitions.login;

import org.openqa.selenium.WebDriver;

import co.com.auth.models.LoginModel;
import co.com.auth.tasks.OpenBrowser;
import co.com.auth.tasks.login.FillLogin;
import co.com.auth.tasks.login.VerifyLogin;
import co.com.auth.ui.LoginForm;

import co.com.auth.utils.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class S2Login {
    @Managed(driver = Constants.BROWSER, uniqueSession = true)
    WebDriver driver;

    private final Actor user = Actor.named("user");

    private final LoginModel loginModel = new LoginModel("john.doe@example.com", "password");

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
        driver.manage().window().maximize();
        driver.switchTo().window(driver.getWindowHandle());
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("que el usuario accede a la pagina de inicio de sesion ")
    public void queElUsuarioAccedeALaPaginaDeInicioDeSesion() {
        this.user.attemptsTo(OpenBrowser.at(Constants.URL + "/Login"));
    }

    @When("ingresa un correo electronico o contrasena incorrectos en el formulario de inicio de sesion")
    public void ingresaUnCorreoElectronicoOContrasenaIncorrectosEnElFormularioDeInicioDeSesion()
            throws InterruptedException {
        this.user.attemptsTo(FillLogin.with(loginModel));
        Thread.sleep(2000);
    }

    @Then("si la informacion es invalida, el sistema no debe permitir al usuario acceder a su cuenta")
    public void siLaInformacionEsInvalidaElSistemaNoDebePermitirAlUsuarioAccederASuCuenta()
            throws InterruptedException {
        this.user.attemptsTo(Click.on(LoginForm.LOGIN_BUTTON));
        Thread.sleep(2000);
    }

    @Then("el sistema debe mostrar un mensaje que indique que la informacion ingresada es incorrecta")
    public void elSistemaDebeMostrarUnMensajeQueIndiqueQueLaInformacionIngresadaEsIncorrecta()
            throws InterruptedException {
        this.user.attemptsTo(VerifyLogin.withMessage("Error: Credenciales incorrectas"));
        Thread.sleep(2000);
    }
}
