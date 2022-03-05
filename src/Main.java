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


    public static void remove() {
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
                Guest guest = new Guest(s1, s2, "", "");
                if (!guestList.checkName(s1, s2)) {
                    System.out.println("Nu exista participantul cautat");
                    break;
                }
                guestList.remove(guest);
                break;

            case "B":
                System.out.println("Introduceti e-mailul: ");
                s1 = sc.next();
                Guest guest1 = new Guest("", "", s1, "");
                if (!guestList.checkEmail(s1)) {
                    System.out.println("Nu exista participantul cautat!");
                    break;
                }
                guestList.remove(guest1);
                break;
            case "C":
                System.out.println("Introduceti numarul de telefon: ");
                s1 = sc.next();
                Guest guest2 = new Guest("", "", "", s1);
                if (!guestList.checkPhoneNumber(s1)) {
                    System.out.println("Nu exista participantul!");
                    break;
                }
                guestList.remove(guest2);
                break;

            default:
                System.out.println("Comanda introdusa este invalida!");
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
                    System.out.println("Adauga o noua persoana (inscriere): ");
                    addGuest();
                    break;

                case "check":
                    System.out.println("Verifica daca o persoana este inscrisa la eveniment: ");


                    break;

                case "remove":
                    remove();
                    break;

                case "update":
                    System.out.println("Actualizeaza detaliile unei persoane: ");

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
