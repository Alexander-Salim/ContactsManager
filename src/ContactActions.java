import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactActions {
    // ADD A NEW CONTACT
    public static void AddContact() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the new contact as FirstName LastName");
        String name = scanner.next() + " " + scanner.next();
//        if (Checks.contactPresence(name)){
//            if (Checks.overwrite()){
//                String[] fullContactInfo = searchContact(name);
//                System.out.println("Enter the new number for" + name);
//
//
//            }
//        }
//        try {
            System.out.println("Enter phone number for the new Contact as 1234567890");
            int number = scanner.nextInt();
            if (Checks.phoneNumberLength(number)){
                String formattedPhoneNumber = Checks.phoneNumberFormatter(number);
                String contact = name + ":" + formattedPhoneNumber;
                Path contactListPath = Paths.get(FileCheck.PathToContactsDirectory, FileCheck.Contacts);
                Files.write(contactListPath, Arrays.asList(contact), StandardOpenOption.APPEND);
            }
//            throw new InputMismatchException();
//        }
//        catch (InputMismatchException e) {
//            System.out.println("Input must be a sequence of digits between 10-13");
//            AddContact();
//        }
    }

    // Search and display contact by name
    public static String[] searchContact(String name) throws IOException {
        Path contactListPath = Paths.get(FileCheck.PathToContactsDirectory, FileCheck.Contacts);
        List<String> contactList = Files.readAllLines(contactListPath);
        String[] contactFound = new String[0];
        for (String contact : contactList) {
            if (contact.contains(name)) {
                contactFound = contact.split(":");
            }
        }
        return contactFound;
    }


    public static void searchContact() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search contact information by name: ");
        String name = scanner.nextLine();
        boolean nameFound = false;
        Path contactListPath = Paths.get(FileCheck.PathToContactsDirectory, FileCheck.Contacts);
        List<String> contactList = Files.readAllLines(contactListPath);
        for (String contact : contactList) {
            if (contact.contains(name.toLowerCase()) || contact.contains(name)) {
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
        Path contactListPath = Paths.get(FileCheck.PathToContactsDirectory, FileCheck.Contacts);
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

    // DISPLAY ALL METHOD
    public static void DisplayAll() throws IOException {
        Path contactListPath = Paths.get(FileCheck.PathToContactsDirectory, FileCheck.Contacts);
        List<String> contactsList = Files.readAllLines(contactListPath);
        for (String contact : contactsList) {
            String[] fullContact = contact.split(":");
            System.out.printf("%-20s | %-11s\n", fullContact[0], fullContact[1]);
        }
    }

    // METHOD FOR EDIT
}
