package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tools.Config;

import static java.lang.System.getProperty;

public class LoginPage extends AbsPage{
  @FindBy(xpath = "//input[@type='text']")
  private WebElement loginField;

  @FindBy(xpath = "//input[@type='password']")
  private WebElement passwordField;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement entryButton;

  public LoginPage(WebDriver driver){
    super(driver);
    /*Инициализация полей, помеченных @FindBy с помощью PageFactory
    * Включает их поиск*/
    PageFactory.initElements(driver, this);
  }
  public void enterUsername(){
    loginField.sendKeys(Config.get("user.login"));
  }
  public void enterPass(){
    passwordField.sendKeys(Config.get("user.password"));
  }
  public void login(){
    entryButton.click();
  }
}
