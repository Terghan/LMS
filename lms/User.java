package lms;

public class User {
    // Variables
    private String name;
    private String contactDetails;

    // Constructors
    public User(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    // Methods

    /**
     * Update the user's information.
     * 
     * @param name            The new name of the user.
     * @param contactDetails  The new contact details of the user.
     */
    public void updateUserInfo(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }

    /**
     * Display the user's information.
     */
    public void displayUserInfo() {
        System.out.println("User Information:");
        System.out.println("Name: " + name);
        System.out.println("Contact Details: " + contactDetails);
    }

}
