package br.com.rsinet.hub_TDD.projeto.falha;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_TDD.projeto.PageObject.LupaPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.DriverFactory;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelData;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class PesquisaPelaLupaTestFalha {
	public static WebDriver driver = null;

	public static void main(String[] args) throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Lupa");
		driver = DriverFactory.iniciaNavegador();

		LupaPage.menu(driver).click();
		LupaPage.digita(driver).sendKeys(ExcelData.nome + Keys.ENTER);
		LupaPage.produto(driver).click();
		LupaPage.adicionaAoCarrinho(driver).click();

		Snapshot.takeSnapShot("Lupa Sucesso ", driver);
		DriverFactory.fechaDriver(driver);
	}

}
