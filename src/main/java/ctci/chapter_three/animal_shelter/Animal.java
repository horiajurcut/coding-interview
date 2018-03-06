package ctci.chapter_three.animal_shelter;

public abstract class Animal {

  private int order;
  protected String name;
  public Animal(String name) {
    this.name = name;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public int getOrder() {
    return order;
  }

  public boolean isOlderThan(Animal a) {
    return this.order > a.getOrder();
  }
}
