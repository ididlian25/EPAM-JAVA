public class SpecialDeposit extends Deposit implements Prolongable {
    public SpecialDeposit(double amount, int period) {
        super(amount, period);
    }

    @Override
    public double income() {
        double sum = amount;
        for (int i = 1; i <= period; i++) {
            sum = sum * (1 + i / 100.0);
        }
        return sum - amount;
    }

    @Override
    public boolean canToProlong() {
        return amount > 1000;
    }
}
