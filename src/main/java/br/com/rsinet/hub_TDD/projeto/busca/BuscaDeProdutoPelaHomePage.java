package br.com.rsinet.hub_TDD.projeto.busca;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_TDD.projeto.PageObject.AdicionaAoCarrinhoPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.BuscaPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.DriverFactory;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class BuscaDeProdutoPelaHomePage {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Home");

		DriverFactory.iniciaNavegador();

		BuscaPage.escolheLaptop(driver).click();
		BuscaPage.clicaLaptop(driver).click();
		AdicionaAoCarrinhoPage.adicionaAoCarrinho(driver).click();
		AdicionaAoCarrinhoPage.fazCheckout(driver).click();

		Snapshot.takeSnapShot("Busca Sucesso ", driver);

//		driver.quit();
		DriverFactory.fechaDriver();
	}

}
