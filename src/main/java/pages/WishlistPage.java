package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends AbsPage{
  public WishlistPage(WebDriver driver) {
    super(driver);
  }
  private final By createNewList = By.xpath("//button[text()='Создать новый список']");
  private final By logoCreateNewList = By.xpath("//div[@class='modal-title h4']");
  private final By inputNameList = By.xpath("//input[@type='text']");
  private final By inputDescription = By.xpath("//textarea[@class='form-control']");
  private final By createList = By.xpath("//button[@type='submit']");
  private final By cancelCreate = By.xpath("//button[@class='me-2 btn btn-secondary']");
  private final By closeCreateList = By.xpath("//button[@class='btn-close']");

  /**
   *Создание нового списка подарков
   */
  public void clickCreateList(){
    driver.findElement(createNewList).click();
  }
  /**
   * Поиск логотипа для проверки открытия создания нового списка
   */
  public void viewLogoCreate(){
    driver.findElement(logoCreateNewList).isDisplayed();
  }
  /**
   * Ввод названия списка
   */
  public void inputNameList(){
    driver.findElement(inputNameList).sendKeys();
  }
  /**
   * Ввод описания списка
   */
  public void inputDescriptionList(){
    driver.findElement(inputDescription).sendKeys();
  }
  /**
   * нажимаем на кнопку Создать список
   */
  public void submitList(){
    driver.findElement(createList).click();
  }
  /**
   * Нажимаем на отмену создания
   */
  public void clickCancelCreate(){
    driver.findElement(cancelCreate).click();
  }
  /**
   * Нажимаем на крестик в модалке создания Вишлиста
   */
  public void clickClose(){
    driver.findElement(closeCreateList).click();
  }
}
