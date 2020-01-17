package br.com.rsinet.hub_TDD.projeto.cadastro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.projeto.PageObject.CadastroPage;
import br.com.rsinet.hub_TDD.projeto.utilitys.Constantes;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelData;
import br.com.rsinet.hub_TDD.projeto.utilitys.ExcelUtils;
import br.com.rsinet.hub_TDD.projeto.utilitys.Snapshot;

public class CadastroDeUsuario {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		ExcelUtils.setExcelFile(Constantes.path + Constantes.file, "Cadastro");
//		DriverFactory.iniciaNavegador();
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//		Cria nova conta
		CadastroPage.linkCadastro(driver).click();
		CadastroPage.criarConta(driver);
		
//		Envia os dados necessarios para o cadastro
		CadastroPage.Nome(driver).sendKeys(ExcelData.nome);
		CadastroPage.email(driver).sendKeys(ExcelData.email);
		CadastroPage.senha(driver).sendKeys(ExcelData.senha);
		CadastroPage.confirmarSenha(driver).sendKeys(ExcelData.senha);
		CadastroPage.primeiroNome(driver).sendKeys(ExcelData.nome);
		CadastroPage.ultimoNome(driver).sendKeys(ExcelData.ultimoNome);
		CadastroPage.telefone(driver).sendKeys(ExcelData.telefone);
		CadastroPage.pais(driver).sendKeys(ExcelData.pais);
		CadastroPage.cidade(driver).sendKeys(ExcelData.cidade);
		CadastroPage.endereco(driver).sendKeys(ExcelData.endereco);
		CadastroPage.estado(driver).sendKeys(ExcelData.estado);
		CadastroPage.CEP(driver).sendKeys(ExcelData.cep);
		
//		Aceita os termos e cria nova conta
		CadastroPage.aceitarTermos(driver).click();
		CadastroPage.btnRegistrar(driver).click();
	
		
		
//		Tira print do resultado
		Snapshot.takeSnapShot("Cadastro Sucesso ", driver);
//		
//		Fecha o navegador
		driver.close();
	}

}
