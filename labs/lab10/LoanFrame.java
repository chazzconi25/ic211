import javax.swing.*;
import java.awt.*;

/**
 * 
 */
public class LoanFrame extends JFrame {
  private JTextField loanAmt;
  private JTextField mPayment;
  private JTextField mToPay;
  private JTextField cost;
  private JComboBox<String> rate;
  private JButton calc;
  private final String[] rates = generateRates();

  /**
   * Creates a new Calc object and calcuates the loan based on given values
   * in the fields. Catches UnpayableLoanException if loan is unpayable with
   * given values. Updates text boxes on finish.
   */
  public void recalculate() {
    try {
      double la = Double.parseDouble(loanAmt.getText());
      double mp = Double.parseDouble(mPayment.getText());
      double r = Double.parseDouble(rate.getSelectedItem().toString());
      Calc c = new Calc();
      c.calcLoan(la, r, mp);
      cost.setText("" + c.getCost()); // accidentally pyut c.getMonths() here
      mToPay.setText("" + c.getMonths());
    } catch (Exception e)    {
      cost.setText("error!");
      mToPay.setText("error!");
    }
  }
  
  /**
   * helper method to generate an array of rates to choose from
   * @return array of rates to choose from
   */
  private String[] generateRates() {
    String [] rates = new String[17];
    double baseRate = 3.5;
    for(int i = 0; i < 17; i++) {
      rates[i] = baseRate + i * 0.25 + "";
    }
    return rates;
  }

  /*
   * Sets focus to the loanAmt text field after user submits a loan for
   * calculation
   */
  public void resetFocus() {
    loanAmt.requestFocus();
  }

  /*
   * Creates a new GUI that displays fields for a loan calcuation. On clicking
   * the calculate button the GUI displays the cost and length of the loan.
   */
  public LoanFrame() {
    // create components
    JPanel top = new JPanel(new FlowLayout());
    JPanel cent = new JPanel(new FlowLayout());
    JPanel bott = new JPanel(new FlowLayout());
    JLabel loanAmtL = new JLabel("loan amount");
    JLabel rateL = new JLabel("interest rate");
    JLabel mPaymentL = new JLabel("monthly payment");
    JLabel mToPayL = new JLabel("months to payoff");
    JLabel costL = new JLabel("cost");

    loanAmt = new JTextField("10000.00", 10);
    mPayment = new JTextField("250", 10);
    mToPay = new JTextField(10);
    mToPay.setEditable(false); // only for output
    cost = new JTextField(10);
    cost.setEditable(false); // only for output
    rate = new JComboBox<String>(rates);
    calc = new JButton("calculate");
    Responder r = new Responder(this);

    // add action listeners
    calc.addActionListener(r);

    // add components to frame & ready for display
    setTitle("Francesconi, Charlie - m251806");
    add(top, BorderLayout.NORTH);
    top.add(loanAmtL);
    top.add(loanAmt);
    top.add(rateL);
    top.add(rate);
    top.add(mPaymentL);
    top.add(mPayment);
    add(cent, BorderLayout.CENTER);
    cent.add(mToPayL);
    cent.add(mToPay);
    add(calc, BorderLayout.EAST);
    add(bott, BorderLayout.SOUTH);
    bott.add(costL);
    bott.add(cost);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    resetFocus();
    pack();
  }
}

