package net.poc.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class DashboardPage {

	public static final Target MAIN_TILE = Target.the("Open Demo Account")
			.located(By.id("net.metaquotes.metatrader5:id/main_title"));
	public static final Target MAIN_NAVIGATE_BUTTON = Target.the("hamburger button")
			.located(By.id("net.metaquotes.metatrader5:id/actionbar_back"));
	public static final Target MENU_ITEMS = Target.the("sub menu")
			.located(By.id("net.metaquotes.metatrader5:id/drawer_name"));
	
	public static final String MENU_LABEL = "net.metaquotes.metatrader5:id/drawer_name";

}
