public class LongDeposit extends Deposit implements Prolongable {
    public LongDeposit(double amount, int period) {
        super(amount, period);
    }

    @Override
    public double income() {
        double sum = amount;
        for (int i = 1; i <= period; i++) {
            if (i > 6) {
                sum = sum * 1.15;
            }
        }
        return sum - amount;
    }

    @Override
    public boolean canToProlong() {
        return period <= 36; // 3 años = 36 meses
    }
}
