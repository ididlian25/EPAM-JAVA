public class BaseDeposit extends Deposit {
    public BaseDeposit(double amount, int period) {
        super(amount, period);
    }

    @Override
    public double income() {
        double sum = amount;
        for (int i = 0; i < period; i++) {
            sum = Math.round((sum * 1.05) * 100.0) / 100.0; // redondeo a centavos
        }
        return sum - amount;
    }
}
