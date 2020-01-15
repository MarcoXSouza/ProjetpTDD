package br.com.rsinet.hub_TDD.projeto.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LupaPage {
	public static WebElement element = null;

	public static WebElement menu(WebDriver driver) {
		element = driver.findElement(By.id("menuSearch"));
		return element;
	}

	public static WebElement digita(WebDriver driver) {
		element = driver.findElement(By.id("autoComplete"));
		return element;
	}
	public static WebElement tablet(WebDriver driver) {
		element = driver.findElement(By.linkText("HP ElitePad 1000 G2 Tablet"));
		return element;
	}
	public static WebElement adicionaAoCarrinho(WebDriver driver) {
		element = driver.findElement(By.name("save_to_cart"));
		return element;
	}
	public static WebElement fazerCheckout(WebDriver driver) {
		element = driver.findElement(By.id("checkOutPopUp"));
		return element;
	}	


	
}
