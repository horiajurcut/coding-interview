package ctci.moderate.xml_encoding;

public class Solution {

  private static void encode(Element root, StringBuilder sb) {
    for (Attribute a : root.attributes) {
      encode(a, sb);
    }

    encode("0", sb);

    if (root.value != null && !root.value.equals("")) {
      encode(root.value, sb);
    } else {
      for (Element e : root.children) {
        encode(e, sb);
      }
    }
    encode("0", sb);
  }

  private static void encode(String v, StringBuilder sb) {
    sb.append(v);
    sb.append(" ");
  }

  private static void encode(Attribute attr, StringBuilder sb) {
    encode(attr.getTagCode(), sb);
    encode(attr.value, sb);
  }

  private static String encodeToString(Element root) {
    StringBuilder sb = new StringBuilder();
    encode(root, sb);
    return sb.toString();
  }

  public static void main(String args[]) {
    Element root = new Element("family");
    Attribute a1 = new Attribute("lastName", "mcdowell");
    Attribute a2 = new Attribute("state", "CA");
    root.insert(a1);
    root.insert(a2);

    Element child = new Element("person", "Some Message");
    Attribute a3 = new Attribute("firstName", "Gayle");
    child.insert(a3);

    root.insert(child);

    String s = encodeToString(root);
    System.out.println(s);
  }
}
