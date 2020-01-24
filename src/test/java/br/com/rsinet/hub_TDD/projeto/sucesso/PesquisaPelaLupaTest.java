package br.com.rsinet.hub_TDD.projeto.sucesso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

public class PesquisaPelaLupaTest {
	public static WebDriver driver;
	ExtentReports extensao;
	ExtentTest logger;

	@BeforeClass
	public static void antes() throws Exception {
		driver = DriverFactory.iniciaNavegador();
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Lupa");
	}

	@AfterClass
	public static void closeBrowser() throws IOException, InterruptedException {
		String mensagem = driver.findElement(By.xpath("//*[@id=\"Description\"]/h1")).getText();
		System.out.println(mensagem);
		Assert.assertFalse(mensagem.equals(ExcelData.nome), "Sucesso!");
		Snapshot.takeSnapShot("Lupa Sucesso ", driver);
		DriverFactory.fechaDriver(driver);
	}

	@Test
	public void main() throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LupaPage.menu(driver).click();
		LupaPage.digita(driver).sendKeys(ExcelData.nome + Keys.ENTER);
//		LupaPage.produto(driver).click();
		LupaPage.adicionaAoCarrinho(driver).click();
	
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("C:\\Users\\marcos.souza\\Documents\\Marcos\\Java\\Marcos\\ProjetoAvaliacaoTDD\\workspace\\projeto\\Report\\");
        extensao = new ExtentReports();
        extensao.attachReporter(reporte);
        logger = extensao.createTest("Lupa Sucesso!");
		
	}

}
