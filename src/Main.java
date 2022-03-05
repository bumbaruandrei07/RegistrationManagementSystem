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


                if (!guestList.checkName(s1, s2)) {
                    System.out.println("Nu exista participantul cautat in nicio lista!");
                    break;
                }
                guestList.remove(guest1);
                break;

            case "B":
                System.out.println("Introduceti e-mailul: ");
                s1 = sc.next();
                Guest guest2 = new Guest("", "", s1, "");

                if (!guestList.checkEmail(s1)) {
                    System.out.println("Nu exista participantul cautat in nicio lista!");
                    break;
                }
                guestList.remove(guest2);
                break;


            case "C":
                System.out.println("Introduceti numarul de telefon: ");
                s1 = sc.next();
                Guest guest3 = new Guest("", "", "", s1);
                if (!guestList.checkEmail(s1)) {
                    System.out.println("Nu exista participantul cautat in nicio lista!");
                    break;
                }
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
                if (!guestList.checkName(str1,str2)) {
                    System.out.println("Nu exista participantul cautat in nicio lista!");
                    break;
                }

                System.out.println("Enter the option desired to update:  1 (Update First Name) / 2 (Update Last Name) / 3 (update e-mail) / 4 (update Phone Number");
                int options = sc.nextInt();
                System.out.println("Enter new first name: ");
                String str3 = sc.next();
                guest1.updateGuest(guest1,options,str3,"","","");
                System.out.println(guest1);
                break;

            case "B":
                System.out.println("Enter e-mail: ");
                String s4 = sc.next();
                Guest guest2 = new Guest(s4);
                if (guestList.findGuestInWaitingList(guest2) == null && guestList.findGuestInParticipantsList(guest2) == null) {
                    System.out.println("Nu exista participantul cautat!");
                    break;
                }

                System.out.println("Enter the option desired to update:  A (Update First Name) / B (Update Last Name) / C (update e-mail) / D (update Phone Number");
                String options2 = sc.next();
                System.out.println("Enter the new value: ");
                String str5 = sc.next();
                if (options2.equals("A")) {
                    guest2.setFirstName(str5);
                } else if (options2.equals("B")) {
                    guest2.setLastName(str5);
                } else if (options2.equals("C")) {
                    guest2.setEmail(str5);
                } else if (options2.equals("D")) {
                    guest2.setPhoneNumber(str5);
                }
                break;

            case "C":
                String s6 = sc.next();
                Guest guest3 = new Guest(s6);
                if (guestList.findGuestInWaitingList(guest3) == null && guestList.findGuestInParticipantsList(guest3) == null) {
                    System.out.println("Nu exista participantul cautat!");
                    break;
                }

                System.out.println("Enter the option desired to update:  A (Update First Name) / B (Update Last Name) / C (update e-mail) / D (update Phone Number");
                String options3 = sc.next();
                System.out.println("Enter the new value: ");
                String str7 = sc.next();
                if (options3.equals("A")) {
                    guest3.setFirstName(str7);
                } else if (options3.equals("B")) {
                    guest3.setLastName(str7);
                } else if (options3.equals("C")) {
                    guest3.setEmail(str7);
                } else if (options3.equals("D")) {
                    guest3.setPhoneNumber(str7);
                }
                break;


            case "D":
                System.out.println("Enter the option desired to update:  A (Update First Name) / B (Update Last Name) / C (update e-mail) / D (update Phone Number");
                String s8 = sc.next();
                Guest guest4 = new Guest(s8);
                if (guestList.findGuestInWaitingList(guest4) == null && guestList.findGuestInParticipantsList(guest4) == null) {
                    System.out.println("Nu exista participantul cautat!");
                    break;
                }

                System.out.println("Enter the option desired to update:  A (Update First Name) / B (Update Last Name) / C (update e-mail) / D (update Phone Number");
                String options4 = sc.next();
                System.out.println("Enter the new value: ");
                String str9 = sc.next();
                if (options4.equals("A")) {
                    guest4.setFirstName(str9);
                } else if (options4.equals("B")) {
                    guest4.setLastName(str9);
                } else if (options4.equals("C")) {
                    guest4.setEmail(str9);
                } else if (options4.equals("D")) {
                    guest4.setPhoneNumber(str9);
                }
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
                Guest guest1 = new Guest(s1, s2);
                if (guestList.findGuestInWaitingList(guest1) == null && guestList.findGuestInParticipantsList(guest1) == null) {
                    System.out.println("Nu exista participantul cautat!");
                    break;
                }
                System.out.println(guestList.findGuestInWaitingList(guest1));
                System.out.println(guestList.findGuestInParticipantsList(guest1));//  guestList.checkName(s1, s2);
                break;

            case "B":
                System.out.println("Enter e-mail: ");
                s1 = sc.next();
                Guest guest2 = new Guest(s1);
                if (guestList.findGuestInWaitingList(guest2) == null && guestList.findGuestInParticipantsList(guest2) == null) {
                    System.out.println("Nu exista participantul cautat!");
                    break;
                }
                System.out.println(guestList.findGuestInParticipantsList(guest2));
                System.out.println(guestList.findGuestInWaitingList(guest2)); // guestList.checkEmail(s1);
                break;

            case "C":
                System.out.println("Enter phone number: ");
                s1 = sc.next();
                Guest guest3 = new Guest(s1);
                if (guestList.findGuestInWaitingList(guest3) == null && guestList.findGuestInParticipantsList(guest3) == null) {
                    System.out.println("Nu exista participantul cautat!");
                    break;
                }
                System.out.println(guestList.findGuestInParticipantsList(guest3));  // guestList.checkPhoneNumber(s1);
                System.out.println(guestList.findGuestInWaitingList(guest3));
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
