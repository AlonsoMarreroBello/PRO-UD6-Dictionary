package net.salesianos.entities;

public class Word {
  private String word;

  public Word(String word) {
    this.word = word;
  }

  public String getWord() {
    return word;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Word otherWord = (Word) obj;
    return word.equalsIgnoreCase(otherWord.word);
  }

  @Override
  public int hashCode() {
    return word.toLowerCase().hashCode();
  }
}
