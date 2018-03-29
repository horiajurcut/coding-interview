package ctci.chapter_nine.social_network;

import graphs.Graph;
import graphs.Queue;

public class BBFSData {

  private boolean[] marked;
  private int[] edgeTo;

  private Queue<Integer> queue;
  private int source;

  public BBFSData(Graph g, int source) {
    this.marked = new boolean[g.vertices()];
    this.edgeTo = new int[g.vertices()];

    this.queue = new Queue<>();

    this.marked[source] = true;
    queue.enqueue(source);
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

  public int queueSize() {
    return queue.size();
  }

  public int poll() {
    return queue.dequeue();
  }

  public boolean isMarked(int v) {
    return marked[v];
  }

  public void mark(int v) {
    marked[v] = true;
  }

  public void enqueue(int v) {
    queue.enqueue(v);
  }

  public void edgeTo(int w, int v) {
    edgeTo[w] = v;
  }

  public int[] getPath() {
    return edgeTo;
  }
}
