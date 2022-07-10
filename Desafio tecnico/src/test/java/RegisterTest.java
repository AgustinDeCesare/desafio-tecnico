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

public class RegisterTest {

  private WebDriver driver;

  By logoLocator = By.xpath("//img[@src=\"http://automationpractice.com/img/logo.jpg\"]");
  By signInLinkLocator = By.className("login");
  By createAccountButtonLocator = By.id("SubmitCreate");

  By emailAddressLocator = By.id("email_create");

  By pageHeadingLocator = By.className("page-heading");

  By submitAccountLocator = By.id("submitAccount");

  By genderLocator = By.id("id_gender1");
  By firstNameLocator = By.id("customer_firstname");
  By lastNameLocator = By.id("customer_lastname");
  By passwordLocator = By.id("passwd");
  By daysLocator = By.id("days");
  By monthsLocator = By.id("months");
  By yearsLocator = By.id("years");

  By addressLocator = By.id("address1");
  By cityLocator = By.id("city");
  By stateLocator = By.id("id_state");
  By zipLocator = By.id("postcode");
  By mobilePhoneLocator = By.id("phone_mobile");
  By aliasLocator = By.id("alias");


  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://automationpractice.com/index.php");
  }

  @Test
  public void testRegistro() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    wait.until(ExpectedConditions.presenceOfElementLocated(logoLocator));

    wait.until(ExpectedConditions.elementToBeClickable(signInLinkLocator));
    driver.findElement(signInLinkLocator).click();

    wait.until(ExpectedConditions.presenceOfElementLocated(logoLocator));

    assertEquals("AUTHENTICATION",driver.findElement(pageHeadingLocator).getText());

    driver.findElement(emailAddressLocator).sendKeys("ashkdjnfaxcvzxlksnasddvc@gmail.com");
    driver.findElement(createAccountButtonLocator).click();

    wait.until(ExpectedConditions.elementToBeClickable(submitAccountLocator));

    assertEquals("CREATE AN ACCOUNT",driver.findElement(pageHeadingLocator).getText());

    driver.findElement(genderLocator).click();
    driver.findElement(firstNameLocator).sendKeys("Agustin");
    driver.findElement(lastNameLocator).sendKeys("De Cesare");
    driver.findElement(passwordLocator).sendKeys("password");
    Select dropDays = new Select(driver.findElement(daysLocator));
    dropDays.selectByValue("1");
    Select dropMonths = new Select(driver.findElement(monthsLocator));
    dropMonths.selectByValue("12");
    Select dropYears = new Select(driver.findElement(yearsLocator));
    dropYears.selectByValue("2000");
    driver.findElement(addressLocator).sendKeys("Calle 123");
    driver.findElement(cityLocator).sendKeys("Miami");
    Select dropState = new Select(driver.findElement(stateLocator));
    dropState.selectByValue("9");
    driver.findElement(zipLocator).sendKeys("30111");
    driver.findElement(mobilePhoneLocator).sendKeys("12345678");
    driver.findElement(aliasLocator).clear();
    driver.findElement(aliasLocator).sendKeys("Casa");
    driver.findElement(submitAccountLocator).click();

    wait.until(ExpectedConditions.titleIs("My account - My Store"));

    assertEquals("MY ACCOUNT",driver.findElement(pageHeadingLocator).getText());
  }

  @After
  public void tearDown() {
    driver.quit();
  }

}
