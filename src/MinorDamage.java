public class MinorDamage implements Damageable{
    @Override
    public double calculateReturnFee(double price){
        return price*0.25;
    }

}
