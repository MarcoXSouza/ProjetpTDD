package br.com.rsinet.hub_TDD.projeto.sucesso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_TDD.projeto.PageObject.CadastroPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.DriverFactory;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelData;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class CadastroDeUsuarioTest {
	public static WebDriver driver;
	WebElement element;
	static ExtentReports extensao;
	static ExtentTest logger;

	@BeforeMethod
	public static void beforeMethod() throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Cadastro");
		driver = DriverFactory.iniciaNavegador();
	}

	@AfterMethod
	public static void fechaNavegador() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlToBe("https://www.advantageonlineshopping.com/#/"));
		String mensagem = driver.getCurrentUrl();
		Assert.assertEquals("https://www.advantageonlineshopping.com/#/", mensagem);
		Snapshot.takeSnapShot("Cadastro Sucesso ", driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DriverFactory.fechaDriver(driver);
		extensao.flush();
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

		ExtentHtmlReporter reporte = new ExtentHtmlReporter("Report\\Sucesso\\CadastroSucesso.html");
        extensao = new ExtentReports();
        extensao.attachReporter(reporte);
        logger = extensao.createTest("Cadastro com Sucesso!");
	}

}
