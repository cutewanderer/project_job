package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory implements DriverFactory {
  private final ChromeOptions options;

  public ChromeDriverFactory(ChromeOptions options) {
    this.options = options;
  }

  @Override
  public WebDriver createDriver() {
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver(options);
  }
}