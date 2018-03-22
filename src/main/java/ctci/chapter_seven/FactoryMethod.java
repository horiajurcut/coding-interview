package ctci.chapter_seven;

public class FactoryMethod {

  public enum InstanceType {
    SINGLE,
    DOUBLE
  }

  static class Instance {}
  private static class SingleInstance extends Instance {}
  private static class DoubleInstance extends Instance {}

  public static Instance createInstance(InstanceType type) {
    if (type == InstanceType.SINGLE) {
      return new FactoryMethod.SingleInstance();
    } else if (type == InstanceType.DOUBLE) {
      return new FactoryMethod.DoubleInstance();
    }

    return null;
  }
}
