package net.salesianos.utils;

/**
 * Class that provides methods to sanitize and validate words.
 */
public class Sanitizer {

  /**
   * Sanitizes a word, removing leading and trailing whitespaces and converting to
   * lowercase.
   * 
   * @param word The word to sanitize.
   * @return The sanitized word.
   */
  public static String sanitize(String word) {
    return word.trim().toLowerCase();
  }

  /**
   * Checks if a word contains numbers.
   * 
   * @param word The word to check.
   * @return true if the word contains numbers, false otherwise.
   */
  public static boolean containsNumbers(String word) {
    for (char c : word.toCharArray()) {
      if (Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }
}
