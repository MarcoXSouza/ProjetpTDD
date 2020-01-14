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

	public static WebElement adicionaAoCarrinho(WebDriver driver) {
		element = driver.findElement(By.name("save_to_cart"));
		return element;
	}

	public static WebElement fazCheckout(WebDriver driver) {
		element = driver.findElement(By.id("checkOutPopUp"));
		return element;
	}

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

}