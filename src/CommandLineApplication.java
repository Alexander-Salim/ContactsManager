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

    }
}

