import java.util.Set;

public class User extends Person{
    private static Set<Book> borrowedBooks;


    public User(String name, String adress, int phone, Set<Book> borrowedBooks) {
        super(name, adress, phone);
        this.borrowedBooks = borrowedBooks;
    }



    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Set<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }


    public void borrowBook(Book book) {
        if(borrowedBooks.size()<6 &&book.isAvailable()) {
            borrowedBooks.add(book);
            book.setOwner(this);
            System.out.println( book.getTitle() +" isimli kitap " + getName() + " tarafından ödünç alınmıştır." );
        } else {
            System.out.println(book.getTitle() + " isimli kitabı ödünç alamazsınız. "  );
        }
    }



    @Override
    public String whoYouAre() {
        return "User: " + getName();
    }

    @Override
    public String toString() {
        return "User{" +
                "borrowedBooks=" + borrowedBooks +
                '}';
    }
}
