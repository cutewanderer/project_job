import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.GiftPage;
import pages.LoginPage;
import pages.MainPage;
import pages.WishlistPage;
import tools.Config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class GiftCreate {
  private static final Logger log = LogManager.getLogger();
  static WebDriver driver = DriverManager.getDriver();
  MainPage mainPage = new MainPage(driver);
  LoginPage loginPage = new LoginPage(driver);
  GiftPage giftPage = new GiftPage(driver);
  WishlistPage wishlistPage = new WishlistPage(driver);

  @BeforeEach
  public void setup(){
    driver.get(Config.get("base.url"));
    driver.manage().timeouts().implicitlyWait(Long.parseLong(Config.get("timeout")), TimeUnit.SECONDS);
  }
  @AfterEach
  public void endDriver(){
    if(driver!= null){
      driver.close();
    }
  }
  @Test
  public void createGiftAllField(){
    log.info("Начало теста");
    loginPage.enterUsername();
    log.info("Ввели логин");
    loginPage.enterPass();
    log.info("Ввели пароль");
    loginPage.login();
    log.info("Нажали кнопку входа");
    mainPage.clickSelectList();
    wishlistPage.clickAddGifts();
    log.info("Открылась модальное окно создание подарка");
    giftPage.inputGiftName();
    log.info("Ввели Название подарка");
    giftPage.inputDescriptionGift();
    log.info("Ввели описание подарка");
    giftPage.inputUrlStoreGift();
    log.info("Ввели ссылку на магазин для подарка");
    giftPage.inputImageUrlGift();
    log.info("Ввели ссылку на картинку подарка");
    giftPage.inputPriceGift();
    log.info("Указали стоимость подарка");
    giftPage.acceptCreateGift();
    log.info("Нажали на кнопку создания подарка");
    assertFalse(giftPage.isErrorGiftMessageVisible()); ;
    log.info("Ошибок нет!");
  }
}
