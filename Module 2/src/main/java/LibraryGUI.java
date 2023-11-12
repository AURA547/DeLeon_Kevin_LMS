import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class LibraryGUI extends JFrame {

    private final Library library;

    public LibraryGUI(Library library) {
        this.library = library;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Library Management System");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold all components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        getContentPane().add(panel);

        // Create a text area to display the library contents
        JTextArea textArea = new JTextArea(20, 60);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        // Create buttons for actions
        JButton openFileButton = new JButton("Open File");
        JButton printLibraryButton = new JButton("Print Library");
        JButton removeBarcodeButton = new JButton("Remove Book by Barcode");
        JButton removeTitleButton = new JButton("Remove Book by Title");
        JButton checkOutButton = new JButton("Check Out Book");
        JButton checkInButton = new JButton("Check In Book");
        JButton addBookButton = new JButton("Add Book to Database");
        JButton exitButton = new JButton("Exit");

        panel.add(openFileButton);
        panel.add(printLibraryButton);
        panel.add(removeBarcodeButton);
        panel.add(removeTitleButton);
        panel.add(checkOutButton);
        panel.add(checkInButton);
        panel.add(addBookButton);
        panel.add(exitButton);

        // Action listeners for buttons
        openFileButton.addActionListener(e -> {
            // Your code to open a file and add books to the library goes here...
        });

        printLibraryButton.addActionListener(e -> {
            Collection<Book> books = library.getBooks();
            textArea.setText(""); // Clear the text area
            for (Object book : books) {
                textArea.append(book.toString() + "\n");
            }
        });

        removeBarcodeButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter barcode to remove:");
            int barcode = Integer.parseInt(input);
            library.removeBookByBarcode(barcode);
            textArea.setText("Book removed.");
        });

        removeTitleButton.addActionListener(e -> {
            String titleToRemove = JOptionPane.showInputDialog("Enter title to remove:");
            library.removeBookByTitle(titleToRemove);
            textArea.setText("Book removed.");
        });

        checkOutButton.addActionListener(e -> {
            String titleToCheckOut = JOptionPane.showInputDialog("Enter title to check out:");
            library.checkOutBookByTitle(titleToCheckOut);
            textArea.setText("Book checked out.");
        });

        checkInButton.addActionListener(e -> {
            String titleToCheckIn = JOptionPane.showInputDialog("Enter title to check in:");
            library.checkInBookByTitle(titleToCheckIn);
            textArea.setText("Book checked in.");
        });

        addBookButton.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Enter book title:");
            String author = JOptionPane.showInputDialog("Enter book author:");
            String genre = JOptionPane.showInputDialog("Enter book genre:");

            // Create a new Book object with the input details
            Book newBook = new Book(0, title, author); // Assuming id is not used for the database

            // Add the new book to the database using the library's method
            addBookToDatabase(newBook, genre);

            textArea.setText("Book added to the database.");
        });

        exitButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(null, "Do you want to exit the program?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

    private void addBookToDatabase(Book book, String genre) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/LMS Project";
        String user = "root";
        String password = "hatsune miku";

        try {
            // Establish a connection
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                // SQL query to insert a new book into the database
                String sql = "INSERT INTO books (title, author, genre, barcode, status, due_date) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    // Set the parameters for the SQL query
                    preparedStatement.setString(1, book.getTitle());
                    preparedStatement.setString(2, book.getAuthor());
                    preparedStatement.setString(3, genre); // Use the provided genre
                    preparedStatement.setInt(4, book.getBarcode()); // Renamed id to barcode
                    preparedStatement.setString(5, "Checked In"); // Initial status
                    preparedStatement.setNull(6, java.sql.Types.NULL); // Initial due_date

                    // Execute the SQL query
                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle the exception appropriately (display an error message, log the error, etc.)
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Library library = new Library();
            LibraryGUI libraryGUI = new LibraryGUI(library);
            libraryGUI.setVisible(true);
        });
    }
}
