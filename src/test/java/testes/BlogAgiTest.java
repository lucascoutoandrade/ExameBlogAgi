package testes;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BlogAgiTest extends BaseTest {
	
	@Test
	public void a_deveDigitarDadosValidos() throws InterruptedException {

		// Preenche campo de input pesquisa
		driver.findElement(By.cssSelector("div.desktop-search > form > label > input")).sendKeys("pix");
		aguardaByVisibilidadeElemento(By.cssSelector("div.desktop-search > form > input"));

		// Aciona botão pesquisar
		driver.findElement(By.cssSelector("div.desktop-search > form > input")).click();
		
		// Obtem retorno
		aguardaByVisibilidadeElemento(By.cssSelector("#primary > header > h1"));
		textObtido = driver.findElement(By.cssSelector("#primary > header > h1")).getText();
		
		// Valida se pesquisa retorna dados de acordo com o parametro informado
		Assert.assertEquals("Resultados da busca por: pix", textObtido);
	}

	@Test
	public void b_deveDigitarDadosInvalidos() throws InterruptedException {

		// Preenche campo de input pesquisa
		driver.findElement(By.cssSelector("div.desktop-search > form > label > input")).sendKeys("dasdadada");
		aguardaByVisibilidadeElemento(By.cssSelector("div.desktop-search > form > input"));

		// Aciona botão pesquisar
		driver.findElement(By.cssSelector("div.desktop-search > form > input")).click();

		// Obtem retorno
		aguardaByVisibilidadeElemento(By.cssSelector("#primary > section > header > h1"));
		textObtido = driver.findElement(By.cssSelector("#primary > section > header > h1")).getText();

		// Valida se pesquisa retorna dados de acordo com o parametro informado
		Assert.assertEquals("Nenhum resultado", textObtido);
	}
	
	

}
