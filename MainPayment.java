import java.util.Scanner;

abstract class PaymentSystem{
    private double amount;
    private String paymentId;

    PaymentSystem(double amount,String paymentId)
    {
        this.amount=amount;
        this.paymentId=paymentId;
    }

    public void setAmount(double amount)
    {
        this.amount=amount;
    }

    double getAmount()
    {
        return amount;
    }

    public void setPaymentId(String paymentId)
    {
        this.paymentId=paymentId;
    }

    String getPaymentId()
    {
        return paymentId;
    }
    

    abstract void processPayment();

}
class CreditCard extends PaymentSystem{

    CreditCard(double amount,String paymentId)
    {
        super(amount,paymentId);
    }

    void processPayment()
    {
        if(getPaymentId().length()==16){
            System.out.println("Payment processed by credit card successfully");
        }
        else{
            System.out.println("Payment ID is wrong");
        }
    }

}
class Paypal extends PaymentSystem{

    Paypal(double amount,String paymentId)
    {
        super(amount,paymentId);
    }

    void processPayment()
    {
        if(getPaymentId().contains("@")){
            System.out.println("Payment processed by Paypal successfully");
        }
        else{
            System.out.println("Payment ID is wrong");
        }
    }
}

class UPIPayment extends PaymentSystem{

    UPIPayment(double amount,String paymentId)
    {
        super(amount,paymentId);
    }

    void processPayment()
    {
        if(getPaymentId().contains("@")){
            System.out.println("Payment processed by UPI successfully");
        }
        else{
            System.out.println("Payment ID is wrong");
        }
    }
}

public class MainPayment{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type of payment: ");
        System.out.println("Enter 1 for Credit card payment");
        System.out.println("Enter 2 for Paypal Payment");
        System.out.println("Enter 3 for UPI payment");

        int type = sc.nextInt();

        System.out.println("Enter Payment ID to proceed transaction: ");
        String paymentId = sc.next();

        System.out.println("Enter the amount to proceed: ");
        double amount = sc.nextDouble();
        
        PaymentSystem pay=null;
        
        switch(type)
        {
            case 1:
                pay = new CreditCard(amount,paymentId);
                break;

            case 2:
                pay = new Paypal(amount,paymentId);
                break;

            case 3:
                pay = new UPIPayment(amount,paymentId);
                break;
                
            default:
                System.out.println("Enter a valid option");
                break;
        }  
        if(pay!=null)
        {
            pay.processPayment();
        }

        sc.close();
    }
}