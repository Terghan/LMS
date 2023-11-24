package lms;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    // Variable
    private Map<String, User> users;

    // Constructor
    public UserDatabase() {
        this.users = new HashMap<>();
    }

    // Methods

    /**
     * Add a new user to the database.
     * 
     * @param user The user to be added.
     */
    public void addUser(User user) {
        users.put(user.getName(), user);
        System.out.println("User added to the database.");
    }

    /**
     * Update the details of an existing user in the database.
     * 
     * @param name The name of the user to be updated.
     * @param user The updated user object.
     */
    public void updateUser(String name, User user) {
        if (users.containsKey(name)) {
            users.put(name, user);
            System.out.println("User details updated.");
        } else {
            System.out.println("User not found in the database.");
        }
    }

    /**
     * Remove a user from the database.
     * 
     * @param name The name of the user to be removed.
     */
    public void removeUser(String name) {
        if (users.containsKey(name)) {
            users.remove(name);
            System.out.println("User removed from the database.");
        } else {
            System.out.println("User not found in the database.");
        }
    }

    /**
     * Get the details of a specific user.
     * 
     * @param name The name of the user.
     * @return The user object.
     */
    public User getUserDetails(String name) {
        return users.get(name);
    }
}
