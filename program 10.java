
class BankAccount {

    private int balance = 0;
    synchronized void withdraw(int amount) {
        while (balance < amount) {
            System.out.println("Insufficient Balance!");
            System.out.println("Withdrawal thread is waiting...");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        balance -= amount;
        System.out.println("Withdrawn: Rs." + amount);
        System.out.println("Remaining Balance: Rs." + balance);

        notify();
    }
    synchronized void deposit(int amount) {

        balance += amount;
        System.out.println("Deposited: Rs." + amount);
        System.out.println("Current Balance: Rs." + balance);

        notifyAll();
    }
}
class WithdrawThread extends Thread {

    BankAccount account;

    WithdrawThread(BankAccount account) {
        this.account = account;
    }
    public void run() {
        account.withdraw(5000);
    }
}
class DepositThread extends Thread {
    BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        account.deposit(10000);
    }
}
public class SmartBankingInterThread {
    public static void main(String[] args) {
        System.out.println("Smart Banking System");
        BankAccount account = new BankAccount();
        WithdrawThread t1 = new WithdrawThread(account);
        DepositThread t2 = new DepositThread(account);

        t1.start();
        t2.start();
    }
}
