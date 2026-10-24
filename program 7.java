class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String message) {
        super(message);
    }
}
class BankAccount {

    String customerName;
    double balance;

    BankAccount(String name, double balance) {
        customerName = name;
        this.balance = balance;
    }
    void withdraw(double amount) throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient Balance! Withdrawal not possible."
            );
        }

        balance = balance - amount;
        System.out.println("Withdrawal Amount : ₹" + amount);
        System.out.println("Remaining Balance : ₹" + balance);
    }
    void display() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Balance       : ₹" + balance);
    }
}
public class SmartBankingException {
    public static void main(String[] args) {
        BankAccount account =
            new BankAccount("Jeevagan", 50000);
        System.out.println(" Smart Banking System ");
        account.display();
        try {
            account.withdraw(60000);
        }
        catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("Transaction Completed.");
    }
}
