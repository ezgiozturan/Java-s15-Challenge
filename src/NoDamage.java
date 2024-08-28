public class NoDamage implements Damageable {
    @Override
    public double calculateReturnFee(double price){
        return 0;
    }


}
