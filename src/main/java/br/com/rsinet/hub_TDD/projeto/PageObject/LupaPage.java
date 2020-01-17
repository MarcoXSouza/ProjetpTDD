package br.com.rsinet.hub_TDD.projeto.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;

public class LupaPage {
	public static WebElement element = null;

	public static WebElement menu(WebDriver driver) {
		element = driver.findElement(By.id("menuSearch"));
		return element;
	}

	public static WebElement digita(WebDriver driver) {
		element = driver.findElement(By.id("autoComplete"));
		return element;
	}
	public static WebElement produto(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Lupa");
		element = driver.findElement(By.linkText(ExcelUtils.getCellData(1, 0)));
		return element;
	}
	public static WebElement adicionaAoCarrinho(WebDriver driver) {
		element = driver.findElement(By.name("save_to_cart"));
		return element;
	}
	public static WebElement fazerCheckout(WebDriver driver) {
		element = driver.findElement(By.id("checkOutPopUp"));
		return element;
	}	


	
}
