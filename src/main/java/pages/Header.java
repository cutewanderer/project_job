package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbsPage{
  @FindBy(xpath = "//a[text()='Список Желаний']")
  private WebElement wishlistButton;

  @FindBy(xpath = "//button[@type='button']")
  private WebElement navbarButton;

  @FindBy(xpath = "//a[text()='Войти']")
  private WebElement loginButton;

  @FindBy(xpath = "//a[text()='Выйти']")
  private WebElement logoutButton;

  @FindBy(xpath = "//a[text()='Пользователи']")
  private WebElement usersButton;

  @FindBy(xpath = "//a[text()='Мои списки']")
  private WebElement myListsButton;


  public Header(WebDriver driver) {
    super(driver);
  }
}
