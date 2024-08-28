public class MajorDamage implements Damageable{
    @Override
    public double calculateReturnFee(double price){
        return price;
    }
}
