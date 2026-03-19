import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class LibraryItem {
    private String title;
    private String author;
    private int publicationYear;
    private boolean checkedOut;

    public LibraryItem(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.checkedOut = false;
    }

    public String getTitle()          { return title; }
    public String getAuthor()         { return author; }
    public int getPublicationYear()   { return publicationYear; }
    public boolean isCheckedOut()     { return checkedOut; }

    public void checkOut() {
        if (checkedOut) System.out.println("\"" + title + "\" is already checked out.");
        else { checkedOut = true; System.out.println("\"" + title + "\" checked out successfully."); }
    }

    public void returnItem() {
        if (!checkedOut) System.out.println("\"" + title + "\" was not checked out.");
        else { checkedOut = false; System.out.println("\"" + title + "\" returned successfully."); }
    }

    public abstract String getItemType();

    @Override
    public String toString() {
        return getItemType() + "[title=\"" + title + "\", author=" + author
                + ", year=" + publicationYear + ", available=" + !checkedOut + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryItem i)) return false;
        return publicationYear == i.publicationYear
                && title.equals(i.title)
                && author.equals(i.author);
    }

    @Override
    public int hashCode() { return Objects.hash(title, author, publicationYear); }
}

class Book extends LibraryItem {
    private int numberOfPages;
    private String genre;
    private String isbn;

    public Book(String title, String author, int publicationYear, int numberOfPages, String genre, String isbn) {
        super(title, author, publicationYear);
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.isbn = isbn;
    }

    public int getNumberOfPages() { return numberOfPages; }
    public String getGenre()      { return genre; }
    public String getIsbn()       { return isbn; }

    public int estimatedReadingHours() { return numberOfPages / 30; }

    @Override
    public String getItemType() { return "Book"; }

    @Override
    public String toString() {
        return super.toString().replace("]",
         ", pages=" + numberOfPages + ", genre=" + genre + ", isbn=" + isbn + "]");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book b)) return false;
        return super.equals(o) && isbn.equals(b.isbn);
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), isbn); }
}

class Library {
    private List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println("Added: " + item.getTitle());
    }

    public void removeItem(LibraryItem item) {
        if (items.remove(item)) System.out.println("Removed: " + item.getTitle());
        else System.out.println("Item not found: " + item.getTitle());
    }

    public LibraryItem findByTitle(String title) {
        return items.stream()
                .filter(i -> i.getTitle().equalsIgnoreCase(title))
                .findFirst().orElse(null);
    }

    public void printAvailable() {
        System.out.println("\nAvailable items: ");
        items.stream().filter(i -> !i.isCheckedOut()).forEach(i -> System.out.println("  " + i));
    }

    public void printAll() {
        System.out.println("\nAll items: ");
        items.forEach(i -> System.out.println("  " + i));
    }
}

public class MainLibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("The Great Gatsby",    "F. Scott Fitzgerald", 1925, 180, "Fiction",    "978-0743273565");
        Book b2 = new Book("1984",                "George Orwell",       1949, 328, "Dystopia",   "978-0451524935");
        Book b3 = new Book("Clean Code",          "Robert C. Martin",    2008, 431, "Technology", "978-0132350884");
        Book b4 = new Book("The Great Gatsby",    "F. Scott Fitzgerald", 1925, 180, "Fiction",    "978-0743273565"); // duplicate

        library.addItem(b1);
        library.addItem(b2);
        library.addItem(b3);

        library.printAll();

        System.out.println("\nCheckout & Return:");
        b1.checkOut();
        b1.checkOut();
        library.printAvailable();
        b1.returnItem();
        library.printAvailable();


        LibraryItem found = library.findByTitle("1984");
        System.out.println("SearchbyTitle: " + found);

        System.out.println("\nChecks Hashcode: ");
        System.out.println(b1.equals(b4));
        System.out.println(b1.equals(b2));
        System.out.println((b1.hashCode() == b4.hashCode()));

        library.removeItem(b2);
        library.printAll();
    }
}