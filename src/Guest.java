public class Guest {

    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;


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
