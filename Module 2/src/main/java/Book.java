public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isCheckedOut;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void checkOut() {
        isCheckedOut = true;
    }

    public void checkIn() {
        isCheckedOut = false;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + author + (isCheckedOut ? " (Checked Out)" : "");
    }
}
