import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Checks {

    // METHOD FOR NUMBER FORMAT AND LENGTH CHECK
    // METHOD FOR NUMBERLENGTH CHECK;
    public static boolean phoneNumberLength(int phoneNumber){
        String num = String.valueOf(phoneNumber);
        if (num.length() > 13){
            return false;
        }
        else if (num.length() < 10){
            return false;
        }
            return true;
    }

    // METHOD FOR FORMATTING PHONE NUMBER BASED ON LENGTH
    public static String phoneNumberFormatter(int phoneNumber){
        String numberToString = String.valueOf(phoneNumber);
        String formattedNumber = new String();
        switch (numberToString.length()){
            case 10:
                formattedNumber = numberToString.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
                break;
            case 11:
                formattedNumber = numberToString.replaceFirst("(\\d)(\\d{3})(\\d{3})(\\d+)", "+$1($2)$3-$4");
                break;
            case 12:
                formattedNumber = numberToString.replaceFirst("(\\d{2})(\\d{3})(\\d{3})(\\d+)", "+$1-$2-$3-$4");
                break;
            case 13:
                formattedNumber = numberToString.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d+)", "+$1-$2-$3-$4");
                break;
        }
        return formattedNumber;
    }
    // METHOD FOR CONTACT PRESENCE CHECK

    // METHOD FOR NAME PRESENCE
    public static boolean contactPresence(String name) throws IOException {
        boolean nameFound = false;
        Path contactListPath = Paths.get(FileCheck.PathToContactsDirectory, FileCheck.Contacts);
        List<String> contactList = Files.readAllLines(contactListPath);
        for (String contact : contactList) {
            if (contact.contains(name)) {
                nameFound = true;
                String[] fullContact = contact.split(":");
                System.out.printf("This contact already exists with a number of: %s", fullContact[1]);
            }
        }
        return nameFound;
    }

    public static boolean overwrite() {
        System.out.println("Would you like to edit the number? [y/n]");
        Scanner scanner = new Scanner(System.in);
        String Input = scanner.nextLine();
        return Input.contains("y");
    }


}
