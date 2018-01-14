package applications;

import org.junit.Assert;
import org.junit.Test;

public class TestDijkstraTwoStack {

  @Test
  public void testDijkstraTwoStack() {
    final String expression = "(1+(1+((2*3)+1)))";

    Assert.assertEquals(9.0, DijkstraTwoStack.evaluate(expression), 0.0);
  }
}
