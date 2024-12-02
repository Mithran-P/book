import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    // Constructor for an empty book
    public Book() {
        // Empty book
    }

    // Print a range of lines from the book
    public void printlines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    // Getter and setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Get the text of a specific line
    public String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    // Get the total number of lines in the book
    public int getLineCount() {
        return text.size();
    }

    // Add a line of text to the book
    public void appendLine(String line) {
        text.add(line);
    }

    // Load a book from a string
    public void readFromString(String title, String string) {
        this.title = title;
        Scanner scanner = new Scanner(string);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            text.add(line);
        }
        scanner.close();
    }

    // Load a book from a URL
    public void readFromUrl(String title, String url) {
        this.title = title;
        try {
            URL bookUrl = new URL(url);
            Scanner scanner = new Scanner(bookUrl.openStream());
            while (scanner.hasNext()) {
                text.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Load a book from a file
    public void readFromFile(String filePath, String title) throws IOException {
        this.title = title;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            text.add(line);
        }
        reader.close();
    }

    // Write the book's text to a file
    public void writeToFile(String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (String line : text) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}
