interface Loan {
    void loanDetails();
    void calculateLoanAmount();
}
interface Insurance {
    void insuranceDetails();
    void insuranceStatus();
}
class SmartBank implements Loan, Insurance {
    String customerName = "Jeevagan";
    double loanAmount = 500000;
    double insuranceAmount = 1000000;
    public void loanDetails() {
        System.out.println("Loan Type       : Home Loan");
        System.out.println("Loan Amount     : ₹" + loanAmount);
    }
    public void calculateLoanAmount() {
        double interest = loanAmount * 0.08;
        double totalAmount = loanAmount + interest;
        System.out.println("Loan Interest   : ₹" + interest);
        System.out.println("Total Loan      : ₹" + totalAmount);
    }

    public void insuranceDetails() {
        System.out.println("Insurance Type  : Life Insurance");
        System.out.println("Insurance Amount: ₹" + insuranceAmount);
    }
    public void insuranceStatus() {
        System.out.println("Insurance Status: Active");
    }
    void customerDetails() {
        System.out.println("\n Smart Banking System ");
        System.out.println("Customer Name   : " + customerName);
    }
}
public class SmartBankingInterface {
    public static void main(String[] args) {
        SmartBank bank = new SmartBank();
        bank.customerDetails();
        System.out.println("\n Loan Details ");
        bank.loanDetails();
        bank.calculateLoanAmount();
        System.out.println("\n Insurance Details ");
        bank.insuranceDetails();
        bank.insuranceStatus();
    }
}
