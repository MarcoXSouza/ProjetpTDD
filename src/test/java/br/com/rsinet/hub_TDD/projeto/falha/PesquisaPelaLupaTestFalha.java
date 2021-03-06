package br.com.rsinet.hub_TDD.projeto.falha;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_TDD.projeto.PageObject.LupaPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.DriverFactory;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelData;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class PesquisaPelaLupaTestFalha {
	public static WebDriver driver;
	static ExtentReports extensao;
	static ExtentTest logger;  
	
	@BeforeMethod
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Lupa");
		driver = DriverFactory.iniciaNavegador();
	}

	@AfterMethod
	public static void fechaNavegador() throws Exception {
		String mensagem = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span")).getText();
		Assert.assertFalse(mensagem.equals("No results for " + ExcelData.ultimoNome), "Falha, o item procurado não existe!");
		Snapshot.takeSnapShot("Lupa Falha ", driver);
		DriverFactory.fechaDriver(driver);
		extensao.flush();

	}

	@Test
	public void pesquisaPelaLupa() throws Exception {
		LupaPage.menu(driver).click();
		LupaPage.digita(driver).sendKeys(ExcelData.ultimoNome + Keys.ENTER);
		
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("Report\\Falha\\LupaFalha.html");
        extensao = new ExtentReports();
        extensao.attachReporter(reporte);
        logger = extensao.createTest("LupaFalha Realizado!");
	}

}
