import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // fake DB
        ChildRecord child1 = new ChildRecord("John Smith", "1st Grade", "96%", true);
        ChildRecord child2 = new ChildRecord("Jane Doe", "2nd Grade", "98%", true);

        // parent with two children
        List<ChildRecord> parentChildren = new ArrayList<>();
        parentChildren.add(child1);
        parentChildren.add(child2);

        // program loop
        while (true) {

            System.out.println("\n Welcome to the Buzzing Bees Parent Portal!");
            System.out.println("1. Login to view child records");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            String menuChoice = scanner.nextLine();

            if (menuChoice.equals("2")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            } else if (!menuChoice.equals("1")) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            // login
            System.out.print("Enter username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Enter password: ");
            String password = scanner.nextLine().trim();

            if (!(username.equals("parent1") && password.equals("123"))) {
                System.out.println("Login failed. Returning to portal menu...");
                continue;  // go back to the menu
            }

            // pre-condition
            if (parentChildren.isEmpty()) {
                System.out.println("No child records found. Please contact the office for assitance");
                continue;
            }

            ChildRecord selected;

            // if the parent has more than one child, select child
            if (parentChildren.size() > 1) {
                System.out.println("Select a child to view:");
                for (int i = 0; i < parentChildren.size(); i++) {
                    System.out.println((i + 1) + ". " + parentChildren.get(i).getName());
                }

                System.out.print("Enter option: ");
                int choice;

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid selection. Please try again.");
                    continue;
                }

                if (choice < 1 || choice > parentChildren.size()) {
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
            System.out.println("\n--- Child Record ---");
            System.out.println("Name: " + selected.getName());
            System.out.println("Grade: " + selected.getGrade());
            System.out.println("Attendance: " + selected.getAttendance());
            System.out.println("(End of record – read only)\n");

            // return to log in portal option
            System.out.println("Press Enter to return to the login portal...");
            scanner.nextLine();
        }
    }
}