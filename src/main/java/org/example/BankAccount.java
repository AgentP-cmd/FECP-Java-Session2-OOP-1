package org.example;

public class BankAccount {
    private final int accountNumber;
    private final String bankAccountName;
    private double availableBalance;

    BankAccount(int accountNumber, String bankAccountName, double availableBalance){
        this.accountNumber = accountNumber;
        this.bankAccountName = bankAccountName;
        this.availableBalance = availableBalance;
    }

    BankAccount(int accountNumber, String bankAccountName){
        this.accountNumber = accountNumber;
        this.bankAccountName = bankAccountName;
    }

    public void deposit(double depositAmount){
        if (availableBalance <= 0){
            System.out.println("Please Enter a Valid Number");
        }else {
            System.out.println("You have deposit: " + depositAmount );
            availableBalance += depositAmount;
        }
    }

    public void withDraw( double withdrawAmount){
        if (availableBalance <= 0 || withdrawAmount > availableBalance){
            System.out.println("Please Input a Valid Number");
        }else {
                availableBalance -= withdrawAmount;
                System.out.println("Your Available Balance: " + this.availableBalance);

            }
        }
    public void displayInformation(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Bank Account Name: " + bankAccountName);
        System.out.println("Available Balance: " + availableBalance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public void displayBalance(){
        System.out.println("Your Balance: "+ availableBalance);
    }
}


