package org.example;

public class BankAccount {
    private final int accountNumber;
    private final String bankAccountName;
    private double availableBalance;

    public BankAccount(int accountNumber, String bankAccountName, double availableBalance) {
        this.accountNumber = accountNumber;
        this.bankAccountName = bankAccountName;
        if (availableBalance < 0) {
            System.out.println("Initial balance can't be negative. Setting to 0.");
            this.availableBalance = 0;
        } else {
            this.availableBalance = availableBalance;
        }
    }

    public BankAccount(int accountNumber, String bankAccountName) {
        this(accountNumber, bankAccountName, 0); // Default to 0 balance
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Must be greater than 0.");
        } else {
            availableBalance += amount;
            System.out.printf("Successfully deposited %.2f. New balance: %.2f\n", amount, availableBalance);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > availableBalance) {
            System.out.println("Insufficient funds.");
        } else {
            availableBalance -= amount;
            System.out.printf("Successfully withdrew %.2f. Remaining balance: %.2f\n", amount, availableBalance);
        }
    }

    public void displayInformation() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + bankAccountName);
        System.out.printf("Balance: %.2f\n", availableBalance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }
}
