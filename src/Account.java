import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    String accountNumber;
    Client owner;
    double balance;

    List<Transaction> previousTransactions = new ArrayList<>();

    public Account(String accountNumber, double balance, Client owner, List<Transaction> previousTransactions) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
        this.previousTransactions = previousTransactions;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void Deposit() {
        Scanner inputscanner = new Scanner(System.in);
        double depositAmount;

        //Input med felhantering
        while (true) {
            try {
                System.out.println("Enter depositAmount: ");
                depositAmount = Double.parseDouble(inputscanner.nextLine());
                if (depositAmount < 0 || depositAmount == 0) {
                    System.out.println("The total exceeded the interval for a satisfiable deposit! Please enter an amount greater than zero");
                    continue;
                } else {
                    this.balance = this.balance + depositAmount;
                }
            } catch (Exception e) {
                System.out.println("Error : Input! Please enter a value in integer form.");
            }
        }

    }

    public void Withdraw() {
        Scanner inputscanner = new Scanner(System.in);
        double withdrawAmount;

        //Input med felhantering
        while (true) {
            try {
                System.out.println("Enter withdrawAmount: ");
                withdrawAmount = Double.parseDouble(inputscanner.nextLine());
                if (withdrawAmount < 0 || withdrawAmount == 0) {
                    System.out.println("The total exceeded the interval for a satisfiable deposit! Please enter an amount greater than zero");
                    continue;
                } else {
                    this.balance = this.balance - withdrawAmount;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error : Input! Please enter a value in integer form.");
            }
        }
    }
}

class SavingsAccount extends Account {

    double interest;

    public SavingsAccount(double interest) {
        this.interest = interest;
    }
}
