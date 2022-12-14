package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPageModel {
  WebDriver driver;

  @FindBy(className = "menuIcon")
  @CacheLookup
  WebElement menuIcon;
  @FindBy(className = "btn")
  @CacheLookup
  WebElement btn;

  public ReviewPageModel(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickMenuIcon() {
    menuIcon.click();
  }

  // public void clickBtn(String text) {
  // switch (text) {
  // case "Logout":
  // }
  // btn.click();
  // }
}
