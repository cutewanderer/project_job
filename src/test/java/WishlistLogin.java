import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainPage;
import tools.Config;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishlistLogin {
  private static final Logger log = LogManager.getLogger();
  static WebDriver driver = DriverManager.getDriver();

  @BeforeEach

  void setup(){
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
  public void login(){
    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    log.info("Начало теста");
    loginPage.enterUsername();
    log.info("Ввели логин");
    loginPage.enterPass();
    log.info("Ввели пароль");
    loginPage.login();
    log.info("Нажали кнопку входа");
    mainPage.seeMainWord();
    assertTrue(true);
    log.info("Отображается надпись главной страницы");
  }
}
