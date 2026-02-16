public class SalesPerson extends Employee {
    private int percent;

    public SalesPerson(String name, double salary, int percent) {
        super(name, salary); // Llamada al constructor de Employee
        if (percent < 0) throw new IllegalArgumentException("Percent cannot be negative");
        this.percent = percent;
    }

    @Override
    public void setBonus(double bonus) {
        if (bonus <= 0) throw new IllegalArgumentException("Bonus must be > 0");
        
        if (percent > 200) {
            this.bonus = bonus * 3;
        } else if (percent > 100) {
            this.bonus = bonus * 2;
        } else {
            this.bonus = bonus;
        }
    }
}