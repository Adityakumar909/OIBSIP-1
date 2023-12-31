import java.util.Scanner;

public class ATMSystem {
    private double accountBalance; // Declare the accountBalance variable

    private void deposit(double amount) {
        accountBalance += amount;
        System.out.println("Deposited amount is " + amount + " Rupees.");
    }

    private void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawn amount is " + amount + " Rupees.");
        } else {
            System.out.println("Insufficient balance. Cannot withdraw " + amount + " Rupees.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + accountBalance + " Rupees.");
    }

    private void ATMInterface() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    withdraw(withdrawalAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATMSystem. Visit Again!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }

    public static void main(String[] args) {
        ATMSystem atm = new ATMSystem();
        atm.ATMInterface();
    }
}