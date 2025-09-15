import driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import tools.Config;
import utils.ResponseChecker;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
  protected WebDriver driver = DriverManager.getDriver();
  protected ResponseChecker responseChecker;

  @BeforeEach
  void setUp() {
    driver.get(Config.get("base.url"));
    new LoginPage(driver).loginAsDefaultUser();
    // Инициализируем чекер
    responseChecker = new ResponseChecker();

    driver.get(Config.get("base.url"));
    driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));

    new LoginPage(driver).loginAsDefaultUser();
  }

  @AfterEach
  public void endDriver(){
    if(driver!= null){
      driver.close();
    }
  }
}