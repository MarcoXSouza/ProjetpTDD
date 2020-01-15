package br.com.rsinet.hub_TDD.projeto.cadastro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.projeto.PageObject.CadastroPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;

public class CadastroDeUsuario {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Cadastro");

		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get(Constantes.Url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//		cria nova conta
		CadastroPage.linkCadastro(driver).click();
		CadastroPage.criarConta(driver);
//		envia os dados necessarios para o cadastro
		CadastroPage.Nome(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		CadastroPage.email(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		CadastroPage.senha(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		CadastroPage.confirmarSenha(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		CadastroPage.primeiroNome(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		CadastroPage.ultimoNome(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		CadastroPage.telefone(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		CadastroPage.pais(driver).sendKeys(ExcelUtils.getCellData(1, 9));
		CadastroPage.cidade(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		CadastroPage.endereco(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		CadastroPage.estado(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		CadastroPage.CEP(driver).sendKeys(ExcelUtils.getCellData(1, 7));
//		Aceita os termos e cria nova conta
		CadastroPage.aceitarTermos(driver).click();
//		CadastroPage.btnRegistrar(driver).sendKeys(Keys.ENTER);

//		Tira print do resultado
		CadastroPage.takeSnapShot("cadastro");
//		Fecha o navegador
//		driver.close();
	}

}
