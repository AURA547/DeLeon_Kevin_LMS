import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        // Code for reading from a file and adding books goes here...

        while (true) {
            System.out.println("1. Print Library");
            System.out.println("2. Remove Book by Barcode");
            System.out.println("3. Remove Book by Title");
            System.out.println("4. Check Out Book");
            System.out.println("5. Check In Book");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1 -> {
                    System.out.println("Library Contents:");
                    library.printLibrary();
                }
                case 2 -> {
                    System.out.print("Enter the barcode to remove: ");
                    int barcode = scanner.nextInt();
                    library.removeBookByBarcode(barcode);
                    System.out.println("Book removed.");
                }
                case 3 -> {
                    System.out.print("Enter the title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    library.removeBookByTitle(titleToRemove);
                    System.out.println("Book removed.");
                }
                case 4 -> {
                    System.out.print("Enter the title to check out: ");
                    String titleToCheckOut = scanner.nextLine();
                    library.checkOutBookByTitle(titleToCheckOut);
                    System.out.println("Book checked out.");
                }
                case 5 -> {
                    System.out.print("Enter the title to check in: ");
                    String titleToCheckIn = scanner.nextLine();
                    library.checkInBookByTitle(titleToCheckIn);
                    System.out.println("Book checked in.");
                }
                case 6 -> {
                    System.out.println("Exiting the Library Management System.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
