public class Company {
    private Employee[] employees;

    public Company(Employee[] employees) {
        if (employees == null) throw new IllegalArgumentException("Employees array cannot be null");
        this.employees = employees;
    }

    public void giveEverybodyBonus(double companyBonus) {
        for (Employee emp : employees) {
            emp.setBonus(companyBonus);
        }
    }

    public double totalToPay() {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.toPay();
        }
        return total;
    }

    public String nameMaxSalary() {
        if (employees.length == 0) return null;
        
        Employee maxEmp = employees[0];
        for (Employee emp : employees) {
            if (emp.toPay() > maxEmp.toPay()) {
                maxEmp = emp;
            }
        }
        return maxEmp.getName();
    }
}