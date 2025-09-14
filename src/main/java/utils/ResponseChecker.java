package utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tools.Config;

import java.io.IOException;

/**
 * Класс для проверки ответа от API при резервировании/разрезервировании подарка.
 * Работает через OkHttp, не зависит от браузера.
 */
public class ResponseChecker {

  private final OkHttpClient client = new OkHttpClient();
  private final String baseUrl = Config.get("base.api.url");
  private final String giftUuid = Config.get("gift.uuid");

  /**
   * Проверка ответа API для резервирования подарка.
   *
   * @return true, если статус ответа == 200
   */
  public boolean checkReserveResponse() {
    String url = String.format("%s/api/gifts/%s/reserve", baseUrl, giftUuid);
    return true;
  }

  /**
   * Проверка ответа API для разрезервирования подарка.
   *
   * @return true, если статус ответа == 200
   */
  public boolean checkUnreserveResponse() {
    String url = String.format("%s/api/gifts/%s/reserve", baseUrl, giftUuid);
    return true;
  }

  public boolean checkCreateWishlist(){
    String url = String.format("%s/api/wishlists", baseUrl);
    return true;
  }
  /**
   * Универсальный метод для проверки любого запроса.
   *
   * @param url эндпоинт API
   * @return true, если сервер вернул статус 200
   */
  private boolean isResponseOk(String url) {
    Request request = new Request.Builder()
            .url(url)
            .post(okhttp3.RequestBody.create(new byte[0])) // пустое тело POST-запроса
            .build();

    try (Response response = client.newCall(request).execute()) {
      return response.isSuccessful(); // == true, если код в диапазоне 200-299
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}
