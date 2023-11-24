package lms;

import java.util.Scanner;

public class LibraryManagementApp {
    public static void main(String[] args) {
        // Initialize components
        BookDatabase bookDatabase = new BookDatabase();
        UserDatabase userDatabase = new UserDatabase();
        TransactionDatabase transactionDatabase = new TransactionDatabase();

        LibrarianInterface librarianInterface = new LibrarianInterface(bookDatabase, userDatabase, transactionDatabase);
        UserInterface userInterface = new UserInterface(bookDatabase, transactionDatabase);

        // Start the main loop for user interaction
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Librarian Interface");
            System.out.println("2. User Interface");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    runLibrarianInterface(librarianInterface, scanner);
                    break;
                case 2:
                    runUserInterface(userInterface, scanner);
                    break;
                case 3:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void runLibrarianInterface(LibrarianInterface librarianInterface, Scanner scanner) {
        while (true) {
            librarianInterface.displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 9) {
                System.out.println("Returning to main menu.");
                break;
            }

            librarianInterface.handleLibrarianChoice(choice);
        }
    }

    private static void runUserInterface(UserInterface userInterface, Scanner scanner) {
        while (true) {
            userInterface.displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 4) {
                System.out.println("Returning to main menu.");
                break;
            }

            userInterface.handleUserChoice(choice);
        }
    }
}
