import java.util.Scanner;

public class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;
    
    // Constructor
    public BankAccount(String name, int number) {
        this.accountHolder = name;
        this.accountNumber = number;
        this.balance = 0.0;
    }
    
    // Display account details
    public void displayDetails() {
        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    
    // Deposit money
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    // Withdraw money
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if(amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
    
    // Check balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
    
    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter account number: ");
        int number = scanner.nextInt();
        
        // Create account
        BankAccount account = new BankAccount(name, number);
        
        int choice;
        
        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    account.displayDetails();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    account.checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        } while(choice != 5);
        
        scanner.close();
    }
}
