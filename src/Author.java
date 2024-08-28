import java.util.HashSet;


public class Author extends Person{
    private HashSet<Book> books;

    public Author(String name, String adress, int phone, String books) {
        super(name, adress, phone);
        this.books = new HashSet<>() {
        };;
    }



    public HashSet<Book> getBooks() {
        return books;
    }

    public void setBooks(HashSet<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public String whoYouAre() {
        return "Author: " + getName();
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                '}';
    }
}
