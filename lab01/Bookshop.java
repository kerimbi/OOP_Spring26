enum BookCategory{
    FICTION, SCIENCE, HISTORY;
}
enum BookCondition{
    NEW, USED;
}
class Book{
    private static final double tax = 0.10; //const for all books
    private static int totalBooks = 0; //can change, shared by all books
    private final String isbn; //read-only fields
    private final String title; //read-only fields
    private double price; 
    private int stock;
    private BookCategory category;

    { totalBooks++ ;} //initial.block
    
    public Book(String isbn, String title, double price, BookCategory category, int stock){
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    //methods overloading
    public double calculateFinalPrice(){
        double finalPrice = this.price;
        finalPrice = finalPrice + (finalPrice*tax);
        return finalPrice;
    }

    public double calculateFinalPrice(int quantity){
        double total = this.calculateFinalPrice() * quantity;
        return total;
    }

    public double calculateFinalPrice(int quantity, double discount){
        double total = this.calculateFinalPrice(quantity);
        total = total - (total*discount);
        return total;
    }

    //static method
    public static int getTotalBooks(){
        return totalBooks;
    }

    public void showInfo() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Price: $" + price);
        System.out.println("Category: " + category);
        System.out.println("Stock: " + stock);
        System.out.println("Final Price: $" + calculateFinalPrice());
        System.out.println("---");
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
}
public class Bookshop {
    public static void main(String[] args) {
        
        Book book1 = new Book("111", "Java Basics", 30.0, BookCategory.SCIENCE, 5);
        Book book2 = new Book("222", "Mystery Novel", 20.0, BookCategory.FICTION, 4);
        Book book3 = new Book("333", "History Book", 25.0, BookCategory.HISTORY, 8);
        
        book1.showInfo();
        book2.showInfo();
        book3.showInfo();
        
        System.out.println("\nmethods of overloading");
        System.out.println("1 book: $" + book1.calculateFinalPrice());
        System.out.println("3 books: $" + book1.calculateFinalPrice(3));
        System.out.println("5 books with 20% discount: $" + book1.calculateFinalPrice(5, 0.20));
        System.out.println("Total books created: " + Book.getTotalBooks());
    }
}
