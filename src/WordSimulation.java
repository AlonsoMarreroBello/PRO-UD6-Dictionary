import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import net.salesianos.entities.Dictionary;

public class WordSimulation {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to the word simulation.");

    String option;
    do {
      try {
        System.out.print("""
            \nMenu:
            1. Add word
            2. Delete word
            3. Check word
            4. Show available initials
            5. View words by initial
            6. Close program
            Choose an option:
            """);
        option = scanner.nextLine();

        switch (option) {
          case "1":
            Dictionary.addWord(scanner);
            break;
          case "2":
            Dictionary.deleteWord(scanner);
            break;
          case "3":
            Dictionary.searchWord(scanner);
            break;
          case "4":
            Dictionary.showInitials();
            break;
          case "5":
            Dictionary.viewWordsByInitial(scanner);
            break;
          case "6":
            System.out.println("Goodbye!");
            break;
          default:
            System.out.println("Invalid option.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Error: The option must be a number.");
        scanner.nextLine();
        option = "0";
      } catch (NoSuchElementException e) {
        System.out.println("Error: Input was expected.");
        option = "0";
      }
    } while (!option.equals("6"));
    scanner.close();
  }
}
