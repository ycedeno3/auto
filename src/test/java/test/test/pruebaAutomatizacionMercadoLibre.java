package test.test;

import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pruebaAutomatizacionMercadoLibre {

	public static void main(String[] args) throws Exception {
		String path = Paths.get(System.getProperty("user.dir"), "/driver/chromedriver.exe").toString();
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.mercadolibre.cl/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement inputBuscar = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("nav-search-input"))));
		inputBuscar.sendKeys("Cloro gel");
		WebElement btnBuscar = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button.nav-search-btn"))));
		btnBuscar.click();
		WebElement precioMin = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("fromPrice"))));
		precioMin.sendKeys("8.000");
		WebElement precioMax = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("toPrice"))));
		precioMax.sendKeys("10.000");
		WebElement btnBuscaPorPrecio = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='submit']"))));
		btnBuscaPorPrecio.click();
		WebElement selCorazon = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//button[@class='bookmarks favorite ']"))));
		selCorazon.click();
		WebElement hojaFinal = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("center-card__title"))));
		System.out.println("Estas aqui: " + hojaFinal.getText());
		System.out.println("URL del sitio de: " + driver.getCurrentUrl());
		driver.close();
		driver.quit();
	}

}
