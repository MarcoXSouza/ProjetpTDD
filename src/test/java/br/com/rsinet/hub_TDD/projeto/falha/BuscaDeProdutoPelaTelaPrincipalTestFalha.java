package br.com.rsinet.hub_TDD.projeto.falha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.projeto.PageObject.BuscaPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.LogIn;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.DriverFactory;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelData;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class BuscaDeProdutoPelaTelaPrincipalTestFalha {
	public static WebDriver driver;

	@BeforeClass
	public static void iniciaNavegador() throws Exception {
//		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Planilha1");
		driver = DriverFactory.iniciaNavegador();
	}

	@AfterClass
	public static void fechaNavegador() throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		String mensagem = driver.findElement(By.xpath("")).getText();
//		Assert.assertFalse(mensagem.equals(""), "Falha");
//		Snapshot.takeSnapShot("Cadastro falha - 1 ", driver);
		Snapshot.takeSnapShot("Busca Falha ", driver);
		DriverFactory.fechaDriver(driver);
	}

	@Test
	public void compraLaptop() {

		BuscaPage.escolheLaptop(driver).click();
		BuscaPage.clicaLaptop(driver).click();
		BuscaPage.adicionaAoCarrinho(driver).click();
		
		BuscaPage.fazCheckout(driver).click();



	}

}
