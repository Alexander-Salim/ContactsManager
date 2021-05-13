import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

import static java.lang.Integer.parseInt;

// try to allow option for edit on menu and on duplicate add attempt and on search
// make phone number private
// make person class and contact class that extends it w/ number
// use hash map for more intuitive control and use of knowledge
public class CommandLineApplication {
    public static boolean whileCheck = true;

    public static void main(String[] args) throws IOException {
        while (whileCheck) {
            FileCheck.pathCreation();
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
        return scanner.nextInt();
    }

    // METHOD FOR USER CHOICE
    public static void UserPath(int userChoice) throws IOException {
        switch (userChoice) {
            case 1:
                //method to display all
                ContactActions.DisplayAll();
                break;
            case 2:
                // method to add new contact
                ContactActions.AddContact();
                break;
            case 3:
                //search and display contact by name
                ContactActions.searchContact();
                break;
            case 4:
                // method to delete existing contact
                ContactActions.DeleteContact();
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

}


