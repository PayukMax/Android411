package LessonT13.accaunt;

public class CurrentAccount implements Account {
    private double balance;
    private double overdraftLimit;

    public CurrentAccount(double balance, double overdraftLimit) {
        this.setBalance(balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void setBalance(double balance) {
        if (balance > 0) this.balance = balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if ((balance+overdraftLimit)>=amount)
        balance -= amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
