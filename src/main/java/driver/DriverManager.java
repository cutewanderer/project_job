package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import tools.Config;

public class DriverManager {

  public static WebDriver getDriver() {
    String browser = Config.get("browser", "chrome").toLowerCase();
    boolean headless = Boolean.parseBoolean(Config.get("headless", "false"));
    boolean fullscreen = Boolean.parseBoolean(Config.get("fullscreen", "false"));

    DriverFactory factory;

    switch (browser) {
      case "firefox":
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (headless) firefoxOptions.addArguments("-headless");
        if (fullscreen) firefoxOptions.addArguments("--start-maximized");
        return new FirefoxDriverFactory(firefoxOptions).createDriver();

      case "edge":
        EdgeOptions edgeOptions = new EdgeOptions();
        if (headless) edgeOptions.addArguments("--headless=new");
        if (fullscreen) edgeOptions.addArguments("--start-maximized");
        return new EdgeDriverFactory(edgeOptions).createDriver();

      case "chrome":
      default:
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) chromeOptions.addArguments("--headless=new");
        if (fullscreen) chromeOptions.addArguments("--start-maximized");
        return new ChromeDriverFactory(chromeOptions).createDriver();
    }
  }
}