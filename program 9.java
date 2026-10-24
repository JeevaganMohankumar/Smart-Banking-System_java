
class BankAccount {
    private double balance = 0;
    synchronized void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: ₹" + amount);
        System.out.println("Current Balance: ₹" + balance);
        notifyAll();
    }

    synchronized void withdraw(double amount) {
        while (balance < amount) {
            System.out.println(
                "Insufficient balance. Withdrawal thread is waiting..."
            );

            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
            }
        }

        balance = balance - amount;
        System.out.println("Withdrawn: ₹" + amount);
        System.out.println("Remaining Balance: ₹" + balance);
        notify();
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
            System.out.println("Thread Interrupted");
        }
        account.deposit(10000);
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

public class SmartBankingInterThread {
    public static void main(String[] args) {

        System.out.println(" Smart Banking System ");
        BankAccount account = new BankAccount();
        WithdrawThread withdraw =
            new WithdrawThread(account);
        DepositThread deposit =
            new DepositThread(account);
        withdraw.start();
        deposit.start();
    }
}
