package gg.lisomandiy.bank;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private final String owner;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public Account(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
        history.add("Счёт открыт с балансом " + initialBalance);
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть положительной");
        }
        balance += amount;
        history.add("Пополнение: +" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть положительной");
        }
        if (!canWithdraw(amount)) {
            throw new IllegalStateException("Недостаточно средств");
        }
        balance -= amount;
        history.add("Снятие: -" + amount);
    }

    public void transferTo(Account target, double amount) {
        this.withdraw(amount);
        target.deposit(amount);
        history.add("Перевод на счёт " + target.getOwner() + ": -" + amount);
    }

    public List<String> getHistory() {
        return history;
    }

    protected abstract boolean canWithdraw(double amount);

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + owner + "], баланс: " + balance;
    }
}
