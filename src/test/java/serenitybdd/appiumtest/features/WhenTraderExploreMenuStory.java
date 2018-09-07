package serenitybdd.appiumtest.features;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import net.poc.questions.factory.MenuBar;
import net.poc.tasks.GoToMenuBar;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;

@RunWith(SerenityRunner.class)
public class WhenTraderExploreMenuStory {

	@Managed(driver = "Appium")
	public WebDriver hisMobileDevice;

	String jacob = "Trader";
	static AppiumDriverLocalService appiumService = null;

	@BeforeClass
	public static void startAppiumServer() throws IOException {
		appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
	}

	@Before
	public void annaCanBrowseTheMobileApp() throws MalformedURLException {
		OnStage.setTheStage(new OnlineCast());
	}

	@AfterClass
	public static void stopAppiumServer() {
		appiumService.stop();
	}

	@Test
	public void observe_menu_bar() {

		theActorCalled(jacob).can(BrowseTheWeb.with(hisMobileDevice));

		theActorInTheSpotlight().attemptsTo(GoToMenuBar.showMenuPanel());

		theActorInTheSpotlight().should(seeThat(MenuBar.numberOfItems(), is(10)),
				seeThat(MenuBar.displayed(), hasItem("Quotes")),
				seeThat(MenuBar.displayed(), hasItem("Charts")),
				seeThat(MenuBar.displayed(), hasItem("Trade")),
				seeThat(MenuBar.displayed(), hasItem("History")),
				seeThat(MenuBar.displayed(), hasItem("Mailbox")),
				seeThat(MenuBar.displayed(), hasItem("News")),
				seeThat(MenuBar.displayed(), hasItem("Messages")),
				seeThat(MenuBar.displayed(), hasItem("Settings")),
				seeThat(MenuBar.displayed(), hasItem("Journal")),
				seeThat(MenuBar.displayed(), hasItem("About")));
	}

}