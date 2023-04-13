/**
 * This supporting  class creates a Calc object which when given a loan
 * amount, rate, and payment stores the length and cost of the loan.
 * @author Francesconi, Charlie
 */
public class Calc {
    private int months;
    private double cost;

    /**
     * Initalizes a new Calc object which sets the months and cost fields
     * of this object to the length and cost of the loan. If the loan is
     * unpayable then throw UnpayableLoanException.
     * @param amount the intital value of the loan
     * @param rate monthly intrest rate of the loan
     * @param payment monthly payment on the loan
     * @throws UnpayableLoanException if loan is unpayable
     */
    public void calcLoan(double amount, double rate, double payment)
        throws UnpayableLoanException {
        double interest = 0;
        double balance = amount;
        double totalPaid = 0;
        if(balance + (balance * rate/1200) - payment >= balance) {
            throw new UnpayableLoanException("Unpayable loan");
        }
        while(balance > 0) {
            months++;
            interest = balance * rate/1200;
            balance += interest;
            balance -= payment;
            totalPaid += payment;
        }
        cost = Math.round((totalPaid + balance - amount)*100.0)/100.0;
    }

    /**
     * Returns the length of this loan. I initially had this as a static method
     * that would calculate the months given amount, rate and payment to avoid
     * having a getter method. This ended up causing there to be two of the same
     * methods to calculate length and cost so I thought that was bad design
     * and just went with a getter instead even though those are taboo in this
     * class
     * @return the length of this loan in months
     */
    public int getMonths() {
        return months;
    }

    /**
     * Returns the length of this loan. I initially had this as a static method
     * that would calculate the months given amount, rate and payment to avoid
     * having a getter method. This ended up causing there to be two of the same
     * methods to calculate length and cost so I thought that was bad design
     * and just went with a getter instead even though those are taboo in this
     * class
     * @return the cost of the loan
     */
    public double getCost() {
        return cost;
    }

    /**
     * Tests this Calc class by taking in amount, rate and payment from the cmd
     * line
     * @param args amount, rate, and payment for this Calc
     * @throws UnpayableLoanException throws UnpayableLoanException if given
     * args produce an unpayable loan.
     */
    public static void main(String [] args) throws UnpayableLoanException {
        double amount = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        double payment = Double.parseDouble(args[2]);
        Calc c = new Calc();
        c.calcLoan(amount, rate, payment);
        System.out.println("months = " + c.months 
                            + " cost = " + c.months);
    }
}
