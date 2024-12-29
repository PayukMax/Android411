package LessonT13.accaunt;

public class SavingAccount implements Account{
    private double balance;
    private double interestRate;

    public SavingAccount(double balance, double interestRate) {
        this.setBalance(balance);
        this.setInterestRate(interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }


    public void setBalance(double balance) {
        if (balance>0) this.balance = balance;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate>0) this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
    }

    @Override
    public void withdraw(double amount) {
        balance-=amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void applyInterest(){
        balance+=balance*interestRate/100;
    }
}
