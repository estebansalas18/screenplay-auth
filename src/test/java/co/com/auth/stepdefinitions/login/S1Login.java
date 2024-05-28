package co.com.auth.stepdefinitions.login;

import org.openqa.selenium.WebDriver;

import co.com.auth.models.LoginModel;
import co.com.auth.tasks.CheckRedirect;
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

public class S1Login {
    @Managed(driver = Constants.BROWSER, uniqueSession = true)
    WebDriver driver;

    private final Actor user = Actor.named("user");

    private final LoginModel loginModel = new LoginModel("john.doe@example.com", "Aj_H|u4{p85v/!{3+kp");

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
        driver.manage().window().maximize();
        driver.switchTo().window(driver.getWindowHandle());
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("que el usuario accede a la pagina de inicio de sesion")
    public void queElUsuarioAccedeALaPaginaDeInicioDeSesion() {
        this.user.attemptsTo(OpenBrowser.at(Constants.URL + "/Login"));
    }

    @When("ingresa su correo electronico y contrasena en el formulario de inicio de sesion")
    public void ingresaSuCorreoElectronicoYContrasenaEnElFormularioDeInicioDeSesion() throws InterruptedException {
        this.user.attemptsTo(FillLogin.with(loginModel));
        Thread.sleep(2000);
    }

    @Then("si la informacion es valida, el sistema debe permitir al usuario acceder a su cuenta")
    public void siLaInformacionEsValidaElSistemaDebePermitirAlUsuarioAccederASuCuenta() throws InterruptedException {
        this.user.attemptsTo(Click.on(LoginForm.LOGIN_BUTTON));
        Thread.sleep(2000);
    }

    @Then("el sistema debe mostrar un mensaje que indique que el usuario ha iniciado sesion correctamente")
    public void elSistemaDebeMostrarUnMensajeQueIndiqueQueElUsuarioHaIniciadoSesionCorrectamente()
            throws InterruptedException {
        this.user.attemptsTo(VerifyLogin.withMessage("Inicio de sesion exitoso"));
        Thread.sleep(2000);
    }

    @Then("el usuario es redirigido a la pagina de inicio")
    public void elUsuarioEsRedirigidoALaPaginaDeInicio() throws InterruptedException {
        this.user.attemptsTo(
                CheckRedirect.to(Constants.URL + "/Main-menu"));
        Thread.sleep(2000);
    }
}
