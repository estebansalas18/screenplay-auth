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

public class S7Register {
    @Managed(driver = Constants.BROWSER, uniqueSession = true)
    WebDriver driver;

    private final Actor user = Actor.named("user");

    private final RegisterModel1 registerModel1 = new RegisterModel1(
            "Esteban",
            "Salas",
            "Pasaporte",
            "1111111111",
            "3007483232",
            "15/10/2010");

    private final RegisterModel2 registerModel2 = new RegisterModel2(
            "USA",
            "California",
            "San Francisco",
            "123 Main St, Apt 4B",
            "esteban.salas@prueba.com",
            "Password1!",
            "Password1!");

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
        driver.manage().window().maximize();
        driver.switchTo().window(driver.getWindowHandle());
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("que el usuario accede a la pagina de registro 7")
    public void queElUsuarioAccedeALaPaginaDeRegistro7() {
        this.user.attemptsTo(OpenBrowser.at(Constants.URL + "/signup"));
    }

    @When("ingresa todos los datos requeridos en el formulario con una fecha de nacimiento menor a 18 anios 7")
    public void ingresaTodosLosDatosRequeridosEnElFormularioConUnaFechaDeNacimientoMenorA18Anios7()
            throws InterruptedException {
        this.user.attemptsTo(FillRegister1.with(registerModel1));
        this.user.attemptsTo(Click.on(RegisterForm.CONTINUE_BUTTON));
        Thread.sleep(1000);
        this.user.attemptsTo(FillRegister2.with(registerModel2));
        Thread.sleep(1000);
    }

    @Then("el sistema no debe permitir al usuario registrarse 7")
    public void elSistemaNoDebePermitirAlUsuarioRegistrarse7() throws InterruptedException {
        this.user.attemptsTo(Click.on(RegisterForm.REGISTER_BUTTON));
        Thread.sleep(2000);
    }

    @Then("el sistema debe mostrar un mensaje de error que indique no validar el registro con una fecha nacimiento menor a 18 anios 7")
    public void elSistemaDebeMostrarUnMensajeDeErrorQueIndiqueNoValidarElRegistroConUnaFechaNacimientoMenorA18Anios7()
            throws InterruptedException {
        this.user.attemptsTo(VerifyRegister.withMessage("Debes ser mayor de 18 años para registrarte"));
        Thread.sleep(1000);
    }
}
