package br.com.rsinet.hub_TDD.projeto.sucesso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CadastroDeUsuarioTest {
	public static WebDriver driver;
	WebElement element;

//	@Rule

	@BeforeMethod
	public static void beforeMethod() throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Cadastro");
		DriverFactory.iniciaNavegador();
	}

	@AfterMethod
	public static void fechaNavegador() throws IOException, InterruptedException {

		Thread.sleep(2000);
		String mensagem = driver.getCurrentUrl();
		Assert.assertEquals("https://www.advantageonlineshopping.com/#/", mensagem);
		Snapshot.takeSnapShot("Cadastro Sucesso ", driver);
		System.out.println("Usuario cadastrado com sucesso!!!");

		DriverFactory.iniciaNavegador();
	}

	@Test
	public void test() {
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
