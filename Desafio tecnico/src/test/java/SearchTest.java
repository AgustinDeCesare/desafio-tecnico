import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class SearchTest {

  private WebDriver driver;

  By logoLocator = By.xpath("//img[@src=\"http://automationpractice.com/img/logo.jpg\"]");
  By dressesLocator = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
  By categoryLocator = By.className("cat-name");
  By yellowLocator = By.id("layered_id_attribute_group_16");
  By resultsListLocator = By.xpath("//*[@id=\"center_column\"]/ul/li");

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://automationpractice.com/index.php");
  }

  @Test
  public void testBusqueda() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    wait.until(ExpectedConditions.presenceOfElementLocated(logoLocator));

    wait.until(ExpectedConditions.elementToBeClickable(dressesLocator));
    driver.findElement(dressesLocator).click();

    wait.until(ExpectedConditions.presenceOfElementLocated(categoryLocator));

    assertEquals("DRESSES ", driver.findElement(categoryLocator).getText());

    driver.findElement(yellowLocator).click();

    wait.until(ExpectedConditions.titleIs("Dresses > Color Yellow - My Store"));

    assertEquals("DRESSES > COLOR YELLOW", driver.findElement(categoryLocator).getText());

    System.out.println("Cantidad de vestidos amarillos: " + driver.findElements(resultsListLocator).size());

    assertEquals(3,driver.findElements(resultsListLocator).size());
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
