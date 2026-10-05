package gg.lisomandiy.bank;

public class SavingsAccount extends Account {

    private final double interestRate;

    public SavingsAccount(String owner, double initialBalance, double interestRate) {
        super(owner, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }

    @Override
    protected boolean canWithdraw(double amount) {
        return getBalance() >= amount;
    }
}
