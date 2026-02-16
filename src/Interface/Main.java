public class Main {
    public static void main(String[] args) {
        Client client = new Client();

        client.addDeposit(new BaseDeposit(1000, 3));
        client.addDeposit(new SpecialDeposit(1500, 2));
        client.addDeposit(new LongDeposit(2000, 8));

        System.out.println("Total income: " + client.totalIncome());
        System.out.println("Max income: " + client.maxIncome());
        System.out.println("Income of deposit #0: " + client.getIncomeByNumber(0));
        System.out.println("Prolongable deposits: " + client.countPossibleToProlongDeposit());
    }
}
