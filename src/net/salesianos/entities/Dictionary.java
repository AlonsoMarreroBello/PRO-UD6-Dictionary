package net.salesianos.entities;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import net.salesianos.utils.Sanitizer;

/**
 * Class representing a dictionary of words.
 */
public class Dictionary {
  private static Map<Character, Set<Word>> dictionary = new HashMap<>();

  /**
   * Adds a word to the dictionary.
   * 
   * @param scanner Scanner to read user input.
   */
  public static void addWord(Scanner scanner) {
    System.out.print("Enter a word: ");
    String wordStr = scanner.nextLine();
    if (Sanitizer.containsNumbers(wordStr)) {
      System.out.println("Words containing numbers cannot be added.");
      return;
    }
    String sanitizedWord = Sanitizer.sanitize(wordStr);

    char initial = sanitizedWord.charAt(0);
    Set<Word> words = dictionary.computeIfAbsent(initial, k -> new HashSet<>());

    Word newWord = new Word(sanitizedWord);
    if (words.add(newWord)) {
      System.out.println("Word added successfully.");
    } else {
      System.out.println("The word was already in the dictionary.");
    }
  }

  /**
   * Deletes a word from the dictionary.
   * 
   * @param scanner Scanner to read user input.
   */
  public static void deleteWord(Scanner scanner) {
    System.out.print("Enter the word to delete: ");
    String wordStr = scanner.nextLine();
    String sanitizedWord = Sanitizer.sanitize(wordStr);

    char initial = sanitizedWord.charAt(0);
    Set<Word> words = dictionary.getOrDefault(initial, Collections.emptySet());

    Word wordToDelete = new Word(sanitizedWord);
    if (words.remove(wordToDelete)) {
      System.out.println("Word deleted successfully.");
    } else {
      System.out.println("The word was not in the dictionary.");
    }
  }

  /**
   * Checks if a word is in the dictionary.
   * 
   * @param scanner Scanner to read user input.
   */
  public static void searchWord(Scanner scanner) {
    System.out.print("Enter the word to search for: ");
    String wordStr = scanner.nextLine();
    String sanitizedWord = Sanitizer.sanitize(wordStr);

    char initial = sanitizedWord.charAt(0);
    Set<Word> words = dictionary.getOrDefault(initial, Collections.emptySet());

    Word wordToSearch = new Word(sanitizedWord);
    if (words.contains(wordToSearch)) {
      System.out.println("The word is in the dictionary.");
    } else {
      System.out.println("The word is not in the dictionary.");
    }
  }

  /**
   * Displays the available initials in the dictionary.
   */
  public static void showInitials() {
    if (dictionary.isEmpty()) {
      System.out.println("There are no stored words.");
      return;
    }

    System.out.println("Available initials:");
    for (char initial : dictionary.keySet()) {
      System.out.println(initial);
    }
  }

  /**
   * Displays words that start with a specific initial.
   * 
   * @param scanner Scanner to read user input.
   */
  public static void viewWordsByInitial(Scanner scanner) {
    System.out.print("Enter the initial: ");
    char initial = scanner.nextLine().charAt(0);
    initial = Character.toLowerCase(initial);

    Set<Word> words = dictionary.getOrDefault(initial, Collections.emptySet());
    if (words.isEmpty()) {
      System.out.println("There are no words starting with that initial.");
    } else {
      System.out.println("Words starting with '" + initial + "':");
      for (Word word : words) {
        System.out.println(word.getWord());
      }
    }
  }
}
