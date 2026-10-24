class BankTransaction extends Thread {
    public void run() {
        System.out.println("Bank Transaction Started");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Processing Transaction " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Transaction Interrupted");
            }
        }
        System.out.println("Transaction Completed");
    }
}
public class SmartBankingThread {
    public static void main(String[] args) {
        System.out.println("Smart Banking System ");
        BankTransaction transaction = new BankTransaction();
        transaction.start();
    }
}
