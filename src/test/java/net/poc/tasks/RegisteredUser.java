package net.poc.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;

import net.poc.interactions.CreateAnAccount;
import net.poc.model.UserAccount;
import net.poc.ui.BottomMenuBarPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class RegisteredUser implements Task {

	private final UserAccount userAccount;

	protected RegisteredUser(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Step("{0} register an new account is #userAccount")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
        		WaitUntil.the(BottomMenuBarPage.CHAT, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
                Click.on(BottomMenuBarPage.CHAT),
                Click.on(BottomMenuBarPage.REGISTER),
                CreateAnAccount.with(userAccount)
        );
    }

	public static RegisteredUser with(UserAccount note) {
		return instrumented(RegisteredUser.class, note);
	}
}