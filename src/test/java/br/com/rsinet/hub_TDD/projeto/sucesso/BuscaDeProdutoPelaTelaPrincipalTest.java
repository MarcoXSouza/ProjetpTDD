package br.com.rsinet.hub_TDD.projeto.sucesso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.projeto.PageObject.AdicionaAoCarrinhoPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.BuscaPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.DriverFactory;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class BuscaDeProdutoPelaTelaPrincipalTest {
	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Home");
		DriverFactory.iniciaNavegador();
		
	}

	@AfterMethod
	public void afterMethod() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		String mensagem = "";
//		Assert.assertTrue(mensagem.equals("User name already exists"), "Falha");
		Snapshot.takeSnapShot("Busca Sucesso ", driver);
		DriverFactory.fechaDriver();

	}

	@Test
	public void test() {
		BuscaPage.escolheLaptop(driver).click();
		BuscaPage.clicaLaptop(driver).click();
		AdicionaAoCarrinhoPage.adicionaAoCarrinho(driver).click();

	}
	
}
