class AccountTransaction implements Runnable {
    public void run() {
        System.out.println("Account Transaction Started");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Checking Account Step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Transaction Interrupted");
            }
        }
        System.out.println("Account Transaction Completed");
    }
}

public class SmartBankingRunnable {
    
    public static void main(String[] args) {
        System.out.println(" Smart Banking System ");
        AccountTransaction transaction =
            new AccountTransaction();
        Thread t = new Thread(transaction);
        t.start();
    }
}
