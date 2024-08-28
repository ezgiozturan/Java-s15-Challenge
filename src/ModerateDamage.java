public class ModerateDamage implements Damageable{
    @Override
    public double calculateReturnFee(double price){
        return price*0.50;
    }
}
