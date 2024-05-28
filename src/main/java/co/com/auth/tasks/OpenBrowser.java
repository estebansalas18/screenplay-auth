package co.com.auth.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;

public class OpenBrowser implements Task {
    private final String url;

    public OpenBrowser(String url) {
        this.url = url;
    }

    public static OpenBrowser at(String url) {
        return new OpenBrowser(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
