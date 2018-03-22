package ctci.chapter_seven;

public class SingletonPattern {

  private static SingletonPattern _instance = null;
  private SingletonPattern() {}
  public static SingletonPattern getInstance() {
    if (_instance == null) {
      _instance = new SingletonPattern();
    }
    return _instance;
  }
}
