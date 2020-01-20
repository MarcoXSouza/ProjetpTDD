package br.com.rsinet.hub_TDD.projeto.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPage {
	private static WebElement element;
	public static WebDriver driver;

	public static WebElement linkCadastro(WebDriver driver) {

		element = driver.findElement(By.id("menuUser"));
		return element;
	}

	public static WebElement pais(WebDriver driver) {

		element = driver.findElement(By.name("countryListboxRegisterPage"));
		return element;
	}

	public static WebElement Nome(WebDriver driver) {
		element = driver.findElement(By.name("usernameRegisterPage"));
		return element;
	}

	public static WebElement email(WebDriver driver) {
		element = driver.findElement(By.name("emailRegisterPage"));
		return element;
	}

	public static WebElement senha(WebDriver driver) {
		element = driver.findElement(By.name("passwordRegisterPage"));
		return element;
	}

	public static WebElement confirmarSenha(WebDriver driver) {
		element = driver.findElement(By.name("confirm_passwordRegisterPage"));
		return element;
	}

	public static WebElement primeiroNome(WebDriver driver) {
		element = driver.findElement(By.name("first_nameRegisterPage"));
		return element;
	}

	public static WebElement ultimoNome(WebDriver driver) {
		driver.findElement(By.name("last_nameRegisterPage"));
		return element;
	}

	public static WebElement telefone(WebDriver driver) {
		element = driver.findElement(By.name("phone_numberRegisterPage"));
		return element;
	}

	public static WebElement cidade(WebDriver driver) {
		element = driver.findElement(By.name("cityRegisterPage"));
		return element;
	}

	public static WebElement endereco(WebDriver driver) {
		element = driver.findElement(By.name("addressRegisterPage"));
		return element;
	}

	public static WebElement estado(WebDriver driver) {
		element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
		return element;
	}

	public static WebElement CEP(WebDriver driver) {
		element = driver.findElement(By.name("postal_codeRegisterPage"));
		return element;
	}


	public static WebElement aceitarTermos(WebDriver driver) {
		element = driver.findElement(By.name("i_agree"));
		return element;
	}

	public static WebElement btnRegistrar(WebDriver driver) {
		element = driver.findElement(By.id("register_btnundefined"));
		return element;
	}
	public static WebElement criarConta(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement waitElement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
		waitElement.sendKeys(Keys.ENTER);
		return element;
	}

}
