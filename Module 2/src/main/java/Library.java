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
        books.removeIf(book -> book.getId() == barcode);
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

    public Collection<Object> getBooks() {
        return null;
    }
}
