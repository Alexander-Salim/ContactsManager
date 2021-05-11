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
    public static void main(String[] args) throws IOException{
        Path filePathtoContacts = Paths.get("./CommandLineApplication/src/ContactBooks/contacts.txt"); //relative path CWD [root] > up through the file chain

//        Path sameDirectoryPath = Paths.get("../contacts.txt");

        //Let's print out these filePaths!
        System.out.println("filePathtoContacts = " + filePathtoContacts); //value of Path object? = what we had set / passed as a parameter!

        System.out.println("Files.exists(filePathtoContacts) = " + Files.exists(filePathtoContacts));
        String PathToContactsDirectory = "./CommandLineApplication/src/ContactBooks";
        String Contacts = "contacts.txt";

//        System.out.println("Files.exists(sameDirectoryPath) = " + Files.exists(sameDirectoryPath));
        Path contactDirectory = Paths.get(PathToContactsDirectory);
        Path contactFile = Paths.get(PathToContactsDirectory, Contacts);

//        System.out.println("dataFile = " + dataFile);

        if(Files.notExists(contactDirectory)){//IF T: got down path and directory not there!

            Files.createDirectories(contactDirectory); //go ahead and create a directory on this path :)

        }

        if(Files.notExists(contactFile)){//IF T: got down path and file not found in directory~

            Files.createFile(contactFile);
        }
        Path contactListPath = Paths.get(PathToContactsDirectory,Contacts);

        System.out.println("contactListPath = " + contactListPath); //path to the groceriesList.txt

        List<String> contactsEntry = Arrays.asList("Alex Thoms | 2108576954", "Salim Khan | 3158791229"); //Making the list!
        System.out.println("contactsEntry = " + contactsEntry); //Voila! There it is! The list to write!

        Files.write(contactListPath, contactsEntry); //Oh, did we write successfully? Go check groceriesList.txt!

        //second idea: Let's print our list of groceries as it stands!
        System.out.println();

        List<String> contactsList = Files.readAllLines(contactListPath);

        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactsList.get(i));
        }
    }
}

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
