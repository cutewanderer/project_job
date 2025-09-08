package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends AbsPage {

  public MainPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Отображение лого главной страницы
   */
  private final By mainWord = By.xpath("//h2[text()='Мои списки желаний']");
  /**
   * Кнопка выбора списка подарков по ID
   */
  private final By selectList = By.xpath("//a[@href='/wishlists/59529636-f0f6-4615-931b-f408da8861a5']");
  /**
   * Кнопка удаления списка подарков по ID
   */
  private final By deleteList = By.xpath("//a[@href='/wishlists/59529636-f0f6-4615-931b-f408da8861a5']/../button");
  /**
   * Кнопка создания нового списка
   */

  /**
  * Поиск элемента для проверки
  */
  public void seeMainWord(){
    driver.findElement(mainWord).isDisplayed();
  }

  /**
   * Переход в список подарков с определенным id списка
   */
  public void clickSelectList(){
    driver.findElement(selectList).click();
  }
  /**
   * Удаление списка подарков
   */
  public void clickDeleteList(){
    driver.findElement(deleteList).click();
  }
}

