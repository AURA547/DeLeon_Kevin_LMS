import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book(1, "Test Book 1", "Test Author 1");
        book2 = new Book(2, "Test Book 2", "Test Author 2");
    }

    @Test
    public void testAddBook() {
        library.addBook(book1);
        assertTrue(library.getBooks().contains(book1));
    }

    @Test
    public void testRemoveBookByBarcode() {
        library.addBook(book1);
        library.addBook(book2);

        library.removeBookByBarcode(1);
        assertFalse(library.getBooks().contains(book1));
    }

    @Test
    public void testRemoveBookByTitle() {
        library.addBook(book1);
        library.addBook(book2);

        library.removeBookByTitle("Test Book 1");
        assertFalse(library.getBooks().contains(book1));
    }

    @Test
    public void testCheckOutBookByTitle() {
        library.addBook(book1);
        library.addBook(book2);

        library.checkOutBookByTitle("Test Book 1");
        assertTrue(book1.isCheckedOut());
        assertFalse(book2.isCheckedOut());
    }

    @Test
    public void testCheckInBookByTitle() {
        library.addBook(book1);
        library.addBook(book2);

        library.checkOutBookByTitle("Test Book 1");
        assertTrue(book1.isCheckedOut());

        library.checkInBookByTitle("Test Book 1");
        assertFalse(book1.isCheckedOut());
    }
}
