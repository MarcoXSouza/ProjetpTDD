package br.com.rsinet.hub_TDD.projeto.sucesso;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.projeto.PageObject.CadastroPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;

public class CadastroDeUsuarioTest {
	public static WebDriver driver;
	WebElement element;
	
//	@Rule

	@BeforeClass
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Cadastro");
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get(Constantes.Url);
	}

	@Test
	public void cadastraUsuario() {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		CadastroPage.linkCadastro(driver).click();
		CadastroPage.criarConta(driver);

		CadastroPage.Nome(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		CadastroPage.email(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		CadastroPage.senha(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		CadastroPage.confirmarSenha(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		CadastroPage.primeiroNome(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		CadastroPage.ultimoNome(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		CadastroPage.telefone(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CadastroPage.pais(driver).sendKeys(ExcelUtils.getCellData(1	, 9));
		CadastroPage.cidade(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		CadastroPage.endereco(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		CadastroPage.estado(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		CadastroPage.CEP(driver).sendKeys(ExcelUtils.getCellData(1, 7));

		driver.findElement(By.name("i_agree")).click();
		driver.findElement(By.id("register_btnundefined")).sendKeys(Keys.ENTER);
		
		try {
			element = driver.findElement(By.id("register_btnundefined"));
					
		} catch (Exception e) {
//			Assert.assertArrayEquals(message, expecteds, actuals);
		}

	}

	@AfterClass
	public static void fechaNavegador() {
		driver.quit();
	}
}
