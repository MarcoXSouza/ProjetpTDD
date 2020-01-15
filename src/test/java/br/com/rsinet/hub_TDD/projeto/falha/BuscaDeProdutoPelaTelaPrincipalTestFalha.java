package br.com.rsinet.hub_TDD.projeto.falha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.projeto.PageObject.AdicionaAoCarrinhoPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.BuscaPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.PagamentoPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.LogIn;
import br.com.rsinet.hub_TDD.projeto.PageObject.Snapshot;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;

public class BuscaDeProdutoPelaTelaPrincipalTestFalha {
	public static WebDriver driver;

	@AfterClass
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Planilha1");
		driver = new ChromeDriver();
		driver.get(Constantes.Url);
	}

	@Test
	public void compraLaptop() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		BuscaPage.escolheLaptop(driver).click();
		BuscaPage.clicaLaptop(driver).click();
		AdicionaAoCarrinhoPage.adicionaAoCarrinho(driver).click();
		AdicionaAoCarrinhoPage.fazCheckout(driver).click();

		LogIn.preencheNomeLogin(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		LogIn.senhaLogin(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		LogIn.botaoLogin(driver).click();

		LogIn.proximaPag(driver).click();
		PagamentoPage.pagamentoUsername(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		PagamentoPage.Senha(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		PagamentoPage.checkboxSalvarSenha(driver).click();
		PagamentoPage.botaoPagar(driver).sendKeys(Keys.ENTER);

	}

	@BeforeClass
	public static void fechaNavegador() throws Exception {
		Snapshot.takeSnapShot("busca pela home.png");
		driver.quit();
	}

}
