package net.poc.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.poc.model.UserAccount;
import net.poc.ui.AccountRegistrationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

public class CreateAnAccount implements Interaction {

	private UserAccount userAccount;

	public CreateAnAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	@Step("{0} register an account is #userAccount ")
	public <T extends Actor> void performAs(T actor) {
		if (!userAccount.getLoginID().isEmpty()) {
			AccountRegistrationPage.LOGIN.resolveFor(actor).sendKeys(userAccount.getLoginID());
			
		}
		if (!userAccount.getEmail().isEmpty()) {
			AccountRegistrationPage.EMAIL.resolveFor(actor).clear();
			AccountRegistrationPage.EMAIL.resolveFor(actor).sendKeys(userAccount.getEmail());
			BrowseTheWeb.as(actor).getDriver().navigate().back();
		}
		
		AccountRegistrationPage.SUBMIT.resolveFor(actor).click();

	}

	public static Interaction with(UserAccount userAccountl) {
		return instrumented(CreateAnAccount.class, userAccountl);
	}

}
