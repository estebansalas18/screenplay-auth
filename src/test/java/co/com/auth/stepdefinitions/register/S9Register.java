package co.com.auth.stepdefinitions.register;

import org.openqa.selenium.WebDriver;

import co.com.auth.models.RegisterModel1;
import co.com.auth.models.RegisterModel2;
import co.com.auth.tasks.OpenBrowser;
import co.com.auth.tasks.register.FillRegister1;
import co.com.auth.tasks.register.FillRegister2;
import co.com.auth.tasks.register.VerifyRegister;
import co.com.auth.ui.RegisterForm;

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

public class S9Register {
    @Managed(driver = Constants.BROWSER, uniqueSession = true)
    WebDriver driver;

    private final Actor user = Actor.named("user");

    private final RegisterModel1 registerModel1 = new RegisterModel1(
            "Esteban",
            "Salas",
            "Pasaporte",
            "1111111111",
            "3007483232",
            "15/10/1985");

    private final RegisterModel2 registerModel2 = new RegisterModel2(
            "USA",
            "California",
            "San Francisco",
            "123 Main St, Apt 4B",
            "esteban.salas@example.com",
            "password",
            "password");

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
        driver.manage().window().maximize();
        driver.switchTo().window(driver.getWindowHandle());
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("que el usuario accede a la pagina de registro 9")
    public void queElUsuarioAccedeALaPaginaDeRegistro9() {
        this.user.attemptsTo(OpenBrowser.at(Constants.URL + "/signup"));
    }

    @When("ingresa todos los datos requeridos en el formulario correctamente excepto una contrasenia valida 9")
    public void ingresaTodosLosDatosRequeridosEnElFormularioCorrectamenteExceptoUnaContraseniaValida9()
            throws InterruptedException {
        this.user.attemptsTo(FillRegister1.with(registerModel1));
        this.user.attemptsTo(Click.on(RegisterForm.CONTINUE_BUTTON));
        Thread.sleep(1000);
        this.user.attemptsTo(FillRegister2.with(registerModel2));
        Thread.sleep(1000);
    }

    @Then("el sistema no debe permitir al usuario registrarse 9")
    public void elSistemaNoDebePermitirAlUsuarioRegistrarse9() throws InterruptedException {
        this.user.attemptsTo(Click.on(RegisterForm.REGISTER_BUTTON));
        Thread.sleep(2000);
    }

    @Then("el sistema debe mostrar un mensaje que indique que la contrasenia no es valida 9")
    public void elSistemaDebeMostrarUnMensajeQueIndiqueQueLaContraseniaNoEsValida9() throws InterruptedException {
        this.user.attemptsTo(VerifyRegister.withMessage(
                "La contraseña no es válida"));
        Thread.sleep(1000);
    }
}