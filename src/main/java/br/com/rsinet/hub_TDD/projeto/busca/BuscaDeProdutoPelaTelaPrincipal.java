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
		driver.findElement(By.id("checkOutPopUp")).click();
		driver.findElement(By.name("usernameInOrderPayment")).sendKeys(Constantes.nome);
		driver.findElement(By.name("passwordInOrderPayment")).sendKeys(Constantes.senha);
		driver.findElement(By.id("login_btnundefined")).click();
		driver.findElement(By.id("next_btn")).click();
		driver.findElement(By.name("safepay_username")).sendKeys(Constantes.nome);
		driver.findElement(By.name("safepay_password")).sendKeys(Constantes.senha);
		driver.findElement(By.name("save_safepay")).click();
		driver.findElement(By.id("pay_now_btn_SAFEPAY")).click();
	

		
		
		
	}

}
