package gg.lisomandiy.bank;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount savings = new SavingsAccount("Анна", 1000, 0.05);
        CheckingAccount checking = new CheckingAccount("Игорь", 200, 300);

        bank.addAccount(savings);
        bank.addAccount(checking);

        System.out.println("Счета после открытия:");
        bank.printAllAccounts();

        savings.applyInterest();
        checking.withdraw(400);
        savings.transferTo(checking, 150);

        System.out.println();
        System.out.println("Счета после операций:");
        bank.printAllAccounts();

        System.out.println();
        System.out.println("Общая сумма в банке: " + bank.getTotalFunds());

        System.out.println();
        System.out.println("История счёта Анны:");
        for (String entry : savings.getHistory()) {
            System.out.println(entry);
        }
    }
}
