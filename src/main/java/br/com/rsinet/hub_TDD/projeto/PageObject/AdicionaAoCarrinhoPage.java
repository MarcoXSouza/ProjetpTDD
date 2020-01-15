package br.com.rsinet.hub_TDD.projeto.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdicionaAoCarrinhoPage {
	public static WebElement element = null;

	public static WebElement adicionaAoCarrinho(WebDriver driver) {
		element = driver.findElement(By.name("save_to_cart"));
		return element;
	}

	public static WebElement fazCheckout(WebDriver driver) {
		element = driver.findElement(By.id("checkOutPopUp"));
		return element;
	}

}
