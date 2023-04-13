public class Calc {
    public static double cost(double amount, double rate, double payment) {
        double interest = 0;
        double balance = amount;
        double totalPaid = 0;
        while(balance > 0) {
            interest = balance * rate/1200;
            balance += interest;
            balance -= payment;
            totalPaid += payment;
        }
        return Math.round((totalPaid + balance - amount)*100.0)/100.0;
    }

    public static int mToPay(double amount, double rate, double payment) {
        int months = 0;
        double interest = 0;
        double balance = amount;
        while(balance > 0) {
            months++;
            interest = balance * rate/1200;
            balance += interest;
            balance -= payment;
        }
        return months;
    }

    public static void main(String [] args) {
        double amount = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        double payment = Double.parseDouble(args[2]);
        System.out.println("months = " + mToPay(amount, rate, payment) 
                            + " cost = " + cost(amount, rate, payment));
    }
}
