package br.com.rsinet.hub_TDD.projeto.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaPage {

	public static WebElement element = null;

	public static WebElement escolheLaptop(WebDriver driver) {
		element = driver.findElement(By.id("laptopsImg"));
		return element;
	}

	public static WebElement clicaLaptop(WebDriver driver) {
		element = driver.findElement(By.linkText("HP Chromebook 14 G1(ES)"));
		return element;
	}


}