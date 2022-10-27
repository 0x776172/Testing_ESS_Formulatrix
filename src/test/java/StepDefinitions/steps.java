package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjectModel.LoginPageModel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {
  WebDriver driver;
  LoginPageModel loginStep;

  @Before
  public void startBrowser() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    ChromeOptions handErr = new ChromeOptions();
    handErr.setAcceptInsecureCerts(true);
    driver = new ChromeDriver(handErr);
    loginStep = new LoginPageModel(driver);
    driver.get("https://10.250.11.13:5002/review/Login");
  }

  @When("enter {string} and {string}")
  public void enterText(String username, String password) {
    loginStep.enterUsernamePassword(username, password);
  }

  @And("click login button")
  public void clickLoginBtn() {
    loginStep.clickBtnLogin();
  }

  @Then("check valid")
  public void checkValid() throws Throwable {
    String txt;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-body")));
      txt = driver.findElement(By.className("toast-body")).getText();
      System.out.println("hasil: " + txt);
    } catch (Exception e) {
      txt = driver.findElement(By.className("title")).getText();
      assertEquals("Dashboard", txt);
    }
  }

  // @And("click menu 1")
  // public void clickMenu1() {

  // }

  @After
  public void closeBrowser() {
    driver.quit();
  }
}
