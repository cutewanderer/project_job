package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ResponseChecker;

public class WishlistPage extends AbsPage{
  private final ResponseChecker responseChecker = new ResponseChecker();

  public WishlistPage(WebDriver driver) {
    super(driver);
  }
  /**
   * Кнопка создания нового списка
   */
  private final By createNewList = By.xpath("//button[text()='Создать новый список']");
  /**
   * Логотип создания нового вишлиста
   */
  private final By logoCreateNewList = By.xpath("//div[@class='modal-title h4']");
  /**
   * Поле ввода названия вишлиста
   */
  private final By inputNameList = By.xpath("//input[@type='text']");
  /**
   * Поле ввода описания вишлиста
   */
  private final By inputDescription = By.xpath("//textarea[@class='form-control']");
  /**
   * Кнопка подтверждения создания списка
   */
  private final By createList = By.xpath("//button[@type='submit']");
  /**
   * Кнопка отмены создания вишлиста
   */
  private final By cancelCreate = By.xpath("//button[@class='me-2 btn btn-secondary']");
  /**
   * Кнопка закрытия модалки создания вишлиста
   */
  private final By closeCreateList = By.xpath("//button[@class='btn-close']");
  /**
   * Кнопка создания нового подарка в вишлисте
   */
  private final By addGift = By.xpath("//button[@class='mb-4 btn btn-primary']");
  /**
   * Кнопка резервирования подарка
   */
  private final By reservedButton = By.xpath("//div[contains(@class, 'card') and .//div[contains(@class,'card-title') " +
          "and text()='sdevgvrrth3436546']]//button[text()='Зарезервировать']");
  /**
   * Кнопка снятия резерва с подарка
   */
  public final By unReservedButton = By.xpath("//div[contains(@class, 'card') and .//div[contains(@class,'card-title') and text()='sdevgvrrth3436546']]//button[text()='Снять резерв']");
  /**
   * Кнопка перехода на сайт магазина подарка
   */
  private final By storeButtonGift = By.xpath("//a[@class='btn btn-outline-info btn-sm']");

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
  public void inputNameList(String title){
    driver.findElement(inputNameList).sendKeys(title);
  }
  /**
   * Ввод описания списка
   */
  public void inputDescriptionList(String description){
    driver.findElement(inputDescription).sendKeys(description);
  }
  /**
   * Нажимаем на кнопку создать список
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
  /**
   * Открытие модалки создания подарка
   */
  public void clickAddGifts(){
    driver.findElement(addGift).click();
  }
  /**
   * Метод нажатия на кнопку резервирования подарка
   */
  public void clickReservedGift(){
    driver.findElement(reservedButton).click();
  }
  /**
   * Метод нажатия на ссылку магазина
   */
  public void clickStoreUrlGift(){
    driver.findElement(storeButtonGift).click();
  }
  /**
   * Метод разрезервирования подарка
   */
  public void clickUnreservedGift() {
    driver.findElement(unReservedButton).click();
  }
  /**
   * Метод проверки перехода на поле ввода названия листа
   */
  public boolean fieldNameSelected(){
    WebElement selectedNameField = driver.switchTo().activeElement();
    return selectedNameField.equals(driver.findElement(inputNameList));
  }
  public boolean modalCreateLogoDisplayed(){
    return driver.findElements(logoCreateNewList).isEmpty();
  }
}
