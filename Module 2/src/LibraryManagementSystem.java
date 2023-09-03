import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Book class represents a book with an ID, title, and author.
 */
record Book(int id, String title, String author) {

    // Getters and setters for the Book class

    @Override
    public String toString() {
        return id + "," + title + "," + author;
    }
}

/**
 * The Library class manages a collection of books.
 */
class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Add a book to the library.
     *
     * @param book The book to add.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Remove a book from the library by ID.
     *
     * @param id The ID of the book to remove.
     */
    public void removeBook(int id) {
        books.removeIf(book -> book.id() == id);
    }

    /**
     * Get a list of all books in the library.
     *
     * @return The list of books.
     */
    public List<Book> getAllBooks() {
        return books;
    }
}

/**
 * The LibraryManagementSystem class contains the main application logic.
 */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Your LMS code starts here
        System.out.println("Welcome to the Library Management System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. List All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(id, title, author);
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                }
                case 2 -> {
                    System.out.print("Enter book ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    library.removeBook(removeId);
                    System.out.println("Book removed successfully.");
                }
                case 3 -> {
                    List<Book> allBooks = library.getAllBooks();
                    System.out.println("List of Books:");
                    for (Book book : allBooks) {
                        System.out.println(book.id() + ": " + book.title() + " by " + book.author());
                    }
                }
                case 4 -> {
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}