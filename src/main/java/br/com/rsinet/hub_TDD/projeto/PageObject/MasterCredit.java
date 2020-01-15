package br.com.rsinet.hub_TDD.projeto.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MasterCredit {
	public static WebElement element;

	public static WebElement clicaMaster(WebDriver driver) {
		element = driver.findElement(By.name("masterCredit"));
		return element;
	}
	public static WebElement numeroDoCartao(WebDriver driver) {
		element = driver.findElement(By.id("creditCard"));
		return element;
	}
	
	public static WebElement numeroCVV(WebDriver driver) {
		element = driver.findElement(By.name("cvv_number"));
		return element;
	}
	
	public static WebElement mesDeVencimento(WebDriver driver) {
		element = driver.findElement(By.name("mmListbox"));
		return element;
	}
	public static WebElement anoDeVencimento(WebDriver driver) {
		element = driver.findElement(By.name("yyyyListbox"));
		return element;
	}
	public static WebElement propietarioDoCartao(WebDriver driver) {
		element = driver.findElement(By.name("cardholder_name"));
		return element;
	}
	
	public static WebElement botaoPagar(WebDriver driver) {
		element = driver.findElement(By.id("pay_now_btn_ManualPayment"));
		return element;
		
	}
	
	
	
	
	
	
}
