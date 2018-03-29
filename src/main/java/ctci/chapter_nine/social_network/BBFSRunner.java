package ctci.chapter_nine.social_network;

import graphs.Graph;
import java.util.ArrayList;

public class BBFSRunner {

  private Graph g;

  public BBFSRunner(Graph g) {
    this.g = g;
  }

  public ArrayList<Integer> findPathToFriend(int source, int destination) {
    BBFSData fromSource = new BBFSData(g, source);
    BBFSData fromDestination = new BBFSData(g, destination);

    while (!fromSource.isEmpty() && !fromDestination.isEmpty()) {
      int collision = searchLevel(g, fromSource, fromDestination);

      if (collision != -1) {
        return mergePath(fromSource.getPath(), fromDestination.getPath(), collision);
      }

      collision = searchLevel(g, fromDestination, fromSource);

      if (collision != -1) {
        return mergePath(fromSource.getPath(), fromDestination.getPath(), collision);
      }
    }

    return new ArrayList<>();
  }

  public int searchLevel(Graph g, BBFSData first, BBFSData second) {
    int toProcess = first.queueSize();

    for (int i = 0; i < toProcess; toProcess++) {
      int current = first.poll();

      if (second.isMarked(current)) {
        return current;
      }

      for (int friend : g.adjacent(current)) {
        first.mark(friend);
        first.edgeTo(friend, current);
        first.enqueue(friend);
      }
    }

    return -1;
  }

  private ArrayList<Integer> mergePath(int[] first, int[] second, int collision) {
    ArrayList<Integer> pathBetweenFriends = new ArrayList<>();

    int pointer = 0;
    int max = first.length;

    while (first[pointer] != collision && pointer < max) {
      pathBetweenFriends.add(first[pointer]);
      ++pointer;
    }
    pathBetweenFriends.add(collision);
    pointer = max - 1;
    while (second[pointer] != collision && pointer > 0) {
      pathBetweenFriends.add(second[pointer]);
      --pointer;
    }

    return pathBetweenFriends;
  }
}
