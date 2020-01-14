package br.com.rsinet.hub_TDD.projeto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.projeto.PageObject.BuscaPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;

public class BuscaDeProdutoPelaTelaPrincipalTest {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Planilha1");

		driver = new ChromeDriver();
		
		driver.get(Constantes.Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();

		BuscaPage.escolheLaptop(driver).click();
		BuscaPage.clicaLaptop(driver).click();
		BuscaPage.adicionaAoCarrinho(driver).click();
		BuscaPage.fazCheckout(driver).click();

		BuscaPage.preencheNomeLogin(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		BuscaPage.senhaLogin(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		BuscaPage.botaoLogin(driver).click();

		BuscaPage.proximaPag(driver).click();
		BuscaPage.pagamentoUsername(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		BuscaPage.Senha(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		BuscaPage.checkboxSalvarSenha(driver).click();
		BuscaPage.botaoPagar(driver).sendKeys(Keys.ENTER);

	}

}
