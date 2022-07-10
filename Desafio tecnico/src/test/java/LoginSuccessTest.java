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

public class LoginSuccessTest {

  private WebDriver driver;

  By logoLocator = By.xpath("//img[@src=\"http://automationpractice.com/img/logo.jpg\"]");
  By signInLinkLocator = By.className("login");

  By signInButtonLocator = By.id("SubmitLogin");

  By emailAddressLocator = By.id("email");

  By passwordLocator = By.id("passwd");

  By pageHeadingLocator = By.className("page-heading");


  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://automationpractice.com/index.php");
  }

  @Test
  public void testLoginExitoso() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    wait.until(ExpectedConditions.presenceOfElementLocated(logoLocator));

    wait.until(ExpectedConditions.elementToBeClickable(signInLinkLocator));
    driver.findElement(signInLinkLocator).click();

    wait.until(ExpectedConditions.elementToBeClickable(signInButtonLocator));

    assertEquals("AUTHENTICATION",driver.findElement(pageHeadingLocator).getText());

    driver.findElement(emailAddressLocator).sendKeys("ashkdjnfaxcvzxlksnasddvc@gmail.com");
    driver.findElement(passwordLocator).sendKeys("password");
    driver.findElement(signInButtonLocator).click();

    wait.until(ExpectedConditions.titleIs("My account - My Store"));

    assertEquals("MY ACCOUNT",driver.findElement(pageHeadingLocator).getText());
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
