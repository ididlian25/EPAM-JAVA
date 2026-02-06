public class Main {
    public static void main(String[] args) {
        try {
            // 1. Creamos empleados de diferentes tipos
            Employee emp1 = new SalesPerson("Perez", 2000, 150); // Bono doble (>100%)
            Employee emp2 = new Manager("Gomez", 3000, 120);    // Bono +500 (>100 clientes)
            Employee emp3 = new Employee("Lara", 1500);         // Empleado base

            Employee[] team = {emp1, emp2, emp3};
            Company epam = new Company(team);

            // 2. Asignamos un bono base de 500
            epam.giveEverybodyBonus(500);

            // 3. Resultados
            System.out.println("Total a pagar nomina: " + epam.totalToPay());
            System.out.println("Empleado con mayor salario: " + epam.nameMaxSalary());

        } catch (IllegalArgumentException e) {
            // Aquí aplicamos lo visto en el video de manejo de excepciones 
            System.err.println("Error en los datos: " + e.getMessage());
        }
    }
}