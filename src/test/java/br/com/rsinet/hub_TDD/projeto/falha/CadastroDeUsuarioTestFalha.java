package br.com.rsinet.hub_TDD.projeto.falha;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.projeto.PageObject.CadastroPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.DriverFactory;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelData;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class CadastroDeUsuarioTestFalha {
	public static WebDriver driver;

	@BeforeMethod
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Cadastro");
		driver = DriverFactory.iniciaNavegador();
		
	}

	@AfterMethod
	public static void fechaNavegador() throws IOException, InterruptedException {
		String mensagem = driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]"))
				.getText();
		System.out.println(mensagem);
		Assert.assertFalse(mensagem.equals("User name already exists"), "Usuario é igual");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.textToBePresentInElement(
				driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]")), "User name already exists"));
		Snapshot.takeSnapShot("Cadastro falha ", driver);
		DriverFactory.fechaDriver(driver);
		
	}
	
	@Test
	public void cadastraUsuario() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		CadastroPage.linkCadastro(driver).click();
		CadastroPage.criarConta(driver);
		CadastroPage.Nome(driver).sendKeys(ExcelData.nome);
		CadastroPage.email(driver).sendKeys(ExcelData.email);
		CadastroPage.senha(driver).sendKeys(ExcelData.senha);
		CadastroPage.confirmarSenha(driver).sendKeys(ExcelData.senha);
		CadastroPage.primeiroNome(driver).sendKeys(ExcelData.nome);
		CadastroPage.ultimoNome(driver).sendKeys(ExcelData.ultimoNome);
		CadastroPage.telefone(driver).sendKeys(ExcelData.telefone);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CadastroPage.pais(driver).sendKeys(ExcelData.pais);
		CadastroPage.cidade(driver).sendKeys(ExcelData.cidade);
		CadastroPage.endereco(driver).sendKeys(ExcelData.endereco);
		CadastroPage.estado(driver).sendKeys(ExcelData.estado);
		CadastroPage.CEP(driver).sendKeys(ExcelData.cep);
		CadastroPage.aceitarTermos(driver).click();
		CadastroPage.btnRegistrar(driver).click();

	}

}
