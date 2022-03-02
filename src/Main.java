import java.util.Scanner;

public class Main {


    private static final Scanner sc = new Scanner(System.in);

    private static String newCommand() {
        System.out.println("\n Enter a new command:  ");
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

    public static void main(String[] args) {
        System.out.println("Welcome to the new Registration Management System :) ");
        String chosedOption = newCommand();
        boolean appIsOn = true;

        while (appIsOn) {
            switch (chosedOption) {
                case "help":
                    displayCommandsOptions();

                    break;

                case "add":
                    System.out.println("Adauga o noua persoana (inscriere): ");


                    break;

                case "check":
                    System.out.println("Verifica daca o persoana este inscrisa la eveniment: ");


                    break;

                case "remove":
                    System.out.println("Sterge o persoana existenta din lista: ");


                    break;

                case "update":
                    System.out.println("Actualizeaza detaliile unei persoane: ");


                    break;

                case "guests":
                    System.out.println("Lista de persoane care participa la eveniment: ");


                    break;

                case "waitList":
                    System.out.println("Persoanele din lista de asteptare: ");


                    break;

                case "available":
                    System.out.println("Numarul de locuri libere: ");


                    break;

                case "guests_no":
                    System.out.println("Numarul de persoane care participa la eveniment: ");


                    break;

                case "waitlist_no":
                    System.out.println("Numarul de persoane din lista de asteptare: ");


                    break;

                case "subscribe_no":
                    System.out.println("Numarul total de persoane inscrise: ");


                    break;

                case "search":
                    System.out.println("Cauta toti invitatii conform sirului de caractere introdus: ");

                    break;

                case "quit":
                    System.out.println("Inchide aplicatia.");
                    break;

                default:
                    System.out.println("Comanda introdusa nu exista!");
                    break;
            }

            newCommand();
        }

        sc.close();
    }


}
