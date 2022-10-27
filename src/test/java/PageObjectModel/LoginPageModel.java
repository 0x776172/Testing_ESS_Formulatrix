package PageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageModel {
  WebDriver driver;

  @FindBy(id = "username")
  @CacheLookup
  WebElement unameTxtBox;
  @FindBy(id = "password")
  @CacheLookup
  WebElement passTxtBox;
  @FindBy(className = "mt-4")
  @CacheLookup
  WebElement loginBtn;

  public void clearTxtBox(WebElement elm) {
    elm.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    elm.sendKeys(Keys.BACK_SPACE);
  }

  public LoginPageModel(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void enterUsernamePassword(String username, String password) {
    clearTxtBox(unameTxtBox);
    clearTxtBox(passTxtBox);
    unameTxtBox.sendKeys(username);
    passTxtBox.sendKeys(password);
  }

  public void clickBtnLogin() {
    loginBtn.click();
  }
}
