package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjectModel.LoginPageModel;
import PageObjectModel.ReviewPageModel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {
  WebDriver driver;
  LoginPageModel loginStep;
  ReviewPageModel reviewPageStep;

  @Before
  public void startBrowser() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    ChromeOptions handErr = new ChromeOptions();
    handErr.setAcceptInsecureCerts(true);
    driver = new ChromeDriver(handErr);
    loginStep = new LoginPageModel(driver);
    reviewPageStep = new ReviewPageModel(driver);
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

  List<WebElement> liElm;

  @Then("check valid")
  public void checkValid() {
    String txt = "error";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.className("toast-body")),
        ExpectedConditions.visibilityOfElementLocated(By.className(("title")))));
    try {
      txt = driver.findElement(By.className("toast-body")).getText();
      assertTrue(txt.contains("not found"));
    } catch (Exception e) {
      // TODO: handle exception
      txt = driver.findElement(By.className("title")).getText();
      assertTrue(txt.contains("board"));
    }
  }

  @Then("click burger icon")
  public void clickBurgerIcon() {
    reviewPageStep.clickMenuIcon();
    liElm = driver.findElements(By.tagName("li"));
    System.out.println(liElm.size());
  }

  @And("click every li element")
  public void clickMenu1() {
    for (WebElement li : liElm) {
      li.click();
      reviewPageStep.clickMenuIcon();
      System.out.println("success");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
      wait.until(ExpectedConditions.elementToBeClickable(By.tagName("li")));
    }
  }

  @Then("click logout")
  public void clickLogoutBtn() {

  }

  // @After
  // public void closeBrowser() {
  // driver.quit();
  // }
}
