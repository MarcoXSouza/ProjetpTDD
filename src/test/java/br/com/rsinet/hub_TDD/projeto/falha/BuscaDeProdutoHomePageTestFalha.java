package br.com.rsinet.hub_TDD.projeto.falha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.projeto.PageObject.BuscaPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.DriverFactory;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class BuscaDeProdutoHomePageTestFalha {
	public static WebDriver driver;

	@BeforeClass
	public static void iniciaNavegador() throws Exception {
		driver = DriverFactory.iniciaNavegador();
	}

	@AfterClass
	public static void fechaNavegador() throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String mensagem = driver.findElement(By.xpath("//*[@id=\"productProperties\"]/label")).getText();
		Assert.assertTrue(mensagem.equals("Oops! We only have 10 in stock. We updated your order accordingly"),
				"Quantidade excedida");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,250)", "");
		Snapshot.takeSnapShot("Busca Falha ", driver);
		DriverFactory.fechaDriver(driver);
	}

	@Test
	public void compraLaptop() {
		BuscaPage.escolheLaptop(driver).click();
		BuscaPage.clicaLaptop(driver).click();
		BuscaPage.quantidade(driver).sendKeys("11");
		BuscaPage.adicionaAoCarrinho(driver).click();

	}

}
