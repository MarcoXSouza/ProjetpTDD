package br.com.rsinet.hub_TDD.projeto.pesquisa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;

public class PesquisaPelaLupa {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constantes.Url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("menuSearch")).click();
		driver.findElement(By.id("autoComplete")).sendKeys("HP ElitePad 1000 G2 Tablet");
		Thread.sleep(2000);
//		driver.findElement(By.xpath("")).click();
		
		
		
	}

}
