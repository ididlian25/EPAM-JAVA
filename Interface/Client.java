import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Client implements Iterable<Deposit> {
    private Deposit[] deposits;

    public Client() {
        deposits = new Deposit[10];
    }

    public Client(Deposit[] deposits) {
        if (deposits == null) {
            throw new IllegalArgumentException("Deposits cannot be null");
        }
        this.deposits = deposits;
    }

    public boolean addDeposit(Deposit deposit) {
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                return true;
            }
        }
        return false;
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

    // Iterable implementation
    @Override
    public Iterator<Deposit> iterator() {
        return new DepositIterator();
    }

    private class DepositIterator implements Iterator<Deposit> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            while (index < deposits.length && deposits[index] == null) {
                index++;
            }
            return index < deposits.length;
        }

        @Override
        public Deposit next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return deposits[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public void sortDeposits() {
        Arrays.sort(deposits, (d1, d2) -> {
            if (d1 == null && d2 == null) return 0;
            if (d1 == null) return 1;
            if (d2 == null) return -1;
            double total1 = d1.getAmount() + d1.income();
            double total2 = d2.getAmount() + d2.income();
            return Double.compare(total2, total1); // descending
        });
    }

    public int countPossibleToProlongDeposit() {
        int count = 0;
        for (Deposit d : deposits) {
            if (d instanceof Prolongable) {
                Prolongable p = (Prolongable) d;
                if (p.canToProlong()) {
                    count++;
                }
            }
        }
        return count;
    }
}
