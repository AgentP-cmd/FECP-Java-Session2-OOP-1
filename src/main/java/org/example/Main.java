package org.example;
import java.util.*;

public class Main {
    private static boolean isRunning = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        while (isRunning) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1 -> createAccount(sc, bankAccounts);
                case 2 -> viewAccounts(bankAccounts);
                case 3 -> checkBalance(sc, bankAccounts);
                case 4 -> deposit(sc, bankAccounts);
                case 5 -> withdraw(sc, bankAccounts);
                case 6 -> {
                    System.out.println("=== Thank You!! ===");
                    isRunning = false;
                    return; // exit immediately
                }
                default -> System.out.println("Invalid choice.");
            }

            // Ask user if they want to return to menu
            System.out.print("Would you like to return to menu? (Yes/No): ");
            String response = sc.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("=== Thank You!! ===");
                isRunning = false;
            }
        }
    }

    private static void createAccount(Scanner sc, ArrayList<BankAccount> accounts) {
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        sc.nextLine();

        if (findAccountByNumber(accNum, accounts) != null) {
            System.out.println("Account number already exists!");
            return;
        }

        System.out.print("Enter Holder Name: ");
        String accName = sc.nextLine();

        System.out.print("Initial deposit? (yes/no): ");
        String iniDepo = sc.nextLine().toLowerCase();

        if (iniDepo.equals("yes")) {
            System.out.print("Enter initial deposit amount: ");
            double iniDepoAmt = sc.nextDouble();
            sc.nextLine();
            accounts.add(new BankAccount(accNum, accName, iniDepoAmt));
        } else {
            accounts.add(new BankAccount(accNum, accName));
        }
        System.out.println("Account Created Successfully!");
    }

    private static void viewAccounts(ArrayList<BankAccount> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("===== Accounts Info =====");
        for (BankAccount acc : accounts) {
            acc.displayInformation();
            System.out.println();
        }
    }

    private static void checkBalance(Scanner sc, ArrayList<BankAccount> accounts) {
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        sc.nextLine();

        BankAccount account = findAccountByNumber(accNum, accounts);
        if (account != null) {
            System.out.printf("Balance: %.2f\n", account.getAvailableBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void deposit(Scanner sc, ArrayList<BankAccount> accounts) {
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        sc.nextLine();

        BankAccount account = findAccountByNumber(accNum, accounts);
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw(Scanner sc, ArrayList<BankAccount> accounts) {
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        sc.nextLine();

        BankAccount account = findAccountByNumber(accNum, accounts);
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static BankAccount findAccountByNumber(int accNum, ArrayList<BankAccount> accounts) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNum) {
                return acc;
            }
        }
        return null;
    }
}
