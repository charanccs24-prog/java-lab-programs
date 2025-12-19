import java.util.Scanner;

// Base class
class Account {
    String name;
    int accNo;
    String accType;
    double balance;

    Scanner sc = new Scanner(System.in);

    void acceptDetails() {
        System.out.print("Enter customer name: ");
        name = sc.nextLine();

        System.out.print("Enter account number: ");
        accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter account type: ");
        accType = sc.nextLine();

        System.out.print("Enter initial balance: ");
        balance = sc.nextDouble();
    }

    void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        balance += amt;
        System.out.println("Amount deposited successfully.");
    }

    void displayBalance() {
        System.out.println("Current balance = " + balance);
    }

    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();

        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// Savings Account
class SavAcct extends Account {

    void computeInterest() {
        double rate = 0.05; // 5% interest
        balance = balance + (balance * rate);
        System.out.println("Interest added.");
    }
}

// Current Account
class CurAcct extends Account {

    final double MIN_BAL = 1000;
    final double PENALTY = 100;

    void checkMinBalance() {
        if (balance < MIN_BAL) {
            balance -= PENALTY;
            System.out.println("Minimum balance not maintained.");
            System.out.println("Penalty of " + PENALTY + " imposed.");
        }
    }

    @Override
    void withdraw() {
        super.withdraw();
        checkMinBalance();
    }
}

// Main class
public class BankDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Choose account type: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            SavAcct s = new SavAcct();
            s.acceptDetails();
            s.deposit();
            s.computeInterest();
            s.withdraw();
            s.displayBalance();
        } 
        else if (choice == 2) {
            CurAcct c = new CurAcct();
            c.acceptDetails();
            c.deposit();
            c.withdraw();
            c.displayBalance();
        } 
        else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}

