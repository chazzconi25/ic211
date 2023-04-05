public class Calculator {
    private int months = 0;
    private double total = 0;
    public void mToPay(double amount, double rate, double payment) {
        while(amount > 0) {
            months++;
            double interest = amount * rate/1200;
            payment + interest;
            amount = amount - payment - interest;
        }
    }

    public static void main(String [] args) {
        Calculator test = new Calculator();
        test.mToPay(Double.parseDouble(args[0]), Double.parseDouble(args[1]),
                    Double.parseDouble(args[2]));
        System.out.println("months = " + test.months + " cost = " + test.total);
    }
}
