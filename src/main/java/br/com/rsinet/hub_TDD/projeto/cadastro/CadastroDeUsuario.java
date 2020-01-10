package br.com.rsinet.hub_TDD.projeto.cadastro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.projeto.PageObject.Cadastar;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;

public class CadastroDeUsuario {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
//		driver.manage().window().maximize();
		driver.get(Constantes.Url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Cadastar.linkCadastro(driver).click();
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
		element.sendKeys(Keys.ENTER);

		Cadastar.Nome(driver).sendKeys(Constantes.nome);
		Cadastar.email(driver).sendKeys(Constantes.email);
		Cadastar.senha(driver).sendKeys(Constantes.senha);
		Cadastar.confirmarSenha(driver).sendKeys(Constantes.senha);
		Cadastar.primeiroNome(driver).sendKeys(Constantes.primeiroNome);
		Cadastar.ultimoNome(driver).sendKeys(Constantes.ultimoNome);
		Cadastar.telefone(driver).sendKeys(Constantes.telefone);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select oSelect = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		oSelect.selectByVisibleText("Fiji");
		Cadastar.cidade(driver).sendKeys(Constantes.cidade);
		Cadastar.endereco(driver).sendKeys(Constantes.endereco);
		Cadastar.estado(driver).sendKeys(Constantes.estado);
		Cadastar.CEP(driver).sendKeys(Constantes.CEP);

		driver.findElement(By.name("i_agree")).click();
		driver.findElement(By.id("register_btnundefined")).sendKeys(Keys.ENTER);


//		driver.close();
	}

}
