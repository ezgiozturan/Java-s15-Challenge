import java.util.Scanner;

public class Librarian extends Person {
    public Librarian(String name, String address, int phone) {
        super(name, address, phone);
    }

    public static void returnBookAndCheckDamage(Book book) {
        if (book == null) {
            System.out.println("Geçersiz kitap.");
            return;
        }

        System.out.println("İade edilen kitabın hasar durumunu girin:");
        System.out.println("1. Hasarsız");
        System.out.println("2. Hafif Hasar");
        System.out.println("3. Orta Hasar");
        System.out.println("4. Büyük Hasar");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        Damageable damageStatus;

        switch (choice) {
            case 1:
                damageStatus = new NoDamage();
                break;
            case 2:
                damageStatus = new MinorDamage();
                break;
            case 3:
                damageStatus = new ModerateDamage();
                break;
            case 4:
                damageStatus = new MajorDamage();
                break;
            default:
                System.out.println("Geçersiz seçim. Varsayılan olarak hasarsız seçildi.");
                damageStatus = new NoDamage();
                break;
        }

        book.setDamageStatus(damageStatus);
        double fee = book.returnBook();


        Bill bill = new Bill(generateBillId(),user, book, damageStatus, fee);
        bill.payBill();

        book.setOwner(null);
    }

    private static String generateBillId() {

        return "BILL" + ((int) (Math.random() * 10000));
    }
}