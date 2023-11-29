package lms;
import java.util.Scanner;

public class UserInterface {
    private BookDatabase bookDatabase;
    private TransactionDatabase transactionDatabase;

    // Constructor
    public UserInterface(BookDatabase bookDatabase, TransactionDatabase transactionDatabase) {
        this.bookDatabase = bookDatabase;
        this.transactionDatabase = transactionDatabase;
    }

    // Methods

    /**
     * Display the main menu of the user interface.
     */
    public void displayMainMenu() {
        System.out.println("User Interface - Main Menu");
        System.out.println("1. Search for Book");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handle user's choice from the main menu.
     * 
     * @param choice The selected option.
     */
    public void handleUserChoice(int choice) {
        try (Scanner scanner = new Scanner(System.in)) {
            switch (choice) {
                case 1:
                    // Search for Book
                    System.out.println("Enter search criteria:");
                    // Get input for search criteria (title, author, genre, ISBN)
                    // Search for books in the database using bookDatabase.searchBooks(criteria);
                    // Display search results
                    break;
                case 2:
                    // Borrow Book
                    System.out.print("Enter the ISBN of the book to borrow: ");
                    String borrowISBN = scanner.nextLine();
                    Book borrowBook = bookDatabase.getBookDetails(borrowISBN);
                    if (borrowBook != null) {
                        // Check if the book is available using bookDatabase.isBookAvailable(borrowISBN);
                        // If available, create a new transaction and add it to the transactionDatabase
                        // Otherwise, display a message that the book is not available
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                // Other cases for additional options
                case 4:
                    System.out.println("Exiting User Interface. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    /**
     * Main method to start the user interface.
     */
    public static void main(String[] args) {
        // Initialize BookDatabase, TransactionDatabase
        UserInterface userInterface = new UserInterface(new BookDatabase(), new TransactionDatabase());
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                userInterface.displayMainMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                userInterface.handleUserChoice(choice);
            }
        }
    }
}
