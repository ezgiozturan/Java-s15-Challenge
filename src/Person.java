public abstract class Person {
    public  String name;
    private String adress;
    private int phone;
    public static User user;

    public Person(String name, String adress, int phone) {
        this.name = name;
        this.adress = adress;
        this.phone = phone;
    }

    public void addPerson(User user){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void addUser(User user){
        this.user = user;
    }
    public void whoAreYou() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String whoYouAre() {
        return null;
    }
}
