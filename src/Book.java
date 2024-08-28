import java.util.Date;

public class Book {
    private String bookId;
    private String title;
    private Author author;
    private Category category;

    private User owner;
    private boolean status;
    private double price;
    private Damageable damageStatus;



    public Book(String bookId, String title,Author author, Category category,  User owner, boolean status, double price) {
        this.bookId = bookId;
        this.title = title;
        this.category = category;
        this.author = getAuthor();
        this.owner = null;
        this.status = true;
        this.price = price;
        this.damageStatus= new NoDamage();
        author.addBook(this);

    }

    public double getPrice() {
        return price;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
        this.status=(owner ==null) ? true : false;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean isAvailable() {
        return owner==null;
    }

    public void setDamageStatus(Damageable damageStatus) {
        this.damageStatus = damageStatus;
    }

    public double returnBook() {
        return damageStatus.calculateReturnFee(this.price);
    }

    public void display() {
        System.out.println("bookId: "+ bookId);
        System.out.println("title: "+ title);
        System.out.println("author: "+ author);
        System.out.println("category: "+ category);

        System.out.println("status: "+ status);


    }

    public Damageable getDamageStatus() {
        return damageStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +

                ", owner=" + owner +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", damageStatus=" + damageStatus +
                ", author=" + author +
                '}';
    }
}
