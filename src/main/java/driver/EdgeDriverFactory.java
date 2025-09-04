package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverFactory implements DriverFactory {
  private final EdgeOptions options;

  public EdgeDriverFactory(EdgeOptions options) {
    this.options = options;
  }

  @Override
  public WebDriver createDriver() {
    WebDriverManager.edgedriver().setup();
    return new EdgeDriver(options);
  }
}