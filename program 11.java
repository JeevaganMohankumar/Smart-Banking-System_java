class BankAccount {
    private int balance = 10000;
    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(
            Thread.currentThread().getName()
            + " deposited Rs." + amount
        );
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(
                Thread.currentThread().getName()
                + " withdrew Rs." + amount
            );
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
    synchronized void displayBalance() {
        System.out.println("Final Balance: Rs." + balance);
    }
}
class BankTransaction extends Thread {

    BankAccount account;

    BankTransaction(BankAccount account, String name) {
        super(name);
        this.account = account;
    }
    public void run() {
        System.out.println(getName() + " started");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        account.deposit(2000);
        account.withdraw(1000);

        System.out.println(getName() + " completed");
    }
}
public class SmartBankingDeadlockPrevention {
    public static void main(String[] args) {
        System.out.println("Smart Banking System");
        BankAccount account = new BankAccount();

        BankTransaction t1 =
            new BankTransaction(account, "Thread-1");

        BankTransaction t2 =
            new BankTransaction(account, "Thread-2");

        System.out.println("Starting transactions...");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        account.displayBalance();
        System.out.println("All transactions completed.");
    }
}
