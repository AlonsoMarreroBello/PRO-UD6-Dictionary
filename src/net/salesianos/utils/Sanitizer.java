package net.salesianos.utils;

public class Sanitizer {

  public static String sanitize(String word) {
    return word.trim().toLowerCase();
  }

  public static boolean containsNumbers(String word) {
    for (char c : word.toCharArray()) {
      if (Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }
}
