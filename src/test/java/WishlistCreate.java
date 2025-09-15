import model.Wishlist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.WishlistPage;

import static org.junit.jupiter.api.Assertions.*;

public class WishlistCreate extends BaseTest {
  private static final Logger log = LogManager.getLogger();
  WishlistPage wishlistPage = new WishlistPage(driver);
  MainPage mainPage = new MainPage(driver);
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
    Thread.sleep(500L);
    assertTrue(wishlistPage.modalCreateLogoDisplayed(),"Не должно появиться окно модалки");
  }
  @Test
  @DisplayName("Закрытие окна с заполненными полями создания вишлиста")
  public void closeModalCreateWishlist() throws InterruptedException {
    log.info("Начало теста создание вишлиста и закрытие модалки создания");
    wishlistPage.clickCreateList();
    Thread.sleep(500L);
    wishlistPage.viewLogoCreate();
    wishlistPage.inputNameList(wl.getTitle());
    wishlistPage.inputDescriptionList(wl.getDescription());
    wishlistPage.clickClose();
    Thread.sleep(500L);
    log.info("Закрываем модальное окно, проверяем что оно закрыто");

    assertTrue(wishlistPage.modalCreateLogoDisplayed(),"Не должно отображаться окно модалки");
    log.info("Открываем модалку повторно чтобы проверить что введенные данные не удалились");
    wishlistPage.clickCreateList();
    Thread.sleep(500L);
    assertTrue(wishlistPage.fieldNameWishlistNotEmpty(), "Ошибка, поле пустое.");
  }

  @Test
  @DisplayName("Тест удаления вишлиста")
  public void deleteWishlist() throws InterruptedException {
    log.info("Тест удаления вишлиста");
    mainPage.clickDeleteList();
    Thread.sleep(500L);
    log.info("Нажал на кнопку удаления");
    assertTrue(responseChecker.checkDeletedWishlist(), "Список должен был удален");
  }
}
