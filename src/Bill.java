public class Bill {
    private String billId;
    private User user;
    private Book book;
    private Damageable damageStatus;
    private double price;

    public Bill(String billId, User user, Book book,Damageable damageStatus, double price) {
        this.billId = billId;
        this.user = user;
        this.book = book;
        this.damageStatus = damageStatus;
        this.price = book.returnBook();

    }

    public String getBillId() {
        return billId;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public Damageable getDamageStatus() {
        return damageStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setDamageStatus(Damageable damageStatus) {
        this.damageStatus = damageStatus;
    }



    public void payBill() {
        System.out.println( getBook().getTitle() + "isimli kitap için" + price +" tl ödemelisiniz." );
    }
}