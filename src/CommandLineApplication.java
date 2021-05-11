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

    public static void main(String[] args) throws IOException{
        DisplayAll();
        AddContact();
        DisplayAll();
//        // ULTIMATE PATH TO CONTACTS.TXT & CHECK FOR FILE EXISTENCE
//        Path filePathtoContacts = Paths.get("./src/ContactBooks/contacts.txt");
//        System.out.println("Files.exists(filePathtoContacts) = " + Files.exists(filePathtoContacts));
//
//        // PATH AS A STRING TO DIRECTORY AND THE FILE ITSELF
//        String PathToContactsDirectory = "./src/ContactBooks";
//        String Contacts = "contacts.txt";
//
//        // PATHS USING STRING PATH
//        Path contactDirectory = Paths.get(PathToContactsDirectory);
//        Path contactFile = Paths.get(PathToContactsDirectory, Contacts);
//
//        // CHECKING TO SEE FOR FILE EXISTENCE & CREATING THE FILE OR DIRECTORY IF IT DOES NOT EXIST
//        if(Files.notExists(contactDirectory)){
//            Files.createDirectories(contactDirectory);
//        }
//
//        if(Files.notExists(contactFile)){
//            Files.createFile(contactFile);
//        }
//
//        // PATH TO CONTACTS.TXT
//        Path contactListPath = Paths.get(PathToContactsDirectory,Contacts);
//
//        // INITIAL TESTING ENTRIES AS A LIST
//        List<String> contactsEntry = Arrays.asList("Alex Thoms | 2108576954", "Salim Khan | 3158791229");
//
//        // WRITING THE ENTRIES TO THE FILE
//        Files.write(contactListPath, contactsEntry);
//        System.out.println();
//
//        // REOPEN AND READ OVERWRITTEN FILE WITH ENTRIES
//        List<String> contactsList = Files.readAllLines(contactListPath);
//
//        // PRINTING THE NEW FILE ENTRIES TO THE COMMAND LINE
//        for (int i = 0; i < contactsList.size(); i += 1) {
//            System.out.println((i + 1) + ": " + contactsList.get(i));
//        }
    }
    // METHOD TO OUTPUT MENU
    public static void menu(){
        System.out.println("1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
    }

    // USER INPUT
    public static int UserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an option 1-5");
        int input = scanner.nextInt();
        return input;
    }

    // METHOD FOR USER CHOICE
    public static void UserPath(int userChoice) throws IOException{
        switch (userChoice){
            case 1:
                //method to display all
                DisplayAll();
            case 2:
                // method to add new contact
                AddContact();
            case 3:
                //search and display contact by name
            case 4:
                // method to delete existing contact
            case 5:
                // exit the program
                System.out.println("Exiting Meow, Bark Bark!");

                default:
                    System.out.println("Incorrect input please enter 1-5");
                    UserPath(UserInput());
        }
    }

    // DISPLAY ALL METHOD
    public static void DisplayAll() throws IOException{
        Path contactListPath = Paths.get(PathToContactsDirectory,Contacts);
            List<String> contactsList = Files.readAllLines(contactListPath);
            for (int i = 0; i < contactsList.size(); i += 1) {
                System.out.println((i + 1) + ": " + contactsList.get(i));
        }
    }

    // ADD A NEW CONTACT
    public static void AddContact() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter contact information as FirstName LastName 1234567890");
        String name = scanner.next() + scanner.next();
        String number = scanner.next();
        String contact = name + " | " + number;
        Path contactListPath = Paths.get(PathToContactsDirectory,Contacts);
        Files.write(contactListPath,Arrays.asList(contact),StandardOpenOption.APPEND);
    }


}


/* THINGS TO DO
    CREATE A METHOD THAT WILL OUTPUT OUT MENU
    CREATE A METHOD THAT WILL TAKE INPUT FROM THE USER
    METHODS OF ACCESSING/CHANGING THE FILE BASED ON THE INPUT
    ADJUST METHOD TO PRINT ACCORDINGLY

*/

//        do {
//        System.out.println("What number would you like to go up to?");
//        int userInt = scanner.nextInt();
//        System.out.println();
//        System.out.println("Here is your table!");
//        System.out.println();
//        System.out.println("number | squared | cubed");
//        System.out.println("------ | ------- | -----");
//        for (int i = 1; i <= userInt; i++) {
//        //Print out the table;
//        System.out.printf("%-6d | %-7d | %d\n", i, i * i, i * i * i);
//        }
//        System.out.println("Do you want to continue?");
//        String userResponse = scanner.next();
//        if (!userResponse.equalsIgnoreCase("y")) {
//        userContinue = false;
//        }
//        } while (userContinue);
//        }}
