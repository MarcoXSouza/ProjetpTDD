package br.com.rsinet.hub_TDD.projeto.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PagamentoPage {
	public static WebElement element;

	public static WebElement pagamentoUsername(WebDriver driver) {
		element = driver.findElement(By.name("safepay_username"));
		return element;
	}

	public static WebElement Senha(WebDriver driver) {
		element = driver.findElement(By.name("safepay_password"));
		return element;
	}

	public static WebElement checkboxSalvarSenha(WebDriver driver) {
		element = driver.findElement(By.name("save_safepay"));
		return element;
	}

	public static WebElement botaoPagar(WebDriver driver) {
		element = driver.findElement(By.id("pay_now_btn_SAFEPAY"));
		return element;
	}

	public static WebElement meioDePagamentoSafePay(WebDriver driver) {
		element = driver.findElement(By.name("safepay"));
		return element;
	}

}
