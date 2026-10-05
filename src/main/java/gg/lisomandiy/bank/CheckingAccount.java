package gg.lisomandiy.bank;

public class CheckingAccount extends Account {

    private final double overdraftLimit;

    public CheckingAccount(String owner, double initialBalance, double overdraftLimit) {
        super(owner, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    protected boolean canWithdraw(double amount) {
        return getBalance() - amount >= -overdraftLimit;
    }
}
