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
        while (!chosedOption.equals("quit")) {
            switch (chosedOption) {
                case "help":
                    displayCommandsOptions();
                    newCommand();
                    break;

                case "add":
                    System.out.println("Adauga o noua persoana (inscriere)");

                    newCommand();
                    break;

                case "check":
                    System.out.println("Verifica daca o persoana este inscrisa la eveniment");

                    newCommand();
                    break;
            }


        }


    }

}
