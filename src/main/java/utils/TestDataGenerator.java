package utils;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * Класс, который генерирует название, описание, урл магазина, урл картинки и цену подарка
 *
 */
public final class TestDataGenerator {
  private static final SecureRandom rnd = new SecureRandom();

  private TestDataGenerator() {}

  // ==== Gift ====
  public static String giftName() {
    return "Gift-" + UUID.randomUUID().toString().substring(0, 8);
  }

  public static String giftDescription() {
    return "Описание подарка " + UUID.randomUUID().toString().substring(0, 6);
  }

  public static String storeUrl() {
    return "https://store.example/item/" + UUID.randomUUID().toString().substring(0, 6);
  }

  public static String imageUrl() {
    return "https://cdn.example/images/" + UUID.randomUUID().toString().substring(0, 6) + ".jpg";
  }

  public static int priceInt(int min, int max) {
    return rnd.nextInt((max - min) + 1) + min;
  }

  // ==== Wishlist ====
  public static String wishlistTitle() {
    return "Wishlist-" + UUID.randomUUID().toString().substring(0, 8);
  }

  public static String wishlistDescription() {
    return "Описание вишлиста " + UUID.randomUUID().toString().substring(0, 6);
  }
}
