import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // create a sample DB of two ChildRecords to view
        ChildRecord child1 = new ChildRecord("John Smith", "1st Grade", "96%", true);
        ChildRecord child2 = new ChildRecord("Jane Doe", "2nd Grade", "98%", true);

        // link the two sample ChildRecords to a sample parent
        List<ChildRecord> parentChildren = new ArrayList<>();
        parentChildren.add(child1);
        parentChildren.add(child2);

        // program loop
        while (true) {
            // print a menu of options
            System.out.println("\n-- Welcome to the Buzzing Bees Parent Portal! --");
            System.out.println("1. Login to view child records");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            // ask user for choice and check if its valid
            String menuChoice = scanner.nextLine();
            if (menuChoice.equals("1")) {
                System.out.println("Going to log in page");
            } else if (menuChoice.equals("2")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            } else {
                continue;   
            }

            // ask user to enter username and password
            System.out.print("Enter username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Enter password: ");
            String password = scanner.nextLine().trim();

            // check if user log in is valid then let them choose a record to view
            // sample username: parent1
            // sample password: 123
            if (username.equals("parent1")&&password.equals("123")) {
                // check if no record exists then log out
                if (parentChildren.isEmpty()) {
                    System.out.println("No child records found. Please contact the office for assitance");
                    continue;
                }

                // if a record exists create a loop to view records multiple times
                ChildRecord selected;

                while(true) {
                    // if the parent has more than one child, select child
                    if (parentChildren.size() > 1) {
                        System.out.println("Select a child to view:");
                        
                        for (int i = 0; i < parentChildren.size(); i++) {
                            System.out.println((i + 1) + ". " + parentChildren.get(i).getName());
                        }

                        System.out.print("Enter record number: ");

                        int choice;

                        // check that the user entered an integer
                        try {
                            choice = Integer.parseInt(scanner.nextLine());

                            // check if the choice is a valid record
                            if (choice < 1 || choice > parentChildren.size()) {
                                System.out.println("Invalid selection. Please try again.");
                                continue;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid selection. Please try again.");
                            continue;
                        }

                        selected = parentChildren.get(choice - 1);
                    } else {
                        selected = parentChildren.get(0);
                    }

                    // check if the student record is active
                    if (!selected.isActive()) {
                        System.out.println("Record unavailable. Please contact the office.");
                        continue;
                    }

                    // display child record
                    selected.printChildRecord();

                    System.out.println("View another record? (y to view, anything else to close)");
                    String viewAgain = scanner.nextLine();

                    if (!viewAgain.equals("y")) {
                        break;
                    }
                }
            }

            // return to log in portal option
            System.out.println("Press Enter to return to the login portal...");
            scanner.nextLine();
        }
    }
}