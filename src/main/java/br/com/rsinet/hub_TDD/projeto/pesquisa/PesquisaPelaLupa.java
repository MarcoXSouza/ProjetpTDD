package br.com.rsinet.hub_TDD.projeto.pesquisa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.projeto.PageObject.Lupa;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;

public class PesquisaPelaLupa {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constantes.Url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Lupa.menu(driver).click();
		Lupa.digita(driver).sendKeys("HP ElitePad 1000 G2 Tablet" + Keys.ENTER);
		Lupa.tablet(driver).click();

//		driver.findElement(By.xpath("")).click();
//		driver.findElement(By.xpath("")).click();
		
		
		
	}

}
