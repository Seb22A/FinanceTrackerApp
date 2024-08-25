import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FloatInputGui extends JFrame {

    private JTextField textField1, textField2, textField3, textField4;
    private JLabel resultLabel;
    private Interest interest = new Interest();



    public FloatInputGui() {
        setTitle("Float Input GUI");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Create and add labels and text fields to the frame
        add(new JLabel("Interest Rate:"));
        textField1 = new JTextField();
        add(textField1);

        add(new JLabel("Deposit:"));
        textField2 = new JTextField();
        add(textField2);

        add(new JLabel("Years:"));
        textField3 = new JTextField();
        add(textField3);

        add(new JLabel("Months:"));
        textField4 = new JTextField();
        add(textField4);

        // Add a button to perform the calculation
        JButton calculateButton = new JButton("Calculate Sum");
        add(calculateButton);

        // Add a label to display the result
        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        // Action listener for the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFloats();
            }
        });

        setVisible(true);
    }

    // Method to calculate the sum of the float inputs
    private void getFloats() {
        try {
            interest.setInterestRate(Float.parseFloat(textField1.getText()));
            interest.setDeposited(Float.parseFloat(textField2.getText()));
            interest.setYears(Integer.parseInt(textField3.getText()));
            interest.setMonths(Integer.parseInt(textField4.getText()));
            double result = new MakeWork().CalculatedInterest();
            System.out.println(result);


           resultLabel.setText(Double.toString(result));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid floats.");
        }
    }


}