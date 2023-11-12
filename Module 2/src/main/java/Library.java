import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBookByBarcode(int barcode) {
        books.removeIf(book -> book.getBarcode() == barcode);
    }

    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public void checkOutBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.checkOut();
                break;
            }
        }
    }

    public void checkInBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.checkIn();
                break;
            }
        }
    }

    public void printLibrary() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void insertBook(String title, String author, String genre, int barcode, String status, String dueDate) {
        String url = "jdbc:mysql://localhost:3306";  //
        String username = "root";  //
        String password = "hatsune miku";  //

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO books (title, author, genre, barcode, status, due_date) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, author);
                preparedStatement.setString(3, genre);
                preparedStatement.setInt(4, barcode);
                preparedStatement.setString(5, status);
                preparedStatement.setString(6, dueDate);

                preparedStatement.executeUpdate();
            }
            System.out.println("Book inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting book into the database.");
        }
    }
}
