package testes;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	
	static WebDriver driver;
	static String textObtido;
	
	 @Rule
	 public TestName name= new TestName();

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
	
	@After
	public void depoisCadaTest() throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		System.out.println(timeStamp);
		
		//Converte webdriver para tirar print
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Cria arquivo de imagem
		 File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		 //Copia print para pasta abaixo
		 FileUtils.copyFile(srcFile, new File("screenshots/"+name.getMethodName()+"_"+timeStamp+".png"));
		 
	}

	@AfterClass
	public static void finaliza() {

		// Finaliza o driver
		driver.close();
		System.out.println("Fim");

	}

}
