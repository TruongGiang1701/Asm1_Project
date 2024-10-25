package DemoCode;
import java.util.ArrayList;

public class Library {
    private ArrayList<String> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(String bookName) {
        if (bookName != null && !bookName.isEmpty()) {
            books.add(bookName);
            System.out.println("Added: " + bookName);
        } else {
            System.out.println("Invalid book name.");
        }
    }
    public void removeBook(String bookName) {
        if (books.remove(bookName)) {
            System.out.println("Removed: " + bookName);
        } else {
            System.out.println("Book not found.");
        }
    }
    public void displayBooks() {
        System.out.println("Books in the library:");
        for (String book : books) {
            System.out.println("- " + book);
        }
    }
    public int getTotalBooks() {
        return books.size();
    }
}
