public class Book {
    private final int barcode;
    private final String title;
    private final String author;
    private boolean isCheckedOut;

    public Book(int barcode, String title, String author) {
        this.barcode = barcode;
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    public int getBarcode() {
        return barcode;
    }

    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
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
        return barcode + "," + title + "," + author + (isCheckedOut ? " (Checked Out)" : "");
    }
}
