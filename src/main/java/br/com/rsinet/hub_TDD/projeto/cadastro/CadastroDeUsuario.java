package br.com.rsinet.hub_TDD.projeto.cadastro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroDeUsuario {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
//		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("menuUser")).click();
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
		element.click();
		driver.findElement(By.name("usernameRegisterPage")).sendKeys("Marcoss");
		driver.findElement(By.name("emailRegisterPage")).sendKeys("jose@rsi.com");
		driver.findElement(By.name("passwordRegisterPage")).sendKeys("123aA");
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("123aA");
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Marcos");
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Xavier");
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("12345678900");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select oSelect = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		oSelect.selectByVisibleText("Fiji");
		driver.findElement(By.name("cityRegisterPage")).sendKeys("Lautoka");
		driver.findElement(By.name("addressRegisterPage")).sendKeys("Vitogo Parade, 11");
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("FJ");
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("00011-100");
		driver.findElement(By.name("i_agree")).click();
		driver.findElement(By.id("register_btnundefined")).sendKeys(Keys.ENTER);

//		
//		driver.close();
	}

}
