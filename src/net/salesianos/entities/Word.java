package net.salesianos.entities;

/**
 * Class that represents a word in the dictionary.
 */
public class Word {
  private String word;

  /**
   * Constructor of the Word class.
   * 
   * @param word The word to represent.
   */
  public Word(String word) {
    this.word = word;
  }

  /**
   * Gets the word.
   * 
   * @return The word.
   */
  public String getWord() {
    return word;
  }

  /**
   * Compares this word with another object.
   * 
   * @param obj The object to compare.
   * @return true if the words are equal (ignoring case), false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Word otherWord = (Word) obj;
    return word.equalsIgnoreCase(otherWord.word);
  }

  /**
   * Calculates the hash code of the word (ignoring case).
   * 
   * @return The hash code.
   */
  @Override
  public int hashCode() {
    return word.toLowerCase().hashCode();
  }
}
