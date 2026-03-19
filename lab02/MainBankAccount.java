import java.util.Vector;

class Account {
    private double balance;
    private int accNumber;

    public Account(int accNumber) {
        this.balance = 0.0;
        this.accNumber = accNumber;
    }

    public void deposit(double sum) {
        if (sum > 0) balance += sum;
    }

    public void withdraw(double sum) {
        if (sum > 0 && sum <= balance) balance -= sum;
        else System.out.println("Insufficient funds.");
    }

    public double getBalance()       { return balance; }
    public int getAccountNumber()    { return accNumber; }

    public void transfer(double amount, Account other) {
        withdraw(amount);
        other.deposit(amount);
    }

    @Override
    public String toString() {
        return "Account[" + accNumber + ", balance=$" + String.format("%.2f", balance) + "]";
    }

    public final void print() { System.out.println(toString()); }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accNumber, double interestRate) {
        super(accNumber);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        deposit(getBalance() * interestRate / 100.0);
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double rate) { interestRate = rate; }

    @Override
    public String toString() {
        return "SavingsAccount[" + getAccountNumber() + ", balance=$" + String.format("%.2f", getBalance())
                + ", rate=" + interestRate + "%]";
    }
}

class CheckingAccount extends Account {
    private static final int FREE_TRANSACTIONS = 3;
    private static final double FEE_PER_TRANSACTION = 0.02;
    private int transactionCount;

    public CheckingAccount(int accNumber) {
        super(accNumber);
        this.transactionCount = 0;
    }

    @Override
    public void deposit(double sum) {
        super.deposit(sum);
        transactionCount++;
    }

    @Override
    public void withdraw(double sum) {
        super.withdraw(sum);
        transactionCount++;
    }

    public void deductFee() {
        int chargeableTransactions = Math.max(0, transactionCount - FREE_TRANSACTIONS);
        double fee = chargeableTransactions * FEE_PER_TRANSACTION;
        if (fee > 0) {
            super.withdraw(fee);
            System.out.println("  Fee deducted: $" + String.format("%.2f", fee)
                    + " (" + chargeableTransactions + " extra transactions)");
        }
        transactionCount = 0;
    }

    public int getTransactionCount() { return transactionCount; }

    @Override
    public String toString() {
        return "CheckingAccount[" + getAccountNumber() + ", balance=$" + String.format("%.2f", getBalance())
                + ", transactions=" + transactionCount + "]";
    }
}

class Bank {
    private Vector<Account> accounts = new Vector<>();

    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Opened: " + account);
    }

    public void closeAccount(int accNumber) {
        accounts.removeIf(a -> {
            if (a.getAccountNumber() == accNumber) {
                System.out.println("Closed: " + a);
                return true;
            }
            return false;
        });
    }

    public Account findAccount(int accNumber) {
        return accounts.stream().filter(a -> a.getAccountNumber() == accNumber).findFirst().orElse(null);
    }

    public void update() {
        System.out.println("\nBank update:");
        for (Account a : accounts) {
            if (a instanceof SavingsAccount s) s.addInterest();
            else if (a instanceof CheckingAccount c) c.deductFee();
        }
    }

    public void printAll() {
        System.out.println("\nAll accounts:");
        accounts.forEach(Account::print);
    }
}

public class MainBankAccount {
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount s1 = new SavingsAccount(1001, 5.0);
        SavingsAccount s2 = new SavingsAccount(1002, 3.5);
        CheckingAccount c1 = new CheckingAccount(2001);
        CheckingAccount c2 = new CheckingAccount(2002);

        bank.openAccount(s1);
        bank.openAccount(s2);
        bank.openAccount(c1);
        bank.openAccount(c2);

        System.out.println("\nTransactions:");
        s1.deposit(1000.0);
        s2.deposit(500.0);

        c1.deposit(300.0);
        c1.withdraw(50.0);
        c1.deposit(100.0);
        c1.withdraw(20.0);  

        c2.deposit(200.0);
        c2.withdraw(10.0);

        bank.printAll();
        bank.update();
        bank.printAll();

        System.out.println("\nTransfer:");
        Account from = bank.findAccount(1001);
        Account to   = bank.findAccount(2001);
        from.transfer(100.0, to);
        from.print();
        to.print();

        System.out.println("\nClose account:");
        bank.closeAccount(1002);
        bank.printAll();
    }
}