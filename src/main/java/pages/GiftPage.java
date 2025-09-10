/**
 * Страница с подарками и их созданием
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tools.Config;

public class GiftPage extends AbsPage{
  public GiftPage(WebDriver driver) {
    super(driver);
  }
  /**
   * Лейбл модалки создания подарка
   */
  private final By labelCreateGift = By.xpath("//div[@class='modal-title h4']");
  /**
   * Кнопка закрытия модалки создания подарка
   */
  private final By closeCreateGift = By.xpath("//button[@class='btn-close']");
  /**
   * Поле ввода названия подарка
   */
  private final By giftNameField = By.xpath("//input[@type='text']");
  /**
   * Поле ввода описания подарка
   */
  private final By giftDescriptionField = By.xpath("//textarea[@class='form-control']");
  /**
   * Поле ввода ссылки на магазин подарка
   */
  private final By urlShopGift = By.xpath("//input[@placeholder='https://example.com/product']");
  /**
   * Поле ввода цены подарка
   */
  private final By priceGiftField = By.xpath("//input[@type='number']");
  /**
   * Поле ввода ссылки на изображение
   */
  private final By imageGiftField = By.xpath("//input[@placeholder='https://example.com/image.jpg']");
  /**
   * Кнопка добавления подарка
   */
  private final By createGiftButton = By.xpath("//button[@type='submit']");
  /**
   * Сообщение о неудачном добавлении подарка
   */
  private final By errorGiftMessage = By.xpath("//*[text()='Не удалось добавить подарок']");

  /**
   * Метод, который увидит лейбл модалки
   */
  public void seeOpenGiftModal(){
    driver.findElement(labelCreateGift).isDisplayed();
  }
  /**
   * Метод закрытия модалки на кнопку Крестик
   */
  public void clickCloseModalGift(){
    driver.findElement(closeCreateGift).click();
  }
  /**
   * Метод ввода названия подарка
   */
  public void inputGiftName(){
    driver.findElement(giftNameField).sendKeys(Config.get("gift.name"));
  }
  /**\
   * Метод ввода описания подарка
   */
  public void inputDescriptionGift(){
    driver.findElement(giftDescriptionField).sendKeys(Config.get("gift.description"));
  }
  /**
   * Метод ввода ссылки на магазин подарка
   */
  public void inputUrlStoreGift(){
    driver.findElement(urlShopGift).sendKeys(Config.get("url.store"));
  }
  /**
   * Метод ввода цены подарка
   */
  public void inputPriceGift(){
    driver.findElement(priceGiftField).sendKeys(Config.get("price"));
  }
  /**
   * Метод ввода урла картинки подарка
   */
  public void inputImageUrlGift(){
    driver.findElement(imageGiftField).sendKeys(Config.get("url.image"));
  }
  /**
   * Метод подтверждения создания подарка
   */
  public void acceptCreateGift(){
    driver.findElement(createGiftButton).click();
  }
  /**
   * Метод проверки создания подарка
   */
  public boolean isErrorGiftMessageVisible() {
    return !driver.findElements(errorGiftMessage).isEmpty();
  }
}
