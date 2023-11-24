package lms;
import java.util.ArrayList;
import java.util.List;

public class TransactionDatabase {
    // Variable
    private List<Transaction> transactions;

    // Constructor
    public TransactionDatabase() {
        this.transactions = new ArrayList<>();
    }

    // Methods

    /**
     * Add a new transaction to the database.
     * 
     * @param transaction The transaction to be added.
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("Transaction added to the database.");
    }

    /**
     * Update the details of an existing transaction in the database.
     * 
     * @param index        The index of the transaction to be updated.
     * @param transaction  The updated transaction object.
     */
    public void updateTransaction(int index, Transaction transaction) {
        if (index >= 0 && index < transactions.size()) {
            transactions.set(index, transaction);
            System.out.println("Transaction details updated.");
        } else {
            System.out.println("Invalid index for transaction.");
        }
    }

    /**
     * Remove a transaction from the database.
     * 
     * @param index The index of the transaction to be removed.
     */
    public void removeTransaction(int index) {
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
            System.out.println("Transaction removed from the database.");
        } else {
            System.out.println("Invalid index for transaction.");
        }
    }

    /**
     * Get the details of a specific transaction.
     * 
     * @param index The index of the transaction.
     * @return The transaction object.
     */
    public Transaction getTransactionDetails(int index) {
        if (index >= 0 && index < transactions.size()) {
            return transactions.get(index);
        } else {
            System.out.println("Invalid index for transaction.");
            return null;
        }
    }
}
