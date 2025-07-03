package org.example;
import java.util.*;
public class Main {
    private static boolean isRunning;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        do {
            System.out.println("=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-5): ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNum = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String accName = sc.nextLine();
                    System.out.print("Initial deposit? (yes/no): ");
                    String iniDepo = sc.nextLine().toLowerCase();
                    if (iniDepo.equals("yes")){
                        System.out.print("Enter initial deposit amount: ");
                        int iniDepoAmt = sc.nextInt();
                        sc.nextLine();
                        bankAccounts.add(new BankAccount(accNum, accName, iniDepoAmt));
                        System.out.println("Account Created Successfully!");

                    }else {
                        bankAccounts.add(new BankAccount(accNum, accName));
                        System.out.println("Account Created Successfully!");
                    }
                    System.out.print("Would you like to return to menu? (Yes/No): ");
                    String response = sc.nextLine().toLowerCase();
                    returnToMenu(response);
                    break;
                case 2:
                    System.out.println("===== Accounts Info =====");
                    if (bankAccounts.isEmpty()){
                        System.out.println("There is no Account('s) Yet!");
                    }else {
                        for (int i = 0; i < bankAccounts.size(); i++) {
                            System.out.print((i+1) + ". ");
                            bankAccounts.get(i).displayInformation();
                            System.out.println();
                        }
                    }
                    System.out.print("Would you like to return to menu? (Yes/No): ");
                    String response2 = sc.nextLine().toLowerCase();
                    returnToMenu(response2);
                    break;
                case 3:
                    System.out.print("=== List of Accounts ===");
                    for (int i = 0; i < bankAccounts.size(); i++) {
                        System.out.print((i+1) + ". ");
                        bankAccounts.get(i).
                    }

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("=== Thank You!! ===");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }

        }while(isRunning);


    }

    public static void returnToMenu(String response){
        if (response.equals("no")){
            System.out.println("=== Thank You!! ===");
            isRunning = false;
        } else {
            isRunning = true;
        }
    }
}