package lms;

import java.util.HashMap;
import java.util.Map;

public class BookDatabase {
    // Variable
    private Map<String, Book> books;

    // Constructor
    public BookDatabase() {
        this.books = new HashMap<>();
    }

    // Methods

    /**
     * Add a new book to the database.
     * 
     * @param book The book to be added.
     */
    public void addBook(Book book) {
        books.put(book.getISBN(), book);
        System.out.println("Book added to the database.");
    }

    /**
     * Update the details of an existing book in the database.
     * 
     * @param ISBN    The ISBN of the book to be updated.
     * @param book    The updated book object.
     */
    public void updateBook(String ISBN, Book book) {
        if (books.containsKey(ISBN)) {
            books.put(ISBN, book);
            System.out.println("Book details updated.");
        } else {
            System.out.println("Book not found in the database.");
        }
    }

    /**
     * Remove a book from the database.
     * 
     * @param ISBN The ISBN of the book to be removed.
     */
    public void removeBook(String ISBN) {
        if (books.containsKey(ISBN)) {
            books.remove(ISBN);
            System.out.println("Book removed from the database.");
        } else {
            System.out.println("Book not found in the database.");
        }
    }

    /**
     * Get the details of a specific book.
     * 
     * @param ISBN The ISBN of the book.
     * @return The book object.
     */
    public Book getBookDetails(String ISBN) {
        return books.get(ISBN);
    }

    /**
     * Check if a book is available for borrowing.
     * 
     * @param ISBN The ISBN of the book.
     * @return True if the book is available, false otherwise.
     */
    public boolean isBookAvailable(String ISBN) {
        if (books.containsKey(ISBN)) {
            return books.get(ISBN).isAvailable();
        } else {
            return false;
        }
    }

    public static void displayLibrary(BookDatabase bookDatabase) {
        System.out.println("Library Contents: ");
        for (Map.Entry<String, Book> entry : bookDatabase.books.entrySet()) {
            Book book = entry.getValue();
            System.out.println(book);
        }
    }

}
