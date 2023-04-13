import java.awt.event.*;

/**
 * This implementation of action listner ensures that the LoanFrame with a
 * Responder object can identify and react to button clicks as well as set
 * the cursor to the initial box to prompt the user for a new loan amount
 * @author Franecsconi, Charlie
 */
public class Responder implements ActionListener {
  private LoanFrame f;

  /**
   * Constructor attaches this Responder to a given LoanFrame
   * @param f Loan Frame that this Responder should be lisening to
   */
  public Responder(LoanFrame f) {
    this.f = f;
  }

  /**
   * When the user submits a loan for calculation update the months and cost
   * accordingly as well as update the cursor location.
   */
  public void actionPerformed(ActionEvent e) {
    f.recalculate();
    f.resetFocus();
  }
}