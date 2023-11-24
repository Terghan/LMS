package lms;

import java.util.Date;

public class Transaction {
    // Variables
    private Book book;
    private User user;
    private Date borrowDate;
    private Date returnDate;
    private boolean returned;
    private double lateFee;

    // Constructors
    public Transaction(Book book, User user, Date borrowDate) {
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.returned = false; // By default, a new transaction is not returned
    }

    // Getters
    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public double getLateFee() {
        return lateFee;
    }

    // Setters
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    // Methods

    /**
     * Mark the transaction as returned and calculate the late fee if applicable.
     */
    public void markAsReturned() {
        if (!returned) {
            returned = true;
            calculateLateFee();
            System.out.println("Transaction marked as returned.");
        } else {
            System.out.println("Transaction is already returned.");
        }
    }

    /**
     * Calculate the late fee based on the return date.
     */
    private void calculateLateFee() {
        // Assuming a simple late fee calculation, you can customize this based on your requirements.
        // For example, $1 per day for each day overdue.
        long daysLate = (returnDate.getTime() - borrowDate.getTime()) / (24 * 60 * 60 * 1000);
        if (daysLate > 0) {
            lateFee = daysLate * 1.0; // $1 per day
            System.out.println("Late fee calculated: $" + lateFee);
        } else {
            lateFee = 0.0;
            System.out.println("No late fee incurred.");
        }
    }
}
