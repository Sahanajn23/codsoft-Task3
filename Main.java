import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    private void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println("Your current balance: $" + balance);
    }

    private void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the deposit amount: $");
        double amount = sc.nextDouble();
        userAccount.deposit(amount);
        System.out.println("Deposit successful. Your new balance: $" + userAccount.getBalance());
    }

    private void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the withdrawal amount: $");
        double amount = sc.nextDouble();

        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        Scanner sc = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Choose an option (1-4): ");
            int option = sc.nextInt();
            atm.processOption(option);
        }
    }
}
