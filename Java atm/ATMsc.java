/**
 * 
 */
/**
 * @author Noordin
 *
 */

import java.util.Scanner;

public class ATMsc {
    private static Scanner scanner = new Scanner(System.in);
    private static Account account;

    public static void main(String[] args) {
        boolean quit = false;
        createAccount();
        while (!quit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter your name:  ");
        String name = scanner.nextLine();
        System.out.print("Enter your initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        account = new Account(name, balance);
        System.out.println("Account created successfully");
    }

    private static void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        account.deposit(amount);
        System.out.println("Deposit successful");
    }

    private static void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Withdrawal failed: insufficient funds");
        }
    }

    private static void checkBalance() {
        System.out.println("Your balance is: " + account.getBalance());
    }

    private static void printMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check balance");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");
    }

    private static class Account {
        private String name;
        private String password;
        private double balance;

        public Account(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        }

        public double getBalance() {
            return balance;
        }
    }
}