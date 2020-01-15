package br.com.rsinet.hub_TDD.projeto.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn {
	public static WebElement element;
	
	public static WebElement preencheNomeLogin(WebDriver driver) {
		element = driver.findElement(By.name("usernameInOrderPayment"));
		return element;
	}

	public static WebElement senhaLogin(WebDriver driver) {
		element = driver.findElement(By.name("passwordInOrderPayment"));
		return element;
	}

	public static WebElement botaoLogin(WebDriver driver) {
		element = driver.findElement(By.id("login_btnundefined"));
		return element;
	}

	public static WebElement proximaPag(WebDriver driver) {
		element = driver.findElement(By.id("next_btn"));
		return element;
	}
	
	

}
