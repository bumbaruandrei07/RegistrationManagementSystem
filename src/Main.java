import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final GuestList guestList = new GuestList(1);

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
        System.out.println("quit         - Inchide aplicatia");
    }


    public static void addGuest() {
        System.out.println("First name: ");
        String firstName = sc.next();
        System.out.println("Last name: ");
        String lastName = sc.next();
        System.out.println("E-mail: ");
        String email = sc.next();
        System.out.println("Phone number: ");
        String phoneNumber = sc.next();
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
        String subSequence;
        System.out.println("Cauta toti invitatii conform sirului de caractere introdus: ");
        subSequence = sc.next();
        guestList.partialSearch(subSequence);
    }

    private static void remove() {
        String options, s1, s2;
        System.out.println("S-a ales optiunea de stergere a unui participant.");
        System.out.println("Introduceti una dintre optiunile : A (Cautare dupa First Name & Last Name / B (E-mail) / C (Phone number)");
        options = sc.next();
        switch (options) {
            case "A":
                System.out.println("First Name: ");
                s1 = sc.next();
                System.out.println("Last Name: ");
                s2 = sc.next();
                Guest guest1 = new Guest(s1, s2, "", "");

//                if (!guestList.checkName(s1, s2)) {
//                    System.out.println("Nu exista participantul cautat in nicio lista!");
//                    break;
//                }
                guestList.remove(guest1);
                break;

            case "B":
                System.out.println("Introduceti e-mailul: ");
                s1 = sc.next();
                Guest guest2 = new Guest("", "", s1, "");

//                if (!guestList.checkEmail(s1)) {
//                    System.out.println("Nu exista participantul cautat in nicio lista!");
//                    break;
//                }
                guestList.remove(guest2);
                break;


            case "C":
                System.out.println("Introduceti numarul de telefon: ");
                s1 = sc.next();
                Guest guest3 = new Guest("", "", "", s1);
//                if (!guestList.checkPhoneNumber(s1)) {
//                    System.out.println("Nu exista participantul cautat in nicio lista!");
//                    break;
//                }
                guestList.remove(guest3);
                break;

            default:
                System.out.println("Comanda introdusa este invalida!");
                break;
        }
    }

    private static void update() {

        System.out.println("Actualizeaza detaliile unei participant: ");
        System.out.println("Introduceti una dintre optiunile de cautare a participantului : A (Cautare dupa First Name & Last Name / B (E-mail) / C (Phone number)");
        String option = sc.next();

        switch (option) {
            case "A":
                System.out.println("Enter first name: ");
                String str1 = sc.next();
                System.out.println("Enter last name: ");
                String str2 = sc.next();
                Guest guest1 = new Guest(str1, str2);
                guestList.checkName(str1, str2);

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
                } else System.out.println("Invalid option!");
                break;

            case "B":
                System.out.println("Enter e-mail: ");
                String str4 = sc.next();
                Guest guest2 = new Guest(str4);
                guestList.checkEmail(str4);

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
                } else System.out.println("Invalid option!");
                break;

            case "C":
                System.out.println("Enter phone number:");
                String str6 = sc.next();
                Guest guest3 = new Guest(str6);
                guestList.checkPhoneNumber(str6);

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
                } else System.out.println("Invalid option!");

                break;
        }

    }

    private static void check() {
        String option, s1, s2;
        System.out.println("Verifica daca o persoana este inscrisa la eveniment: ");
        System.out.println("Introduceti una dintre optiunile : A (Cautare dupa First Name & Last Name / B (E-mail) / C (Phone number)");
        option = sc.next();
        switch (option) {
            case "A":
                System.out.println("Enter first name: ");
                s1 = sc.next();
                System.out.println("Enter last name: ");
                s2 = sc.next();
//                Guest guest1 = new Guest(s1, s2);
//                if (guestList.findGuestInWaitingList(guest1) == null && guestList.findGuestInParticipantsList(guest1) == null) {
//                    System.out.println("Nu exista participantul cautat!");
//                    break;
//                }
//                System.out.println(guestList.findGuestInWaitingList(guest1));
//                System.out.println(guestList.findGuestInParticipantsList(guest1));
                guestList.checkName(s1, s2);
                break;

            case "B":
                System.out.println("Enter e-mail: ");
                s1 = sc.next();
                Guest guest2 = new Guest(s1);
//                if (guestList.findGuestInWaitingList(guest2) == null && guestList.findGuestInParticipantsList(guest2) == null) {
//                    System.out.println("Nu exista participantul cautat!");
//                    break;
//                }
//                System.out.println(guestList.findGuestInParticipantsList(guest2));
//                System.out.println(guestList.findGuestInWaitingList(guest2));
                guestList.checkEmail(s1);
                break;

            case "C":
                System.out.println("Enter phone number: ");
                s1 = sc.next();
//                Guest guest3 = new Guest(s1);
//                if (guestList.findGuestInWaitingList(guest3) == null && guestList.findGuestInParticipantsList(guest3) == null) {
//                    System.out.println("Nu exista participantul cautat!");
//                    break;
//                }
//                System.out.println(guestList.findGuestInParticipantsList(guest3));  // guestList.checkPhoneNumber(s1);
//                System.out.println(guestList.findGuestInWaitingList(guest3));
                guestList.checkPhoneNumber(s1);
                break;

            default:
                System.out.println("Optiune invalida!");
                break;
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the new Registration Management System! ");
        String chosedOption = newCommand();

        while (!chosedOption.equals("quit")) {

            switch (chosedOption) {
                case "help":
                    displayCommandsOptions();
                    break;

                case "add":
                    addGuest();
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

        sc.close();
    }

}
