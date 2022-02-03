package testes;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BlogAgiTest {

	static WebDriver driver;

	@BeforeAll
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

	@Test
	public void acessarBlogAgi() {

		// ACessa URL do blog AGI
		driver.get("https://blogdoagi.com.br/");

	}

	@AfterAll
	public void finaliza() {

		// Finaliza o driver
		driver.close();

		System.out.println("Fim");

	}

}
