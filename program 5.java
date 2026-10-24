
class Bank {
    String bankName = "ABC Bank";
    double interestRate = 5.0;

    void displayBank() {
        System.out.println("Bank Name : " + bankName);
        System.out.println("Interest Rate : " + interestRate + "%");
    }
}
class Customer extends Bank {
    String customerName = "Jeevagan";
    double balance = 10000.0;
    int accountAge = 6;

    @Override
    void displayBank() {
        super.displayBank(); 
        System.out.println("Customer Account Type : Savings");
    }
    void displayCustomer() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Current Balance : " + balance);
        System.out.println("Account Age : " + accountAge + " years");
    }
    double calculateInterest() {
        return (balance * interestRate) / 100;
    }
    double bonusInterest() {
        if (accountAge >= 5) {
            return balance * 0.02;
        }
        return 0;
    }
    void updateBalance() {
        double interest = calculateInterest();
        double bonus = bonusInterest();
        System.out.println("\nInterest Earned : " + interest);
        System.out.println("Bonus Interest : " + bonus);
        balance = balance + interest + bonus;
        System.out.println("Updated Balance : " + balance);
    }
}
public class SmartBankingSystem {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.displayBank();
        customer.displayCustomer();
        customer.updateBalance();
    }
}
