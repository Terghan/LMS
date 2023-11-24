package lms;

public class Book {
    // Variables
    private String title;
    private String author;
    private String genre;
    private String ISBN;
    private boolean available;

    // Constructors
    public Book(String title, String author, String genre, String ISBN) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ISBN = ISBN;
        this.available = true;  // By default, a new book is available
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAvailability(boolean available) {
        this.available = available;
    }

    // Methods

    /**
     * Update the details of the book.
     * 
     * @param title   The new title of the book.
     * @param author  The new author of the book.
     * @param genre   The new genre of the book.
     * @param ISBN    The new ISBN of the book.
     */
    public void updateBookDetails(String title, String author, String genre, String ISBN) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ISBN = ISBN;
    }

    /**
     * Mark the book as borrowed by updating its availability status.
     */
    public void markAsBorrowed() {
        if (available) {
            available = false;
            System.out.println("Book marked as borrowed.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    /**
     * Mark the book as returned by updating its availability status.
     */
    public void markAsReturned() {
        if (!available) {
            available = true;
            System.out.println("Book marked as returned.");
        } else {
            System.out.println("Book is already returned.");
        }
    }
}
