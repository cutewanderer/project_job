import model.Gift;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GiftPage;

import pages.MainPage;
import pages.WishlistPage;
import tools.Config;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class GiftCreate extends BaseTest {
  private static final Logger log = LogManager.getLogger();
  MainPage mainPage = new MainPage(driver);
  GiftPage giftPage = new GiftPage(driver);
  WishlistPage wishlistPage = new WishlistPage(driver);
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
  Gift gift = Gift.builder()
          .random()
          .build();

  /**
   * Проверка создания подарка с заполнением всех полей
   */
  @Test
  public void createGiftAllField(){
    mainPage.clickSelectList();
    wishlistPage.clickAddGifts();
    log.info("Открылась модальное окно создание подарка");

    giftPage.inputGiftName(gift.getName());
    log.info("Ввели Название подарка");
    giftPage.inputDescriptionGift(gift.getDescription());
    log.info("Ввели описание подарка");
    giftPage.inputUrlStoreGift(gift.getStoreUrl());
    log.info("Ввели ссылку на магазин для подарка");
    giftPage.inputImageUrlGift(gift.getImageUrl());
    log.info("Ввели ссылку на картинку подарка");
    giftPage.inputPriceGift(gift.getPrice());
    log.info("Указали стоимость подарка");

    giftPage.acceptCreateGift();
    log.info("Нажали на кнопку создания подарка");
    assertFalse(giftPage.isErrorGiftMessageVisible()); ;
    log.info("Ошибок нет!");
  }

  /**
   * Тест проверяет создания подарка с заполнением только обязательных полей
   */
  @Test
  public void createGiftWithRequiredFields(){
    log.info("Начало теста с заполнением только обязательных полей");
    mainPage.clickSelectList();
    wishlistPage.clickAddGifts();
    log.info("Открылась модальное окно создание подарка");
    giftPage.inputGiftName(Config.get("gift.name"));
    log.info("Ввели Название подарка");
    giftPage.inputDescriptionGift(Config.get("gift.description"));
    log.info("Ввели описание подарка");
    giftPage.acceptCreateGift();
    log.info("Нажали на кнопку создания подарка");
    assertTrue(giftPage.isErrorGiftMessageNotVisible());
    log.info("Ошибок нет!");
  }

  /**
   * Создание подарка без указания стоимости
   *
   */
  @Test
  public void createGiftWithoutPrice(){

    log.info("Начало теста без цены");
    mainPage.clickSelectList();
    wishlistPage.clickAddGifts();
    log.info("Вводим данные подарка без цены");
    giftPage.inputGiftName(gift.getName());
    giftPage.inputDescriptionGift(gift.getDescription());
    giftPage.inputUrlStoreGift(gift.getStoreUrl());
    giftPage.inputImageUrlGift(gift.getImageUrl());

    giftPage.acceptCreateGift();
    assertTrue(giftPage.isErrorGiftMessageNotVisible(), "Должен создаться подарок, т.к. необязательное поле Цена"); ;
    log.info("Ошибок нет!");
  }

  /**
   * Проверка создания подарка без заполнения обязательных полей
   */
  @Test
  @DisplayName("Проверка создания подарка без заполнения обязательных полей")
  public void createGiftWithoutRequiredFields(){
    log.info("Начало теста");
    mainPage.clickSelectList();
    wishlistPage.clickAddGifts();

    giftPage.inputPriceGift(gift.getPrice());
    giftPage.inputUrlStoreGift(gift.getStoreUrl());
    giftPage.inputImageUrlGift(gift.getImageUrl());

    giftPage.acceptCreateGift();
    assertTrue(giftPage.fieldNameSelected(),"Поле должно быть выбрано");
    log.info("Завершение теста");
  }
  /**
   * Проверка создания подарка без заполнения Описания
   */
  @Test
  public void createGiftWithoutDescription(){
    log.info("Начало теста без заполнения описания");
    mainPage.clickSelectList();
    wishlistPage.clickAddGifts();
    giftPage.seeOpenGiftModal();
    log.info("Открылось окно модалки");

    giftPage.inputGiftName(gift.getName());
    giftPage.inputPriceGift(gift.getPrice());
    giftPage.inputUrlStoreGift(gift.getStoreUrl());
    giftPage.inputImageUrlGift(gift.getImageUrl());

    giftPage.acceptCreateGift();
    assertTrue(giftPage.fieldDescriptionSelected(),"Поле должно быть выбрано");
    log.info("Завершение теста без заполнения описания");
  }
  /**
   * Тест резервирования подарка
   */
  @Test
  @DisplayName("Резервирование подарка")
  public void reservedGift() throws InterruptedException {
    log.info("Начало теста резерв Подарка");
    mainPage.clickSelectList();
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
            driver.findElement(By.xpath("//div[text()='sdevgvrrth3436546']")));
    wishlistPage.clickReservedGift();
    Thread.sleep(500L);
    assertTrue(responseChecker.checkReserveResponse());
  }
  /**
   * Тест снятия подарка с резерва
   */
  @Test
  @DisplayName("Тест снятия подарка с резерва")
  public void unReservedGift() throws InterruptedException {
    log.info("Начало теста снятие резерва");
    mainPage.clickSelectList();
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
        driver.findElement(By.xpath("//div[text()='sdevgvrrth3436546']")));
    wishlistPage.clickUnreservedGift();
    Thread.sleep(500L);

    assertTrue(responseChecker.checkUnreserveResponse());
  };

}
