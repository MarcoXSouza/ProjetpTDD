package br.com.rsinet.hub_TDD.projeto.sucesso;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.projeto.PageObject.LupaPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;

public class PesquisaPelaLupaTest {
	public static WebDriver driver;

	@BeforeClass
	public static void antes() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constantes.Url);
	}

	@Test
	public void main() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LupaPage.menu(driver).click();
		LupaPage.digita(driver).sendKeys("HP ElitePad 1000 G2 Tablet" + Keys.ENTER);
		LupaPage.tablet(driver).click();

//		driver.findElement(By.xpath("")).click();
//		driver.findElement(By.xpath("")).click();

	}

	@AfterClass
	public static void closeBrowser() {
//		driver.quit();
	}
}
