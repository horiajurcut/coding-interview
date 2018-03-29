package ctci.chapter_nine.cache;

public class Node {
  public Node prev;
  public Node next;
  public String[] results;
  public String query;

  public Node(String q, String[] res) {
    results = res;
    query = q;
  }
}
