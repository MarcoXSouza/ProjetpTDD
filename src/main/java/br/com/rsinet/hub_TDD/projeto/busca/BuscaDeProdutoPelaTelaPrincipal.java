package br.com.rsinet.hub_TDD.projeto.busca;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.projeto.PageObject.Busca;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;

public class BuscaDeProdutoPelaTelaPrincipal {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file,"Planilha1");
		
		driver = new ChromeDriver();

		driver.get(Constantes.Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		
		Busca.escolheLaptop(driver).click();
		Busca.clicaLaptop(driver).click();
		Busca.adicionaAoCarrinho(driver).click();
		Busca.fazCheckout(driver).click();
		
		Busca.preencheNomeLogin(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		Busca.senhaLogin(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		Busca.botaoLogin(driver).click();
		
		Busca.proximaPag(driver).click();
		Busca.pagamentoUsername(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		Busca.Senha(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		Busca.checkboxSalvarSenha(driver).click();
		Busca.botaoPagar(driver).sendKeys(Keys.ENTER);

	}

}
