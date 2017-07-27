package br.com.caelum.argentum.aceitacao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeraGraficoTest {
	
	private static final String URL = "http://localhost:8080/Argentum-web/index.xhtml";
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/aumoraes/Documentos/jar/selenium/chromedriver");

		driver = new ChromeDriver();
	}
	@After
	public void tearDown() {
		driver.close();
	}
	@Test
	public void testeAoGerarGraficoSemTituloUmaMensagemEhApresentada() {
		driver.navigate().to(URL);
		WebElement titulo = driver.findElement(By.id("dadosGrafico:titulo"));
		titulo.sendKeys();
		titulo.submit();
		boolean existeMensagem = driver.getPageSource().contains("Erro de validação");
		Assert.assertTrue(existeMensagem);
	}			
	
}
