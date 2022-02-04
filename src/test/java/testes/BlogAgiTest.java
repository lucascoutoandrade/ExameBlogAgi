package testes;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BlogAgiTest {

	static WebDriver driver;
	static String textObtido;

	@BeforeClass
	public static void setupTest() {

		// Seta path do driver executavel
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");

		// Adiciona argumentos para instanca do driver
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");

		// Atribui argumentos opcionais
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Before
	public void antesCadaTest() throws InterruptedException {

		// ACessa URL do blog AGI
		driver.get("https://blogdoagi.com.br/");
		Thread.sleep(2000);
		// Clicar na lupa
		driver.findElement(By.xpath("//*[@id = 'search-open']")).click();
		Thread.sleep(2000);

	}

	@Test
	public void deveDigitarDadosValidos() throws InterruptedException {

		// Preencher campo de input pesquisa
		driver.findElement(By.cssSelector("div.desktop-search > form > label > input")).sendKeys("pix");
		Thread.sleep(2000);

		// Acionar botão pesquisar
		driver.findElement(By.cssSelector("div.desktop-search > form > input")).click();
		Thread.sleep(2000);

		// validar retorno
		textObtido = driver.findElement(By.cssSelector("#primary > header > h1")).getText();

		// Valida se pesquisa retorna dados de acordo com o parametro informado
		Assert.assertEquals("Resultados da busca por: pix", textObtido);
	}

	@Test
	public void deveDigitarDadosInvalidosValidarRetorno() throws InterruptedException {

		// Preencher campo de input pesquisa
		driver.findElement(By.cssSelector("div.desktop-search > form > label > input")).sendKeys("dasdadada");
		Thread.sleep(2000);

		// Acionar botão pesquisar
		driver.findElement(By.cssSelector("div.desktop-search > form > input")).click();
		Thread.sleep(2000);

		// TO DO //validar retorno
		textObtido = driver.findElement(By.cssSelector("#primary > section > header > h1")).getText();

		// Valida se pesquisa retorna dados de acordo com o parametro informado
		Assert.assertEquals("Nenhum resultado", textObtido);
	}

	@AfterClass
	public static void finaliza() {

		// Finaliza o driver
		driver.close();
		System.out.println("Fim");

	}

}
