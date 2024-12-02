public class App {
    public static void main(String[] args) {
        // Step 1: Create an instance of Book and add the Grinch story text to it
        Book grinchBook = new Book();
        grinchBook.setTitle("How The Grinch Stole Christmas");

        // Add the full text of the Grinch story to the book
        String grinchStory = 
            "Every Who Down in Whoville Liked Christmas a lot...\n" +
            "But the Grinch,Who lived just north of Whoville, Did NOT!\n" +
            "The Grinch hated Christmas! The whole Christmas season!\n" +
            "Now, please don't ask why. No one quite knows the reason.\n" +
            "It could be his head wasn't screwed on just right.\n" +
            "It could be, perhaps, that his shoes were too tight.\n" +
            "But I think that the most likely reason of all,\n" +
            "May have been that his heart was two sizes too small.\n" +
            "Whatever the reason, His heart or his shoes,\n" +
            "He stood there on Christmas Eve, hating the Whos,\n" +
            "Staring down from his cave with a sour, Grinchy frown,\n" +
            "At the warm lighted windows below in their town.\n" +
            "For he knew every Who down in Whoville beneath,\n" +
            "Was busy now, hanging a mistletoe wreath.\n" +
            "And they're hanging their stockings! he snarled with a sneer,\n" +
            "Tomorrow is Christmas! It's practically here!\n" +
            "...";  // Add the rest of the story here in a similar format

        // Adding the story text to the book
        grinchBook.readFromString(grinchBook.getTitle(), grinchStory);

        // Step 2: Print original Grinch story (optional)
        System.out.println("Original Grinch Story:\n");
        grinchBook.printlines(0, grinchBook.getLineCount());

        // Step 3: Translate the Grinch book to Pig Latin using the PigLatinTranslator
        PigLatinTranslator translator = new PigLatinTranslator();
        Book translatedGrinchBook = translator.translate(grinchBook);

        // Step 4: Print the translated Grinch story in Pig Latin
        System.out.println("\nGrinch Story in Pig Latin:\n");
        translatedGrinchBook.printlines(0, translatedGrinchBook.getLineCount());
    }
}
