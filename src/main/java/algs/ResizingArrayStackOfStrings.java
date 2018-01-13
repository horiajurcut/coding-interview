package algs;

public class ResizingArrayStackOfStrings {

  private String[] s;
  private int n = 0;

  public ResizingArrayStackOfStrings() {
    s = new String[1];
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public void push(String item) {
    if (n == s.length) {
      resize(2 * s.length);
    }
    s[n++] = item;
  }

  public String pop() {
    String item = s[--n];
    s[n] = null; // release reference to unused object
    if (n > 0 && n == s.length / 4) { // halve it when it's one quarter full
      resize(s.length / 2);
    }
    return item;
  }

  private void resize(int capacity) {
    String[] newStack = new String[capacity];
    for (int i = 0; i < n; i++) {
      newStack[i] = s[i];
    }
    s = newStack;
  }
}
