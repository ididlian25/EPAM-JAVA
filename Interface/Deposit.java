public abstract class Deposit implements Comparable<Deposit> {
    protected double amount;
    protected int period;

    public Deposit(double depositAmount, int depositPeriod) {
        if (depositAmount <= 0 || depositPeriod <= 0) {
            throw new IllegalArgumentException("Amount and period must be greater than 0");
        }
        this.amount = depositAmount;
        this.period = depositPeriod;
    }

    public double getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public abstract double income();

    // Comparable: compara por total (capital + intereses)
    @Override
    public int compareTo(Deposit other) {
        double thisTotal = this.amount + this.income();
        double otherTotal = other.amount + other.income();
        return Double.compare(thisTotal, otherTotal);
    }
}
