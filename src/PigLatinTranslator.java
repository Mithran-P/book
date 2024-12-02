public class PigLatinTranslator {

  // Translate a book into Pig Latin
  public static Book translate(Book input) {
      Book translatedBook = new Book();
      translatedBook.setTitle("Translated: " + input.getTitle());

      for (int i = 0; i < input.getLineCount(); i++) {
          String line = input.getLine(i);
          translatedBook.appendLine(translate(line));
      }

      return translatedBook;
  }

  // Translate a single line into Pig Latin
  public static String translate(String input) {
      String[] words = input.split("\\s+");
      StringBuilder result = new StringBuilder();

      for (String word : words) {
          if (!word.isEmpty()) {
              result.append(translateWord(word)).append(" ");
          }
      }

      return result.toString().trim();
  }

  // Translate a single word into Pig Latin
  private static String translateWord(String input) {
      String punctuation = input.replaceAll("[\\w'-]+", "");
      String word = input.replaceAll("[^\\w'-]", "");

      if (word.isEmpty()) return punctuation; // Handle edge cases like punctuation-only words.

      boolean isCapitalized = Character.isUpperCase(word.charAt(0));
      word = word.toLowerCase();

      int firstVowelIndex = findFirstVowelIndex(word);

      String translatedWord;
      if (firstVowelIndex == 0) {
          translatedWord = word + "ay";
      } else if (firstVowelIndex > 0) {
          translatedWord = word.substring(firstVowelIndex) + word.substring(0, firstVowelIndex) + "ay";
      } else {
          translatedWord = word + "ay"; // No vowels case
      }

      if (isCapitalized) {
          translatedWord = capitalizeFirstLetter(translatedWord);
      }

      return translatedWord + punctuation;
  }

  // Find the index of the first vowel in a word
  private static int findFirstVowelIndex(String word) {
      String vowels = "aeiou";
      for (int i = 0; i < word.length(); i++) {
          if (vowels.contains(String.valueOf(word.charAt(i)))) {
              return i;
          }
      }
      return -1;
  }

  // Capitalize the first letter of a word
  private static String capitalizeFirstLetter(String input) {
      if (input.isEmpty()) return input;
      return Character.toUpperCase(input.charAt(0)) + input.substring(1);
  }
}
