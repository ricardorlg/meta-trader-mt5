package net.poc.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class BottomMenuBarPage {

	public static final Target CHAT = Target.the("chat icon")
			.located(By.id("net.metaquotes.metatrader5:id/bottom_bar_chat"));
	public static final Target QUOTES = Target.the("quotes icon")
			.located(By.id("net.metaquotes.metatrader5:id/bottom_bar_quotes"));
	public static final Target CHART = Target.the("chart icon")
			.located(By.id("net.metaquotes.metatrader5:id/bottom_bar_chart"));
	public static final Target TRADE = Target.the("trade icon")
			.located(By.id("net.metaquotes.metatrader5:id/bottom_bar_trade"));
	public static final Target HISTORY = Target.the("history icon")
			.located(By.id("net.metaquotes.metatrader5:id/bottom_bar_history"));
	public static final Target NEWS = Target.the("news icon")
			.located(By.id("net.metaquotes.metatrader5:id/bottom_bar_news"));
	
	public static final Target REGISTER = Target.the("register linktext")
			.located(By.xpath("//android.widget.TextView[@text='REGISTER']"));
	
    public static final Target SIGN_IN = Target.the("Signin button")
    		.located(By.id("net.metaquotes.metatrader5:id/login_button"));
	
}
