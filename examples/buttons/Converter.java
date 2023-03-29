//javac Converter.java to compile
//java Converter.java to run
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*; 

public class Converter extends JFrame{
    // TODO: place JTextFields and JComboBox fields here: fromValue, toValue, fromUnits, toUnits
    JTextField fromValue;

    JComboBox<String> formUnits;

    // units
    private final String [] units = {"feet", "miles"};
    private final double[] conversionMath = {1.0, 1.0/5280}; //ft->miles, miles->ft

    // constructor
    public Converter() {
        // TODO: initialize textfields, combobox
        fromValue = new JTextField("1.0", 10);//TODO initialize textfield with "1.0" and 10
        toValue   = //TODO initialize textfield with "1.0" and 10
        fromUnits = new JComboBox<String>(units);//TODO initialize with units
        toUnits   = //TODO initialize with units

        // TODO: create panel and add labels, etc
        JPanel panel = 


        // initialize listener
        ActionListener a = new ConverterActionListener(this);
        // TODO: if have not done so, look at converteractionlistener
        // TODO: add listener to gui items


        // adding panel to frame
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    // methods needed for conversion:
    public double getFromValue() {
        return Double.parseDouble(fromValue.getText());
    }
    
    public double getFromCF() {
        return getCF((String)fromUnits.getSelectedItem());
    }

    public double getToCF() {
        return getCF((String)toUnits.getSelectedItem());
    }

    public void setToValue(double x) {
        toValue.setText("" + Math.round(x * 10000) / 10000.0);
    }

    private double getCF(String u) {
        int i = 0;

        while (i < units.length && !units[i].equals(u)) {
            ++i;
        }

        return conversionMath[i];
    }

    // try code above ... 
    public static void main(String[] args) {
        Converter w = new Converter();
        w.setVisible(true);
    }
}
