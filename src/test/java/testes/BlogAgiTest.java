package testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class BlogAgiTest extends BaseTest {

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
	public void deveDigitarDadosInvalidos() throws InterruptedException {

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
	
	

}
