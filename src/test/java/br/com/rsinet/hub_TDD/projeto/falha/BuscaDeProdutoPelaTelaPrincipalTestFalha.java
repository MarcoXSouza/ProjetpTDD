package br.com.rsinet.hub_TDD.projeto.falha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.projeto.PageObject.AdicionaAoCarrinhoPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.BuscaPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.LogIn;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.DriverFactory;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelData;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class BuscaDeProdutoPelaTelaPrincipalTestFalha {
	public static WebDriver driver;

	@AfterClass
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Planilha1");
		DriverFactory.iniciaNavegador();
	}

	@BeforeClass
	public static void fechaNavegador() throws Exception {
		Snapshot.takeSnapShot("busca pela home.png", driver);
		DriverFactory.fechaDriver();
	}

	@Test
	public void compraLaptop() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		BuscaPage.escolheLaptop(driver).click();
		BuscaPage.clicaLaptop(driver).click();
		AdicionaAoCarrinhoPage.adicionaAoCarrinho(driver).click();
		AdicionaAoCarrinhoPage.fazCheckout(driver).click();

		LogIn.preencheNomeLogin(driver).sendKeys(ExcelData.nome);
		LogIn.senhaLogin(driver).sendKeys(ExcelData.senha);
		LogIn.botaoLogin(driver).click();

		LogIn.proximaPag(driver).click();

	}

}
