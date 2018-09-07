package net.poc.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class AccountRegistrationPage {

	public static final Target LOGIN = Target.the("login filed")
			.located(By.id("net.metaquotes.metatrader5:id/login"));
	public static final Target EMAIL = Target.the("email filed")
			.located(By.id("net.metaquotes.metatrader5:id/email"));
	public static final Target SUBMIT = Target.the("get account")
			.located(By.id("net.metaquotes.metatrader5:id/register_title"));
}
