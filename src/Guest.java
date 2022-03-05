import java.util.Locale;

public class Guest {

    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;

    public Guest() {
        this("", "", "", "");
    }

    public Guest(String email){
        this.email = email;
    }




    public Guest(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
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


    public boolean checkGuest(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        if (lastName.toLowerCase().contains(str) ||
                firstName.toLowerCase().contains(str) ||
                email.toLowerCase().contains(str) ||
                phoneNumber.toLowerCase().contains(str)) {
            return true;
        }
        return false;
    }

    public void updateGuest(String updatedGuest, int option) {
        switch (option) {
            case 1:
                this.lastName = updatedGuest;
                System.out.println("Last name updated");
                break;
            case 2:
                this.firstName = updatedGuest;
                System.out.println("First name updated");
                break;
            case 3:
                this.email = updatedGuest;
                System.out.println("Email updated");
                break;
            case 4:
                this.phoneNumber = updatedGuest;
                System.out.println("Phone number updated");
                break;
        }
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
        return "Last Name: " + lastName + " | " +
                "First Name: " + firstName + " | " +
                "Email: " + email + " | " +
                "Phone number: " + phoneNumber;
    }


}
