package br.com.rsinet.hub_TDD.projeto.utilitys;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Snapshot {

	public static void takeSnapShot(String nomeDoArquivoImagem, WebDriver driver) throws IOException, InterruptedException {

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("Report\\Screenshots\\"+ nomeDoArquivoImagem + timestamp() + ".png");
		FileUtils.copyFile(scr, dest);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

	}

}