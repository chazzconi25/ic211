import java.awt.event.*;

class ConverterActionListener implements ActionListener {
  private Converter cw;
  public ConverterActionListener(Converter cw) {
    this.cw = cw;
  }

  public void actionPerformed(ActionEvent e) {
    // Response to any action is to update toValue based
    // on the values of fromUnits, toUnits and fromValue.
    cw.setToValue(
      cw.getFromValue() * cw.getFromCF() / cw.getToCF()
      );
  }
}