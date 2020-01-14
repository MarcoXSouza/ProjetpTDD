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

import br.com.rsinet.hub_TDD.projeto.PageObject.CadastarPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;

public class CadastroDeUsuario {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Planilha1");

		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
//		driver.manage().window().maximize();
		driver.get(Constantes.Url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		CadastarPage.linkCadastro(driver).click();
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
		element.sendKeys(Keys.ENTER);

		CadastarPage.Nome(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		CadastarPage.email(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		CadastarPage.senha(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		CadastarPage.confirmarSenha(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		CadastarPage.primeiroNome(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		CadastarPage.ultimoNome(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		CadastarPage.telefone(driver).sendKeys(ExcelUtils.getCellData(1, 3));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select oSelect = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		oSelect.selectByVisibleText("Fiji");

		CadastarPage.cidade(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		CadastarPage.endereco(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		CadastarPage.estado(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		CadastarPage.CEP(driver).sendKeys(ExcelUtils.getCellData(1, 7));

		driver.findElement(By.name("i_agree")).click();
		driver.findElement(By.id("register_btnundefined")).sendKeys(Keys.ENTER);

//		driver.close();
	}

}
