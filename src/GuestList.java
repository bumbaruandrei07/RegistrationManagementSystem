import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GuestList implements Serializable {

    //fields
    private final int availablePlaces;
    private ArrayList<Guest> participantsList;
    private ArrayList<Guest> waitingList;
    private static final long serialVersionUID = 1L;

    //constructor using all fields
    public GuestList(int availablePlaces) {
        this.availablePlaces = availablePlaces;
        this.participantsList = new ArrayList<>(availablePlaces);
        this.waitingList = new ArrayList<>();
    }

    //add a new guest method used in main (entry-point of our app)
    public int addParticipant(Guest guest) {
        if (isRegistered(guest)) {
            System.out.println("This user is already registered");
            return -1;
        }

        if (participantsList.size() < availablePlaces) {
            participantsList.add(guest);
            System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
            return 0;
        } else {
            waitingList.add(guest);
            System.out.println("Te-ai inscris cu succes in lista de asteptare " +
                    "si ai primit numarul de ordine " + waitingList.size() + ". Te vom notifica daca un loc devine disponibil.");
            return waitingList.size();
        }
    }


    //remove a guest method used in main
    public boolean remove(Guest guest) {
        for (int i = 0; i < participantsList.size(); i++) {
            if (guest.equals(participantsList.get(i))) {
                participantsList.remove(i);
            }

            //if there is someone on waiting list
            if (waitingList.size() > 0) {

                //if on participants list there is an available place
                if (participantsList.size() < availablePlaces) {

                    //add 1st person on waiting list to participants list if there is an available place on the participants list
                    participantsList.add(waitingList.get(0));
                    //removing the first guest from the waiting list
                    waitingList.remove(0);
                    System.out.println("Person has been successfully removed");
                    return true;
                }
            }
        }

        for (int i = 0; i < waitingList.size(); i++) {
            if (guest.equals(waitingList.get(i))) {
                waitingList.remove(i);
                System.out.println("Person has been successfully removed");
                return true;
            }
        }
        System.out.println("ERROR : this guest is not registered!");
        return false;
    }

    //update method used in main
    public Guest updateHelper(String s1, String s2, String s3, String s4) {
        for (int i = 0; i < participantsList.size(); i++) {
            if ((participantsList.get(i).getFirstName().equalsIgnoreCase(s1)) &&
                    (participantsList.get(i).getLastName().equalsIgnoreCase(s2)) ||
                    (participantsList.get(i).getEmail().equalsIgnoreCase(s3)) ||
                    (participantsList.get(i).getPhoneNumber().equalsIgnoreCase(s4))) {
                return participantsList.get(i);
            }
        }

        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).getFirstName().equalsIgnoreCase(s1) &&
                    (waitingList.get(i).getLastName().equalsIgnoreCase(s2)) ||
                    (waitingList.get(i).getEmail().equalsIgnoreCase(s3)) ||
                    (waitingList.get(i).getPhoneNumber().equalsIgnoreCase(s4))) {
                return waitingList.get(i);
            }
        }
        return null;
    }

    //helper method used in remove()
    public boolean isRegistered(Guest guest) {
        if (waitingList.size() == 0) {
            return false;
        }
        for (int i = 0; i < waitingList.size(); i++) {
            if (((waitingList.get(i).getFirstName().equalsIgnoreCase(guest.getFirstName()))) &&
                    (waitingList.get(i).getLastName().equalsIgnoreCase(guest.getLastName())) ||
                    (waitingList.get(i).getEmail().equalsIgnoreCase(guest.getEmail())) ||
                    (waitingList.get(i).getPhoneNumber().equalsIgnoreCase(guest.getPhoneNumber()))) {
                return true;
            }
        }

        if (participantsList.size() == 0) {
            return false;
        }
        for (int i = 0; i < participantsList.size(); i++) {
            if (((participantsList.get(i).getFirstName().equalsIgnoreCase(guest.getFirstName()))) &&
                    (participantsList.get(i).getLastName().equalsIgnoreCase(guest.getLastName())) ||
                    (participantsList.get(i).getEmail().equalsIgnoreCase(guest.getEmail())) ||
                    (participantsList.get(i).getPhoneNumber().equalsIgnoreCase(guest.getPhoneNumber()))) {
                return true;
            }
        }
        return false;
    }


    // searching method 1
    public boolean checkName(String str1, String str2) {
        for (int i = 0; i < participantsList.size(); i++) {
            if ((participantsList.get(i).getFirstName().equalsIgnoreCase(str1)) &&
                    (participantsList.get(i).getLastName().equalsIgnoreCase(str2))) {
                if (i < this.availablePlaces) {
                    System.out.println("Persoana este in lista de participanti!");
                }
                return true;
            }
        }
        for (int i = 0; i < waitingList.size(); i++) {
            if ((waitingList.get(i).getFirstName().equalsIgnoreCase(str1)) &&
                    waitingList.get(i).getLastName().equalsIgnoreCase(str2)) {
                System.out.println("Persoana este in lista de asteptare");
                return true;
            }
        }
        System.out.println("Persoana nu se afla pe nicio lista!");
        return false;
    }

    // searching method 2
    public boolean checkEmail(String str) {
        for (int i = 0; i < participantsList.size(); i++) {
            if (participantsList.get(i).getEmail().equalsIgnoreCase(str)) {
                if (i < this.availablePlaces) {
                    System.out.println("Persoana este in lista de participanti!");
                    return true;
                }
            }
        }
        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).getEmail().equalsIgnoreCase(str)) {
                System.out.println("Persoana este in lista de asteptare!");
                return true;
            }
        }
        System.out.println("Persoana nu se afla pe nicio lista!");
        return false;
    }


    // searching method 3
    public boolean checkPhoneNumber(String str) {
        for (int i = 0; i < participantsList.size(); i++) {
            if (participantsList.get(i).getPhoneNumber().equalsIgnoreCase(str)) {
                if (i < this.availablePlaces) {
                    System.out.println("Persoana este in lista de participanti!");
                }
                return true;
            }
        }
        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).getPhoneNumber().equalsIgnoreCase(str)) {
                System.out.println("Persoana este in lista de asteptare!");
                return true;
            }
        }
        System.out.println("Persoana nu se afla pe nicio lista!");
        return false;
    }


    //Getters
    public ArrayList<Guest> getParticipantsList() {

        if (participantsList.size() == 0) {
            System.out.println("The list of participants is empty now...");
        }
        return participantsList;
    }

    public ArrayList<Guest> getWaitingList() {
        if (waitingList.size() == 0) {
            System.out.println("The waiting list is empty now...");
        }
        return waitingList;
    }

    public int getRemainingPlaces() {
        return this.availablePlaces - participantsList.size();
    }


    public int getParticipantsListNumber() {
        return participantsList.size();
    }

    public int getWaitingListNumberOfParticipants() {
        return waitingList.size();
    }


    public int getTotalNumberOfParticipantsOnLists() {
        return participantsList.size() + waitingList.size();
    }

    //partial searching method
    public ArrayList<Guest> partialSearch(String str) {
        ArrayList<Guest> foundGuest = new ArrayList<>();
        for (Guest guest : participantsList) {
            if (guest.getFirstName().toLowerCase().contains(str) ||
                    guest.getLastName().toLowerCase().contains(str) ||
                    guest.getEmail().toLowerCase().contains(str) ||
                    guest.getPhoneNumber().toLowerCase().contains(str)) {
                foundGuest.add(guest);
            }
        }

        for (Guest guest : waitingList) {
            if (guest.getFirstName().toLowerCase().contains(str) ||
                    guest.getLastName().toLowerCase().contains(str) ||
                    guest.getEmail().toLowerCase().contains(str) ||
                    guest.getPhoneNumber().toLowerCase().contains(str)) {
                foundGuest.add(guest);
            }
        }
        System.out.println(foundGuest);
        return foundGuest;
    }

    public static void writeToBinaryFile(GuestList guest) throws IOException {
        try (ObjectOutputStream binaryFileOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("guests.dat")))) {
            binaryFileOut.writeObject(guest);
        }
    }

    public static GuestList readFromBinaryFile() throws IOException {

        GuestList guests = null;
        try (ObjectInputStream binaryFileIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("guests.dat")))) {
            guests = (GuestList) binaryFileIn.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("A class not found exception: " + e.getMessage());
        }
        return guests;
    }

    public void resetGuestList() {
        try {
            File file = new File("guests.dat");
            file.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Reset done!");
    }
}
