package br.com.rsinet.hub_TDD.projeto.busca;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.projeto.PageObject.AdicionaAoCarrinhoPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.BuscaPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.LogIn;
import br.com.rsinet.hub_TDD.projeto.PageObject.PagamentoPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;

public class BuscaDeProdutoPelaHomePage {
	public static WebDriver driver;


	public static void main(String[] args) throws Exception {

		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Home");

		driver = new ChromeDriver();
		driver.get(Constantes.Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();

		BuscaPage.escolheLaptop(driver).click();
		BuscaPage.clicaLaptop(driver).click();
		AdicionaAoCarrinhoPage.adicionaAoCarrinho(driver).click();
		AdicionaAoCarrinhoPage.fazCheckout(driver).click();

		LogIn.preencheNomeLogin(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		LogIn.senhaLogin(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		LogIn.botaoLogin(driver).click();

		LogIn.proximaPag(driver).click();
		PagamentoPage.meioDePagamentoSafePay(driver).click();
		PagamentoPage.pagamentoUsername(driver).clear();
		PagamentoPage.pagamentoUsername(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		PagamentoPage.Senha(driver).clear();
		PagamentoPage.Senha(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		PagamentoPage.checkboxSalvarSenha(driver).click();
		PagamentoPage.botaoPagar(driver).sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

}

