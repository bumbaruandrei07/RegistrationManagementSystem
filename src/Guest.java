import java.io.*;
import java.util.List;

public class Guest implements Serializable {

    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private static final long serialVersionUID = 1L;

    public Guest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Guest(String lastName, String firstName, String email, String phoneNumber) {
        this(lastName, firstName);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        //comparing two guests using fields
        return (lastName.equalsIgnoreCase(((Guest) obj).getLastName()) && firstName.equalsIgnoreCase(((Guest) obj).getFirstName())
                || email.equalsIgnoreCase(((Guest) obj).getEmail())
                || phoneNumber.equalsIgnoreCase(((Guest) obj).getPhoneNumber()));
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        System.out.println(firstName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + " | " +
                "Last Name: " + lastName + " | " +
                "Email: " + email + " | " +
                "Phone number: " + phoneNumber;
    }
}
