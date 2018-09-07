package serenitybdd.appiumtest.features;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import net.poc.model.UserAccount;
import net.poc.tasks.RegisteredUser;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;

@RunWith(SerenityRunner.class)
public class WhenUsersRegisterAccountStory {

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
	public void user_register_new_account() {
		// GIVEN
		UserAccount userId = new UserAccount
								.UserAccountBuilder()
								.called("jacobvu")
								.withEmail("LinhVu$32!")
								.build();

		theActorCalled(jacob).can(BrowseTheWeb.with(hisMobileDevice));

		// WHEN 
		theActorInTheSpotlight().attemptsTo(RegisteredUser.with(userId));
		//THEN
		/*theActorInTheSpotlight().should(seeThat(MenuBar.numberOfItems(), is(10)),
				seeThat(MenuBar.displayed(), hasItem("Quotes")));*/
	}

}