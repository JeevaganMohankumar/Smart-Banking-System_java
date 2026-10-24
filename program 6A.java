abstract class BankAccount {
    String customerName;
    String accountNumber;
    double balance;
    
    BankAccount(String name, String accNo, double balance) {
        customerName = name;
        accountNumber = accNo;
        this.balance = balance;
    }
    abstract void calculateInterest();
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    } 
    void display() {
        System.out.println("\nSmart Banking System ");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance       : " + balance);
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String name, String accNo, double balance) {
        super(name, accNo, balance);
    }
    void calculateInterest() {
        double interest = balance * 0.05;
        System.out.println("Interest (5%) : " + interest);
    }
}
public class bank{
    public static void main(String[] args) {
        SavingsAccount account =
            new SavingsAccount("Jeevagan", "SB1001", 50000);
        account.display();
        account.deposit(5000);
        account.calculateInterest();
        System.out.println("Final Balance : " + account.balance);
    }
}
