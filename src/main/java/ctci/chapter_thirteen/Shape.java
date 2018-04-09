package ctci.chapter_thirteen;

import java.util.Random;
import java.util.function.Predicate;

public class Shape {

  private int size;

  // Can't be private since it's subclassed by Square
  Shape(final int size) {
    this.size = size;

    Random random = new Random();
    Predicate<Object> flipCoin = o -> random.nextBoolean();
  }
}
