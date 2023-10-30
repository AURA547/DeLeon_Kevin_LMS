import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LibraryGUI extends JFrame {

    private final Library library;

    public LibraryGUI(Library library) {
        this.library = library;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Library Management System");
        setSize(800, 600);
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
        JButton exitButton = new JButton("Exit");

        panel.add(openFileButton);
        panel.add(printLibraryButton);
        panel.add(removeBarcodeButton);
        panel.add(removeTitleButton);
        panel.add(checkOutButton);
        panel.add(checkInButton);
        panel.add(exitButton);

        // Action listeners for buttons
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Your code to open a file and add books to the library goes here...
            }
        });

        printLibraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collection<Book> books = library.getBooks();
                textArea.setText(""); // Clear the text area
                for (Object book : books) {
                    textArea.append(book.toString() + "\n");
                }
            }
        });

        removeBarcodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter barcode to remove:");
                int barcode = Integer.parseInt(input);
                library.removeBookByBarcode(barcode);
                textArea.setText("Book removed.");
            }
        });

        removeTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titleToRemove = JOptionPane.showInputDialog("Enter title to remove:");
                library.removeBookByTitle(titleToRemove);
                textArea.setText("Book removed.");
            }
        });

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titleToCheckOut = JOptionPane.showInputDialog("Enter title to check out:");
                library.checkOutBookByTitle(titleToCheckOut);
                textArea.setText("Book checked out.");
            }
        });

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titleToCheckIn = JOptionPane.showInputDialog("Enter title to check in:");
                library.checkInBookByTitle(titleToCheckIn);
                textArea.setText("Book checked in.");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Do you want to exit the program?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Library library = new Library();
            LibraryGUI libraryGUI = new LibraryGUI(library);
            libraryGUI.setVisible(true);
        });
    }
}
