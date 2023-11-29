package lms;

import java.util.Scanner;

public class LibrarianInterface {
    private BookDatabase bookDatabase;
    private UserDatabase userDatabase;
    private TransactionDatabase transactionDatabase;

    // Constructor
    public LibrarianInterface(BookDatabase bookDatabase, UserDatabase userDatabase, TransactionDatabase transactionDatabase) {
        this.bookDatabase = bookDatabase;
        this.userDatabase = userDatabase;
        this.transactionDatabase = transactionDatabase;
    }

    // Methods

    /**
     * Display the main menu of the librarian interface.
     */
    public void displayMainMenu() {
        System.out.println("Librarian Interface - Main Menu");
        System.out.println("1. Display Library");
        System.out.println("2. Add Book");
        System.out.println("3. Update Book");
        System.out.println("4. Add User");
        System.out.println("5. Update User");
        System.out.println("6. Remove User");
        System.out.println("7. Display Book Details");
        System.out.println("8. Display User Details");
        System.out.println("9. Display Transaction Details");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handle librarian's choice from the main menu.
     *
     * @param choice The selected option.
     */
    public void handleLibrarianChoice(int choice) {
        Scanner scanner = new Scanner(System.in);
            switch (choice) {
                case 1:
                    // Display current library
                    BookDatabase.displayLibrary(bookDatabase);
                    break;
                case 2:
                    // Obtain new book details
                    System.out.println("Enter book title: ");
                    String newTitle = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.println("Enter book genre: ");
                    String newGenre = scanner.nextLine();
                    System.out.println("Enter book ISBN: ");
                    String newISBN = scanner.nextLine();

                    // Create a new Book object
                    Book newBook = new Book(newTitle, newAuthor, newGenre, newISBN);

                    // Add the book to the database using bookDatabase.addBook(book);
                    bookDatabase.addBook(newBook);
                    break;
                case 3:
                    // Update Book
                    System.out.print("Enter the ISBN of the book to update: ");
                    String updateISBN = scanner.nextLine();
                    Book updateBook = bookDatabase.getBookDetails(updateISBN);
                    if (updateBook != null) {
                        // Get updated details for the book
                        System.out.println("Please enter a new title: ");
                        String updatedTitle = scanner.nextLine();
                        System.out.println("Please enter the new author: ");
                        String updatedAuthor = scanner.nextLine();
                        System.out.println("Please enter the new genre: ");
                        String updatedGenre = scanner.nextLine();

                        // Update the book using updateBook.updateBookDetails(newDetails);
                        updateBook.updateBookDetails(updatedTitle, updatedAuthor, updatedGenre, updateISBN);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    // Add User
                    System.out.println("Enter user details:");
                    // Get input for user details (name, contactDetails)
                    System.out.println("Please enter the user's name: ");
                    String newUserName = scanner.nextLine();
                    System.out.println("Please enter user's phone number: ");
                    String newUserPhone = scanner.nextLine();
                    // Create a new User object
                    User newUser = new User(newUserName, newUserPhone);
                    // Add the user to the database using userDatabase.addUser(user);
                    userDatabase.addUser(newUser);
                    break;
                case 5:
                    // Update User
                    System.out.print("Enter the name of the user to update: ");
                    String updateUserName = scanner.nextLine();
                    User updateUser = userDatabase.getUserDetails(updateUserName);
                    if (updateUser != null) {
                        // Get updated details for the user
                        // Update the user using updateUser.updateUserInfo(newDetails);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 6:
                    // Remove User
                    System.out.print("Enter the name of the user to remove: ");
                    String removeUserName = scanner.nextLine();
                    userDatabase.removeUser(removeUserName);
                    break;
                case 7:
                    // Display Book Details
                    System.out.println("Enter the ISBN of the book: ");
                    Book temp = bookDatabase.getBookDetails(scanner.nextLine());
                    System.out.println(temp.getTitle());
                    System.out.println(temp.getAuthor());
                    System.out.println(temp.getGenre());
                    break;
                case 8:
                    // Display User Details
                    // Implement based on your requirements
                    break;
                case 9:
                    // Display Transaction Details
                    // Implement based on your requirements
                    break;
                case 10:
                    System.out.println("Exiting Librarian Interface. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            scanner.close();
        }

    /**
     * Main method to start the librarian interface.
     */
    public static void main(String[] args) {
        // Initialize BookDatabase, UserDatabase, TransactionDatabase
        LibrarianInterface librarianInterface = new LibrarianInterface(new BookDatabase(), new UserDatabase(), new TransactionDatabase());
        Scanner scanner = new Scanner(System.in);
            while (true) {
                librarianInterface.displayMainMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                librarianInterface.handleLibrarianChoice(choice);
                scanner.close();
            }

    }
}
