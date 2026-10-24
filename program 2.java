class Bank {
    private String name;
    private double balance;
    static String bankName = "ABC Bank";
    
    Bank(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public void deposit(int amount) {
        balance += amount;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void display() {
        System.out.println("Bank Name : " + bankName);
        System.out.println("Customer  : " + name);
        System.out.println("Balance   : " + balance);
    }
}
public class Main {
    public static void main(String[] args) {
        Bank b1 = new Bank("Jeevagan", 5000);
        Bank b2 = new Bank("Rahul", 3000);
        b1.deposit(1000);      
        b2.deposit(500.50);    

        b1.display();
        System.out.println();

        b2.display();
    }
}
