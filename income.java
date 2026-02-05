public class Main {
    public static void main(String[] args) {
        Client client = new Client();

        client.addDeposit(new BaseDeposit(1000, 3));
        client.addDeposit(new SpecialDeposit(1000, 2));
        client.addDeposit(new LongDeposit(1000, 8));

        System.out.println("Total income: " + client.totalIncome());
        System.out.println("Max income: " + client.maxIncome());
        System.out.println("Income of deposit #0: " + client.getIncomeByNumber(0));
    }
}
