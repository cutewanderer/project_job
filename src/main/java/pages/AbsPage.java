package pages;

import org.openqa.selenium.WebDriver;
import tools.Config;

public class AbsPage {
  protected static WebDriver driver;
  public String browser = Config.get("browser");
  public String url = Config.get("base.url");


  public AbsPage(WebDriver driver) {
    AbsPage.driver = driver;
  }
}
