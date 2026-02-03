public class Manager extends Employee {
    private int clientAmount;

    public Manager(String name, double salary, int clientAmount) {
        super(name, salary);
        if (clientAmount < 0) throw new IllegalArgumentException("Client amount cannot be negative");
        this.clientAmount = clientAmount;
    }

    @Override
    public void setBonus(double bonus) {
        if (bonus <= 0) throw new IllegalArgumentException("Bonus must be > 0");
        
        if (clientAmount > 150) {
            this.bonus = bonus + 1000;
        } else if (clientAmount > 100) {
            this.bonus = bonus + 500;
        } else {
            this.bonus = bonus;
        }
    }
}