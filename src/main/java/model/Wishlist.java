package model;

import utils.TestDataGenerator;

public class Wishlist {
  private final String title;
  private final String description;

  private Wishlist(Builder b) {
    this.title = b.title;
    this.description = b.description;
  }

  public String getTitle() { return title; }
  public String getDescription() { return description; }

  public static Builder builder() { return new Builder(); }

  public static class Builder {
    private String title;
    private String description;

    public Builder random() {
      this.title = TestDataGenerator.wishlistTitle();
      this.description = TestDataGenerator.wishlistDescription();
      return this;
    }

    public Builder withTitle(String title) { this.title = title; return this; }
    public Builder withDescription(String description) { this.description = description; return this; }

    public Wishlist build() { return new Wishlist(this); }
  }
}