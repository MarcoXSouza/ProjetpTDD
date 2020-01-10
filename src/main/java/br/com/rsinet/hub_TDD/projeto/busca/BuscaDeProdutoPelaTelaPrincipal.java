package br.com.rsinet.hub_TDD.projeto.busca;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;

public class BuscaDeProdutoPelaTelaPrincipal {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();

		driver.get(Constantes.Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("laptopsImg")).click();
		driver.findElement(By.linkText("HP Chromebook 14 G1(ES)")).click();
		driver.findElement(By.name("save_to_cart")).click();
	}

}
