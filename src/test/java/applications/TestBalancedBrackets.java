package applications;

import org.junit.Assert;
import org.junit.Test;

public class TestBalancedBrackets {

  @Test
  public void testBalancedBracketsWithoutExtraChars() {
    Assert.assertEquals(true, BalancedBrackets.isBalanced( "([])[]()"));
  }

  @Test
  public void testBalancedBracketsWithExtraChars() {
    Assert.assertEquals(true, BalancedBrackets.isBalanced( "(a(a(a[(x[yo])]))())"));
  }

  @Test
  public void testUnbalancedBracketsWithoutExtraChars() {
    Assert.assertEquals(false, BalancedBrackets.isBalanced( "]["));
  }

  @Test
  public void testUnbalancedBracketsWithExtraChars() {
    Assert.assertEquals(false, BalancedBrackets.isBalanced( "(a[]a]()"));
  }
}
