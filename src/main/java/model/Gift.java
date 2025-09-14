package model;

import utils.TestDataGenerator;

public class Gift {
  private final String name;
  private final String description;
  private final String storeUrl;
  private final String imageUrl;
  private final int price;

  private Gift(Builder b) {
    this.name = b.name;
    this.description = b.description;
    this.storeUrl = b.storeUrl;
    this.imageUrl = b.imageUrl;
    this.price = b.price;
  }

  // геттеры
  public String getName() { return name; }
  public String getDescription() { return description; }
  public String getStoreUrl() { return storeUrl; }
  public String getImageUrl() { return imageUrl; }
  public int getPrice() { return price; }

  public static Builder builder() { return new Builder(); }

  public static class Builder {
    private String name;
    private String description;
    private String storeUrl;
    private String imageUrl;
    private int price;

    public Builder random() {
      this.name = TestDataGenerator.giftName();
      this.description = TestDataGenerator.giftDescription();
      this.storeUrl = TestDataGenerator.storeUrl();
      this.imageUrl = TestDataGenerator.imageUrl();
      this.price = TestDataGenerator.priceInt(100, 10000);
      return this;
    }

    public Builder withName(String name) { this.name = name; return this; }
    public Builder withDescription(String description) { this.description = description; return this; }
    public Builder withStoreUrl(String storeUrl) { this.storeUrl = storeUrl; return this; }
    public Builder withImageUrl(String imageUrl) { this.imageUrl = imageUrl; return this; }
    public Builder withPrice(int price) { this.price = price; return this; }

    public Gift build() { return new Gift(this); }
  }
}