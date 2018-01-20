package algs;

import org.junit.Assert;
import org.junit.Test;

public class TestSymbolTableArray {

  @Test
  public void testSymbolTableArray() {
    SymbolTableArray<String, Integer> st = new SymbolTableArray<>(20);

    st.put("banana", 10);
    st.put("apple", 1);
    st.put("zebra", -1);
    st.put("cereal", 2);

    Assert.assertEquals(4, st.size());
    Assert.assertEquals(true, st.contains("zebra"));
    Assert.assertEquals(false, st.contains("california"));
    Assert.assertEquals(Integer.valueOf(10), st.get("banana"));
    Assert.assertEquals(Integer.valueOf(2), st.get("cereal"));

    st.delete("apple");
    Assert.assertEquals(false, st.contains("apple"));
  }
}
