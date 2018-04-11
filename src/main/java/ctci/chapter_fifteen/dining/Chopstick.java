package ctci.chapter_fifteen.dining;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

  private Lock lock;

  public Chopstick() {
    lock = new ReentrantLock();
  }

  public boolean pickUp() {
    // lock.lock();
    return lock.tryLock();
  }

  public void putDown() {
    lock.unlock();
  }
}
