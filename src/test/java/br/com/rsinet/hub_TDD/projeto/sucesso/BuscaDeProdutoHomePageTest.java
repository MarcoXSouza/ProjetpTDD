package br.com.rsinet.hub_TDD.projeto.sucesso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_TDD.projeto.PageObject.BuscaPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.DriverFactory;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class BuscaDeProdutoHomePageTest {
	public static WebDriver driver;
	static ExtentReports extensao;
	static ExtentTest logger;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Home");
		driver = DriverFactory.iniciaNavegador();

	}

	@AfterMethod
	public void afterMethod() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String mensagem = driver.findElement(By.xpath("//*[@id=\"shoppingCartLink\"]/span")).getText();
		Assert.assertTrue(mensagem.equals("1"), "Sucesso!");
		Snapshot.takeSnapShot("Busca Sucesso ", driver);
		DriverFactory.fechaDriver(driver);
		extensao.flush();

	}

	@Test
	public void test() {
		BuscaPage.escolheLaptop(driver).click();
		BuscaPage.clicaLaptop(driver).click();
		BuscaPage.adicionaAoCarrinho(driver).click();
		
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("Report\\Sucesso\\BuscaSucesso.html");
        extensao = new ExtentReports();
        extensao.attachReporter(reporte);
        logger = extensao.createTest("Busca Sucesso!");

	}

}
