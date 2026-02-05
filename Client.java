public class Client {
    private Deposit[] deposits;

    public Client() {
        deposits = new Deposit[10]; // máximo 10 depósitos
    }

    public boolean addDeposit(Deposit deposit) {
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                return true;
            }
        }
        return false; // no hay espacio
    }

    public double totalIncome() {
        double total = 0;
        for (Deposit d : deposits) {
            if (d != null) {
                total += d.income();
            }
        }
        return total;
    }

    public double maxIncome() {
        double max = 0;
        for (Deposit d : deposits) {
            if (d != null) {
                max = Math.max(max, d.income());
            }
        }
        return max;
    }

    public double getIncomeByNumber(int number) {
        if (number >= 0 && number < deposits.length && deposits[number] != null) {
            return deposits[number].income();
        }
        return 0;
    }
}
