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

  public ReviewPageModel(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickMenuIcon() {
    menuIcon.click();
  }
}
