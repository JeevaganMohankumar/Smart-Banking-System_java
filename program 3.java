import java.util.*;
class Bank {
    String name;
    double balance;

    Bank(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void display() {
        System.out.println("\n Account Details ");
        System.out.println("Customer Name : " + name);
        System.out.println("Balance       : " + balance);
    }
}

public class Banksystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();

        Bank b1 = new Bank(name, balance);

        b1.display();

    }
}
