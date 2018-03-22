package ctci.chapter_seven.deck_cards;

public enum Suit {
  CLUB(0),
  DIAMOND(1),
  HEART(2),
  SPADE(3);
  private int value;

  Suit(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
