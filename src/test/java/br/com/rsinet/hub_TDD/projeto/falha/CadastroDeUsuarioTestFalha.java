package br.com.rsinet.hub_TDD.projeto.falha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.projeto.PageObject.CadastroPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;

public class CadastroDeUsuarioTestFalha {
	public static WebDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Planilha1");
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get(Constantes.Url);
	}

	@Test
	public void cadastraUsuario() {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		CadastroPage.linkCadastro(driver).click();
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
		element.sendKeys(Keys.ENTER);

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
//		driver.findElement(By.id("register_btnundefined")).sendKeys(Keys.ENTER);
		
		try {
			element = driver.findElement(By.id("register_btnundefined"));
					
		} catch (Exception e) {
//			Assert.assertArrayEquals("O esperado era", , );
		}

	}

	@AfterClass
	public static void fechaNavegador() {
		driver.quit();
	}
}
