package br.com.rsinet.hub_TDD.projeto.pesquisa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.projeto.PageObject.AdicionaAoCarrinhoPage;
import br.com.rsinet.hub_TDD.projeto.PageObject.LogIn;
import br.com.rsinet.hub_TDD.projeto.PageObject.LupaPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;

public class PesquisaPelaLupa {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Lupa");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constantes.Url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		LupaPage.menu(driver).click();
		LupaPage.digita(driver).sendKeys("HP ElitePad 1000 G2 Tablet" + Keys.ENTER);
		LupaPage.tablet(driver).click();
		AdicionaAoCarrinhoPage.adicionaAoCarrinho(driver).click();
		AdicionaAoCarrinhoPage.fazCheckout(driver).click();
		LogIn.preencheNomeLogin(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		LogIn.senhaLogin(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		LogIn.botaoLogin(driver).click();
		LogIn.proximaPag(driver).click();
		
//		
		
	}

}
