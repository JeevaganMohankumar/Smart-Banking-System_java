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
    int accountAge = 6; 

    void displayCustomer() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Account Age : " + accountAge + " years");
    }
}

class Account extends Customer {
    double balance = 15000.0;

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Amount : " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn Amount : " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
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
    void addInterest() {
        double interest = calculateInterest();
        double bonus = bonusInterest();

        System.out.println("Interest Earned : " + interest);
        System.out.println("Bonus Interest : " + bonus);

        balance += interest + bonus;
    }

    void displayBalance() {
        System.out.println("Current Balance : " + balance);
    }
}

public class smartbank {
    public static void main(String[] args) 
    {
        Account account = new Account();

        account.displayBank();
        account.displayCustomer();
        account.displayBalance();
        account.deposit(5000);
        account.withdraw(3000);
        account.addInterest();
        account.displayBalance();
    }
}
