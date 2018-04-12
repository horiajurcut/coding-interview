package ctci.moderate;

import java.util.HashMap;

public class WordFrequencies {

  private static HashMap<String, Integer> setupDictionary(String[] book) {
    HashMap<String, Integer> dictionary = new HashMap<>();

    for (String word : book) {
      word = word.toLowerCase().trim();
      if (!word.equals("")) {
        if (!dictionary.containsKey(word)) {
          dictionary.put(word, 0);
        }
        dictionary.put(word, dictionary.get(word) + 1);
      }
    }

    return dictionary;
  }

  private static int getFrequency(HashMap<String, Integer> dictionary, String word) {
    if (dictionary == null || word == null) {
      return -1;
    }

    word = word.toLowerCase().trim();

    if (dictionary.containsKey(word)) {
      return dictionary.get(word);
    }

    return 0;
  }

  public static void main(String[] args) {
    String[] book = { "the", "shining", "is", "career", "the", "it", "the", "the", "it" };
    HashMap<String, Integer> dictionary = setupDictionary(book);

    String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
    for (String word : words) {
      System.out.println(word + ": " + getFrequency(dictionary, word));
    }
  }
}
