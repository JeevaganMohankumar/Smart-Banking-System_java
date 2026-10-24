class Bank {
    String name;
    double balance;

    
    Bank() {
        name = "Customer";
        balance = 0.0;
    }

    
    Bank(String n, double b) {
        name = n;
        balance = b;
    }

    
    void display() {
        System.out.println("Name    : " + name);
        System.out.println("Balance : " + balance);
    }
}

public class SmartBankingSystem {
    public static void main(String[] args) {

        
        Bank b1 = new Bank();                    
        Bank b2 = new Bank("Jeevagan", 5000.0);  

        System.out.println("===== Default Account =====");
        b1.display();

        System.out.println();

        System.out.println("===== Customer Account =====");
        b2.display();
    }
}
