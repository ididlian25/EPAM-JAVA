public abstract class Deposit {
    protected double amount;   // depósito inicial
    protected int period;      // meses

    public Deposit(double depositAmount, int depositPeriod) {
        this.amount = depositAmount;
        this.period = depositPeriod;
    }

    public double getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    // Método abstracto: cada tipo de depósito lo implementa distinto
    public abstract double income();
}
