package ctci.chapter_seven.deck_cards;

public class Runner {

  public static void main(String[] args) {
    System.out.println(Suit.valueOf("CLUB"));
    System.out.println(Suit.DIAMOND.toString());
    System.out.println(Suit.HEART.ordinal());
    System.out.println(Suit.SPADE.getValue());
  }
}
