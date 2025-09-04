package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverFactory implements DriverFactory {
  private final FirefoxOptions options;

  public FirefoxDriverFactory(FirefoxOptions options) {
    this.options = options;
  }

  @Override
  public WebDriver createDriver() {
    WebDriverManager.firefoxdriver().setup();
    return new FirefoxDriver(options);
  }
}