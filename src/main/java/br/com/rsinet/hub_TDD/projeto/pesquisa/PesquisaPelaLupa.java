package br.com.rsinet.hub_TDD.projeto.pesquisa;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_TDD.projeto.PageObject.AdicionaAoCarrinhoPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.LupaPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.DriverFactory;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelData;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class PesquisaPelaLupa {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Lupa");
		DriverFactory.iniciaNavegador();
		
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("https://www.advantageonlineshopping.com/#/");
		
		LupaPage.menu(driver).click();
		LupaPage.digita(driver).sendKeys(ExcelData.nome + Keys.ENTER);
		LupaPage.produto(driver).click();
		AdicionaAoCarrinhoPage.adicionaAoCarrinho(driver).click();
		
		Snapshot.takeSnapShot("Lupa Sucesso ", driver);
		driver.quit();
		
	}

}
