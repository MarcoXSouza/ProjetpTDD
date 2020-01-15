package br.com.rsinet.hub_TDD.projeto.PageObject;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Snapshot {

	public static WebDriver driver;

	public static void takeSnapShot(String nomeDoArquivoImagem) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C:\\Users\\marcos.souza\\Pictures\\Testes\\HomePage";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem));

	}

	
	
}
