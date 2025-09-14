import model.Wishlist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WishlistPage;

import static org.junit.jupiter.api.Assertions.*;

public class WishlistCreate extends BaseTest {
  private static final Logger log = LogManager.getLogger();
  WishlistPage wishlistPage = new WishlistPage(driver);
  Wishlist wl = new Wishlist.Builder().random().build();

  @Test
  @DisplayName("Создание нового списка подарков c описанием")
  public void createWishlist() throws InterruptedException {
    log.info("Начало теста создания вишлиста");
    wishlistPage.clickCreateList();
    wishlistPage.viewLogoCreate();
    wishlistPage.inputNameList(wl.getTitle());
    wishlistPage.inputDescriptionList(wl.getDescription());
    wishlistPage.submitList();
    log.info("Жмем на создать и ждём ответ от сервака");

    Thread.sleep(500L);
    Assertions.assertTrue(responseChecker.checkCreateWishlist(), "Должно сохраниться и придти 200 ОК");
    log.info("Создался новый список");
  }
  @Test
  @DisplayName("Создание списка без ввода названия")
  public void createWishlistWihtoutName(){
    log.info("Начинаем создание без ввода названия списка");
    wishlistPage.clickCreateList();
    wishlistPage.viewLogoCreate();
    wishlistPage.inputDescriptionList(wl.getDescription());
    wishlistPage.submitList();
    assertTrue(wishlistPage.fieldNameSelected(),"Должно выбраться поле и не сохраниться список");
    log.info("Список не создался, потому что поле Название обязательное");
  }
  @Test
  @DisplayName("Тест на ввод для создания списка и отмену создания")
  public void canceledCreateWishlist() throws InterruptedException {
    log.info("Вводим данные для создания списка и нажимаем кнопку отменить");
    wishlistPage.clickCreateList();
    wishlistPage.viewLogoCreate();
    wishlistPage.inputNameList(wl.getTitle());
    wishlistPage.inputDescriptionList(wl.getDescription());
    wishlistPage.clickCancelCreate();
    assertTrue(wishlistPage.modalCreateLogoDisplayed(),"Не должно появиться окно модалки");
  }
}
