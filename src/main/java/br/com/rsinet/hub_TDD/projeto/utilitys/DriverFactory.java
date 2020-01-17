package br.com.rsinet.hub_TDD.projeto.utilitys;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverFactory {

	static WebDriver driver;
	private DriverFactory() {
		
	}
	
	public static WebDriver iniciaNavegador() {
		
		if (driver == null){
			
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/#/");
		}
		return driver;
	}

	
	public static void fechaDriver() {
		if(null != driver) {
			driver.quit();
			driver = null;
		}
	}
	

}
