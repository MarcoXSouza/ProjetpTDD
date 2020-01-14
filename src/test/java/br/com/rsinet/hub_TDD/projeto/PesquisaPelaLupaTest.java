package br.com.rsinet.hub_TDD.projeto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.projeto.PageObject.LupaPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;

public class PesquisaPelaLupaTest {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get(Constantes.Url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LupaPage.menu(driver).click();
		LupaPage.digita(driver).sendKeys("HP ElitePad 1000 G2 Tablet" + Keys.ENTER);
		LupaPage.tablet(driver).click();

//		driver.findElement(By.xpath("")).click();
//		driver.findElement(By.xpath("")).click();

	}

}
