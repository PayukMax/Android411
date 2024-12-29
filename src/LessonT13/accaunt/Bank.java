package LessonT13.accaunt;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> acc;

    public Bank() {
        this.acc = new ArrayList<>();
    }

    public void addAccount(Account acnt){
        acc.add(acnt);
    }

    public void deposit(Account acnt, double amount){
        acnt.deposit(amount);
    }

    public void withdraw(Account acnt, double amount){
        acnt.withdraw(amount);
    }

    public void printAccountBalans (){
        for (Account acnt:acc){
            System.out.println("Баланс счета: "+acnt.getBalance());
        }
    }


}
