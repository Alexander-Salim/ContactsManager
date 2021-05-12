import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CommandLineApplication {
    // PATH AS A STRING TO DIRECTORY AND THE FILE ITSELF
    public static String PathToContactsDirectory = "./src/ContactBooks";
    public static String Contacts = "contacts.txt";
    public static boolean whileCheck = true;

    public static void main(String[] args) throws IOException {
        while(whileCheck) {
            pathCreation();
            menu();
            System.out.println();
            UserPath(UserInput());
        }

    }

    // METHOD TO OUTPUT MENU
    public static void menu() {
        System.out.println("1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
    }

    // USER INPUT
    public static int UserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an option 1-5");
        int input = scanner.nextInt();
        return input;
    }

    // METHOD FOR USER CHOICE
    public static void UserPath(int userChoice) throws IOException {
        switch (userChoice) {
            case 1:
                //method to display all
                DisplayAll();
                break;
            case 2:
                // method to add new contact
                AddContact();
                break;
            case 3:
                //search and display contact by name
                searchContact();
                break;
            case 4:
                // method to delete existing contact
                DeleteContact();
                break;
            case 5:
                // exit the program
                whileCheck = false;
                System.out.println("Exiting Meow, Bark Bark!");
                break;
            default:
                System.out.println("Incorrect input please enter 1-5");
                UserPath(UserInput());
        }
    }

    // DISPLAY ALL METHOD
    public static void DisplayAll() throws IOException {
        Path contactListPath = Paths.get(PathToContactsDirectory, Contacts);
        List<String> contactsList = Files.readAllLines(contactListPath);
        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println(contactsList.get(i));
        }
    }

    // ADD A NEW CONTACT
    public static void AddContact() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter contact information as FirstName LastName 1234567890");
        String name = scanner.next() + " " + scanner.next();
        String number = scanner.next();
        String contact = name + ":" + number;
        Path contactListPath = Paths.get(PathToContactsDirectory, Contacts);
        Files.write(contactListPath, Arrays.asList(contact), StandardOpenOption.APPEND);
    }


    // Search and display contact by name
    public static void searchContact() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search contact information by name: ");
        String name = scanner.nextLine();
        boolean nameFound = false;
        Path contactListPath = Paths.get(PathToContactsDirectory, Contacts);
        List<String> contactList = Files.readAllLines(contactListPath);
        for (String contact : contactList) {
            if (contact.contains(name)) {
                name = contact;
                nameFound = true;
                break;
            }
        }
        if (nameFound) {
            System.out.println(name);

        } else {

            System.out.println("Sorry Contact not found");
        }
    }

    public static void DeleteContact() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Delete existing contact");
        String name = scanner.nextLine();
        Path contactListPath = Paths.get(PathToContactsDirectory, Contacts);
        List<String> contactList = Files.readAllLines(contactListPath);
        List<String> updatedContactList = new ArrayList<>();
        for (String contact : contactList) {
            if (contact.contains(name)) {
                continue;
            } else {
                updatedContactList.add(contact);

            }
        }
        Files.write(contactListPath, updatedContactList);
        DisplayAll();
    }

    public static boolean YesNo () {
        System.out.println("continue? [y/n]");
        Scanner scanner = new Scanner(System.in);
        String Input = scanner.nextLine();
        return Input.contains("y");

    }

    // METHOD FOR CHECKING FILE PATH EXISTANCE AND CREATING IF IT DOES NOT
    public static void pathCreation() throws IOException {
//         ULTIMATE PATH TO CONTACTS.TXT & CHECK FOR FILE EXISTENCE
        Path filePathtoContacts = Paths.get("./src/ContactBooks/contacts.txt");

        // PATH AS A STRING TO DIRECTORY AND THE FILE ITSELF
        String PathToContactsDirectory = "./src/ContactBooks";
        String Contacts = "contacts.txt";

        // PATHS USING STRING PATH
        Path contactDirectory = Paths.get(PathToContactsDirectory);
        Path contactFile = Paths.get(PathToContactsDirectory, Contacts);

        // CHECKING TO SEE FOR FILE EXISTENCE & CREATING THE FILE OR DIRECTORY IF IT DOES NOT EXIST
        if(Files.notExists(contactDirectory)){
            Files.createDirectories(contactDirectory);
        }

        if(Files.notExists(contactFile)){
            Files.createFile(contactFile);
        }
    }
}
