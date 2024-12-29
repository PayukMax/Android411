package LessonT13.accaunt;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
//        bank.addAccount(new SavingAccount(1000,1.25));
//        bank.addAccount(new CurrentAccount(5000,1000));
        SavingAccount sa = new SavingAccount(1000,1.25);
        CurrentAccount ca = new CurrentAccount(5000,1000);
        bank.addAccount(sa);
        bank.addAccount(ca);


                System.out.println("****** Сберегательный счет ********\nПервоначальный депозит: $ "+sa.getBalance()+"\nПроцентная ставка: "+sa.getInterestRate()+"%\n");
        System.out.println("****** Текущий счет ********\nПервоначальный депозит: $ "+ca.getBalance()+"\nЛимит овердрафта: $ "+ca.getOverdraftLimit()+"\n");

        System.out.println("Вносим 100 на сбер счет...");
        bank.deposit(sa,100);

        System.out.println("Вносим 500 на тек счет...");
        bank.deposit(ca,500);

        System.out.println("\nСберегательный счет и текущий счет...");
        bank.printAccountBalans();
//        System.out.println(sa);
//        System.out.println(ca);
        System.out.println("Снимаем 150 на сбер счет...");
        bank.withdraw(sa,150);

        bank.printAccountBalans();

        sa.applyInterest();
        System.out.println("После начисления процентов...");
        System.out.println("Сберегательный счет и текущий счет...");
        bank.printAccountBalans();


    }
}
