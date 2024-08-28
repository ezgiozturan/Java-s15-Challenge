import java.util.*;

public class Main {
    private static List<Book> books = new ArrayList<>();
    private static List<Author> authors = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static void initializeLibrary() {
        Author author1 = new Author("Author 1", "Address 1", 123456789, "Books 1");
        Author author2 = new Author("Author 2", "Address 2", 987654321, "Books 2");

        authors.add(author1);
        authors.add(author2);

        books.add(new Book("1", "Book 1", author1, Category.FICTION, null, true,4.0));
        books.add(new Book("2", "Book 2", author2, Category.NONFICTION, null, true,5.4));
        books.add(new Book("3", "Book 3", author1, Category.MYSTERY, null, true , 7.30));
        books.add(new Book("4", "Book 4", author2, Category.SCIENCE, null, true , 3.35));
        books.add(new Book("5", "Book 5", author1, Category.HISTORY, null, true , 6.50));

        users.add(new User("User 1", "User Address 1", 111111111, new HashSet<>()));
        users.add(new User("User 2", "User Address 2", 222222222, new HashSet<>()));
    }

    public static void main(String[] args) {
        initializeLibrary();

        while (true) {
            System.out.println("\n--- Kütüphane Otomasyonu ---");
            System.out.println("1. Yazarları listele");
            System.out.println("2. Yazarın kitaplarını listele");
            System.out.println("3. Kitap ara");
            System.out.println("4. Kullanıcıları listele");
            System.out.println("5. Kullanıcı seç ve ödünç aldığı kitapları listele");
            System.out.println("6. Kitap ödünç al");
            System.out.println("7. Kitap iade et ve hasar tespiti yap");
            System.out.println("8. Çıkış");
            System.out.print("Bir seçenek girin: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listAuthors();
                    break;
                case 2:
                    listAuthorBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    listUsers();
                    break;
                case 5:
                    selectUserAndListBorrowedBooks();
                    break;
                case 6:
                    borrowBook();
                    break;
                case 7:
                    System.out.print("İade edilecek kitabın ismini girin: ");
                    String bookTitle = scanner.nextLine();
                    Book bookToReturn = findBookByTitle(bookTitle);
                    if (bookToReturn != null) {
                        Librarian.returnBookAndCheckDamage(bookToReturn);
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;
                case 8:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçenek. Tekrar deneyin.");
            }
        }
    }



    private static void listAuthors() {
        for (Author author: authors) {
            System.out.println(author.getName());
        }
    }

    private static void listAuthorBooks() {
        System.out.print("Yazar ismini girin: ");
        String authorName = scanner.nextLine();
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(authorName)) {
                System.out.println(authorName + " adlı yazarın kitapları:");
                for (Book book : author.getBooks()) {
                    System.out.println(book.getTitle());
                }
                return;
            }
        }
        System.out.println("Yazar bulunamadı.");
    }

    private static void searchBook() {
        System.out.print("Aranacak kitabın ismini girin: ");
        String bookTitle = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                System.out.println("Kitap bulundu: " + book);
                return;
            }
        }
        System.out.println("Kitap bulunamadı.");
    }

    private static void listUsers() {
        System.out.println("\nKullanıcılar:");
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    private static void selectUserAndListBorrowedBooks() {
        System.out.print("Kullanıcı ismini girin: ");
        String userName = scanner.nextLine();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                System.out.println(userName + " adlı kullanıcının ödünç aldığı kitaplar:");
                for (Book book : user.getBorrowedBooks()) {
                    System.out.println(book.getTitle());
                }
                return;
            }
        }
        System.out.println("Kullanıcı bulunamadı.");
    }

    private static void borrowBook() {
        System.out.print("Kitap ödünç alacak kullanıcının ismini girin: ");
        String userName = scanner.nextLine();
        System.out.print("Ödünç alınacak kitabın ismini girin: ");
        String bookTitle = scanner.nextLine();

        User user = findUserByName(userName);
        Book book = findBookByTitle(bookTitle);

        if (user != null && book != null) {
            user.borrowBook(book);
        } else {
            System.out.println("Kullanıcı veya kitap bulunamadı.");
        }
    }



     public static User findUserByName(String userName) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                return user;
            }
        }
        return null;
    }

    public static Book findBookByTitle(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    }



