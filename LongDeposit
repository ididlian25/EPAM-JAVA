public class LongDeposit extends Deposit {
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
}
