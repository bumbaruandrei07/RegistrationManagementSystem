
import exceptions.*;
import exceptions.NumberFormatException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    private static final Scanner sc = new Scanner(System.in);
    private static GuestList guestList = new GuestList(1);

    private static String newCommand() {
        System.out.println("\nEnter a new command:  ");
        return sc.next();
    }

    public static void displayCommandsOptions() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua persoana (inscriere)");
        System.out.println("check        - Verifica daca o persoana este inscrisa la eveniment");
        System.out.println("remove       - Sterge o persoana existenta din lista");
        System.out.println("update       - Actualizeaza detaliile unei persoane");
        System.out.println("guests       - Lista de persoane care participa la eveniment");
        System.out.println("waitlist     - Persoanele din lista de asteptare");
        System.out.println("available    - Numarul de locuri libere");
        System.out.println("guests_no    - Numarul de persoane care participa la eveniment");
        System.out.println("waitlist_no  - Numarul de persoane din lista de asteptare");
        System.out.println("subscribe_no - Numarul total de persoane inscrise");
        System.out.println("search       - Cauta toti invitatii conform sirului de caractere introdus");
        System.out.println("deleteFile   - Sterge fisierul ce contine datele salvate in sistem");
        System.out.println("reset        - Sterge datele din fisierul ce contine toti invitatii inscrisi la eveniment");
        System.out.println("quit         - Inchide aplicatia");
    }

    public static void addGuest() throws NumberFormatException, FirstNameFormatException, LastNameFormatException, PhoneNumberLengthException {
        System.out.println("First name: ");
        String firstName = sc.next();
        if (firstName.matches("[0-9]+")) {
            throw new FirstNameFormatException ("Prenumele nu poate fi format din cifre!");
        }
        System.out.println("Last name: ");
        String lastName = sc.next();
        if (lastName.matches("[0-9]+")) {
            throw new LastNameFormatException("Numele nu poate fi format din cifre!");
        }
        System.out.println("Enter email address (Pattern: name@gmail.com): ");
        String email = sc.next();
        if (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("Email-ul trebuie sa contina pattern-ul : name@gmail.com");
        }
        System.out.println("Phone number: ");
        String phoneNumber = sc.next();
        if (!phoneNumber.matches("[0-9]+")) {
            throw new NumberFormatException("Numarul de telefon trebuie sa fie format doar din cifre!");
        }

        if (phoneNumber.length() != 10) {
            throw new PhoneNumberLengthException("Numarul de telefon contine exact 10 cifre!");
        }
        Guest guest = new Guest(firstName, lastName, email, phoneNumber);
        System.out.println("New guest:\n" + guest);
        guestList.addParticipant(guest);
    }

    private static void guests() {
        System.out.println("Lista de persoane care participa la eveniment: ");
        System.out.println(guestList.getParticipantsList());
    }

    private static void waitList() {
        System.out.println("Persoanele din lista de asteptare: ");
        System.out.println(guestList.getWaitingList());
    }

    private static void available() {
        System.out.println("Numarul de locuri libere: ");
        System.out.println(guestList.getRemainingPlaces());
    }

    private static void guests_no() {
        System.out.println("Numarul de persoane care participa la eveniment: ");
        System.out.println(guestList.getParticipantsListNumber());
    }

    private static void waitlist_no() {
        System.out.println("Numarul de persoane din lista de asteptare: ");
        System.out.println(guestList.getWaitingListNumberOfParticipants());
    }

    private static void subscribe_no() {
        System.out.println("Numarul total de persoane inscrise: ");
        System.out.println(guestList.getTotalNumberOfParticipantsOnLists());

    }

    private static void search() {
        System.out.println("Cauta toti invitatii conform sirului de caractere introdus: ");
        String subSequence = sc.next();
        guestList.partialSearch(subSequence);
    }

    public static void deleteFile() {
        guestList.deleteFile();
    }

    private static void resetApp() {
       guestList.getWaitingList().clear();
       guestList.getParticipantsList().clear();
    }


    private static void remove() throws IndexOutOfBoundsException, NullPointerException, InputMismatchException {
        int options;
        String s1, s2;
        System.out.println("S-a ales optiunea de stergere a unui participant.");
        System.out.println("Introduceti una dintre optiunile : 1 (Cautare dupa First Name & Last Name / 2 (E-mail) / 3 (Phone number)");
        try {
            options = sc.nextInt();
            if (options != 1 && options != 2 && options != 3) {
                throw new InvalidChoiceException("Introduceti una dintre optiunile : 1 (Cautare dupa First Name & Last Name / 2 (E-mail) / 3 (Phone number)");
            }

            switch (options) {
                case 1:
                    System.out.println("First Name: ");
                    s1 = sc.next();
                    System.out.println("Last Name: ");
                    s2 = sc.next();
                    Guest guest1 = new Guest(s1, s2, "", "");

                    if (!guestList.checkName(s1, s2)) {
                        throw new NullPointerException("Nu exista participantul cu acest nume!");
                    }

                    guestList.remove(guest1);
                    break;

                case 2:
                    System.out.println("Introduceti e-mailul: ");
                    s1 = sc.next();
                    Guest guest2 = new Guest("", "", s1, "");

                    if (!guestList.checkEmail(s1)) {
                        throw new NullPointerException("Nu exista participantul cu acest e-mail!");
                    }
                    guestList.remove(guest2);
                    break;

                case 3:
                    System.out.println("Introduceti numarul de telefon: ");
                    s1 = sc.next();
                    Guest guest3 = new Guest("", "", "", s1);
                    if (!guestList.checkPhoneNumber(s1)) {
                        throw new NullPointerException("Nu exista participantul cu acest numar de telefon!");
                    }
                    guestList.remove(guest3);
                    break;
            }
        } catch (InputMismatchException e) {
            System.err.println("Error, this was not a number!!!");
            sc.nextLine();
        } catch (InvalidChoiceException e) {
            e.printStackTrace();
        }
    }

    private static void update() {

        System.out.println("Actualizeaza detaliile unei participant: ");
        System.out.println("Introduceti una dintre optiunile de cautare a participantului : 1 (Cautare dupa First Name & Last Name / 2 (E-mail) / 3 (Phone number)");

        try {
            int option = sc.nextInt();
            if ((option != 1) && (option != 2) && (option != 3)) {
                throw new InvalidChoiceException("Ati introdus o alta valoare din intervalul [1-3]");
            }
            switch (option) {
                case 1:
                    System.out.println("Enter first name: ");
                    String str1 = sc.next();
                    System.out.println("Enter last name: ");
                    String str2 = sc.next();

//                Guest guest1 = new Guest(str1, str2);


//                if (guestList.findGuestInParticipantsList(guest1) == null && guestList.findGuestInWaitingList(guest1) == null) {
//                    System.out.println("Participantul nu exista pe nicio lista!");
//                    break;
//                }

                    //if the guest is not found we will stop the update!
                    if (!guestList.checkName(str1, str2)) {
                        throw new NullPointerException("Participantul cautat nu exista in sistem!");
                    }

                    System.out.println("Enter the option desired to update:  1 (Update First Name) / 2 (Update Last Name) / 3(update e-mail) / 4 (update Phone Number");
                    int optionsI = sc.nextInt();
                    System.out.println("Enter new first name: ");
                    String str3 = sc.next();
                    if (optionsI == 1) {
                        guestList.updateHelper(str1, str2, null, null).setFirstName(str3);
                    } else if (optionsI == 2) {
                        guestList.updateHelper(str1, str2, null, null).setLastName(str3);
                    } else if (optionsI == 3) {
                        guestList.updateHelper(str1, str2, null, null).setEmail(str3);
                    } else if (optionsI == 4) {
                        guestList.updateHelper(str1, str2, null, null).setPhoneNumber(str3);
                    } else throw new InvalidChoiceException("Invalid option!");
                    break;

                case 2:
                    System.out.println("Enter e-mail: ");
                    String str4 = sc.next();

                    //if the guest is not found we will stop the update!
                    if (!guestList.checkEmail(str4)) {
                        break;
                    }
                    System.out.println("Enter the option desired to update:  1 (Update First Name) / 2 (Update Last Name) / 3 (update e-mail) / 4 (update Phone Number");
                    int optionsII = sc.nextInt();
                    System.out.println("Enter the new value: ");
                    String str5 = sc.next();
                    if (optionsII == 1) {
                        guestList.updateHelper(null, null, str4, null).setFirstName(str5);
                    } else if (optionsII == 2) {
                        guestList.updateHelper(null, null, str4, null).setLastName(str5);
                    } else if (optionsII == 3) {
                        guestList.updateHelper(null, null, str4, null).setEmail(str5);
                    } else if (optionsII == 4) {
                        guestList.updateHelper(null, null, str5, null).setPhoneNumber(str5);
                    } else throw new InvalidChoiceException("Invalid option!");
                    break;

                case 3:
                    System.out.println("Enter phone number:");
                    String str6 = sc.next();

                    //if the guest is not found we will stop the update!
                    if (!guestList.checkPhoneNumber(str6)) {
                        break;
                    }

                    System.out.println("Enter the option desired to update:  1 (Update First Name) / 2 (Update Last Name) / 3 (update e-mail) / 4 (update Phone Number)");
                    int optionsIV = sc.nextInt();
                    System.out.println("Enter the new value: ");
                    String str7 = sc.next();
                    if (optionsIV == 1) {
                        guestList.updateHelper(null, null, null, str6).setFirstName(str7);
                    } else if (optionsIV == 2) {
                        guestList.updateHelper(null, null, null, str6).setLastName(str7);
                    } else if (optionsIV == 3) {
                        guestList.updateHelper(null, null, null, str6).setEmail(str7);
                    } else if (optionsIV == 4) {
                        guestList.updateHelper(null, null, null, str6).setPhoneNumber(str7);
                    } else throw new InvalidChoiceException("Invalid option!");
                    break;
            }
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Trebuie sa introduceti una dintre valorile 1 / 2 / 3");

        } catch (InvalidChoiceException e) {
            e.printStackTrace();
        }
    }

    private static void check() {
        String option, s1, s2;
        System.out.println("Verifica daca o persoana este inscrisa la eveniment: ");
        System.out.println("Introduceti una dintre optiunile : A (Cautare dupa First Name & Last Name / B (E-mail) / C (Phone number)");
        option = sc.next();
        if (!option.equals("A") && (!option.equals("B")) && (!option.equals("C"))) {
            throw new IllegalArgumentException("Trebuie sa introduceti A, B sau C");
        }
        switch (option) {
            case "A":
                System.out.println("Enter first name: ");
                s1 = sc.next();
                System.out.println("Enter last name: ");
                s2 = sc.next();
                guestList.checkName(s1, s2);
                break;

            case "B":
                System.out.println("Enter e-mail: ");
                s1 = sc.next();
                guestList.checkEmail(s1);
                break;

            case "C":
                System.out.println("Enter phone number: ");
                s1 = sc.next();
                guestList.checkPhoneNumber(s1);
                break;

            default:
                System.out.println("Optiune invalida!");
                break;
        }
    }

    public static void main(String[] args) throws IOException, NumberFormatException, LastNameFormatException, FirstNameFormatException, PhoneNumberLengthException {

        System.out.println("Welcome to the new Registration Management System! ");
        guestList = GuestList.readFromBinaryFile();
        String chosedOption = newCommand();

        while (!chosedOption.equals("quit")) {

            switch (chosedOption) {
                case "help":
                    displayCommandsOptions();
                    break;

                case "add":
                    addGuest();
                    break;

                case "deleteFile":
                    deleteFile();
                    break;

                case "reset":
                    resetApp();
                    break;

                case "check":
                    check();
                    break;

                case "remove":
                    remove();
                    break;

                case "update":
                    update();
                    break;

                case "guests":
                    guests();
                    break;

                case "waitList":
                    waitList();
                    break;

                case "available":
                    available();
                    break;

                case "guests_no":
                    guests_no();
                    break;

                case "waitlist_no":
                    waitlist_no();
                    break;

                case "subscribe_no":
                    subscribe_no();
                    break;

                case "search":
                    search();
                    break;

                default:
                    System.out.println("Comanda introdusa nu exista!");
                    break;
            }
            chosedOption = newCommand();
        }
        GuestList.writeToBinaryFile(guestList);
        sc.close();
    }

}
