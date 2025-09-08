/**
 * Класс, который подкладывает переменные из конфигов
 * Удобно поменять в одном файле, чтобы запускать тесты
 * @author Григорьев Н.
 */
package tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
  private static final Properties props = new Properties();

  static {
    try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
      if (input != null) {
        props.load(input);
      } else {
        throw new RuntimeException("config.properties не найден. Создайте его на основе config.properties.example");
      }
    } catch (IOException e) {
      throw new RuntimeException("Ошибка загрузки config.properties", e);
    }
  }

  public static String get(String key) {
    return props.getProperty(key);
  }

  public static String get(String key, String defaultValue) {
    return props.getProperty(key, defaultValue);
  }
}
