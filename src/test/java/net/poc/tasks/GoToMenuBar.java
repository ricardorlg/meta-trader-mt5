package net.poc.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;

import net.poc.ui.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class GoToMenuBar implements Task {

	@Step("{0} shows the menu panel  ")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				WaitUntil.the(DashboardPage.MAIN_NAVIGATE_BUTTON, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
				// Check.whether(the(DashboardPage.MAIN_TILE), isCurrentlyVisible())
				// .andIfSo(WaitUntil.the(DashboardPage.MAIN_TILE, isNotCurrentlyVisible())),

				Click.on(DashboardPage.MAIN_NAVIGATE_BUTTON)

		);
	}

	public static GoToMenuBar showMenuPanel() {
		return instrumented(GoToMenuBar.class);
	}

}
