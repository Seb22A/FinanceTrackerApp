import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FloatInputGui extends JFrame {

    private JTextField textField1, textField2, textField3, textField4, totalInterestField, totalDepositedField;
    private JLabel resultLabel;
    public static Interest interest = new Interest();

    // Radio buttons for interest type
    private JRadioButton yearlyButton, monthlyButton, dailyButton;

    public FloatInputGui() {
        setTitle("Float Input GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2));

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

        // Radio buttons for interest type
        yearlyButton = new JRadioButton("Yearly");
        monthlyButton = new JRadioButton("Monthly");
        dailyButton = new JRadioButton("Daily");

        // Grouping the radio buttons so only one can be selected at a time
        ButtonGroup interestTypeGroup = new ButtonGroup();
        interestTypeGroup.add(yearlyButton);
        interestTypeGroup.add(monthlyButton);
        interestTypeGroup.add(dailyButton);

        add(new JLabel("Interest Type:"));
        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.add(yearlyButton);
        radioPanel.add(monthlyButton);
        radioPanel.add(dailyButton);
        add(radioPanel);

        // Add a button to perform the calculation
        JButton calculateButton = new JButton("Calculate Sum");
        add(calculateButton);

        // Add a label to display the result
        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        // Add fields to display total accrued interest and total deposited
        add(new JLabel("Total Accrued Interest:"));
        totalInterestField = new JTextField();
        totalInterestField.setEditable(false); // This field is not editable by the user
        add(totalInterestField);

        add(new JLabel("Total Deposited:"));
        totalDepositedField = new JTextField();
        totalDepositedField.setEditable(false); // This field is not editable by the user
        add(totalDepositedField);

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

            String interestType = "";
            if (yearlyButton.isSelected()) {
                interestType = "Yearly";
            } else if (monthlyButton.isSelected()) {
                interestType = "Monthly";
            } else if (dailyButton.isSelected()) {
                interestType = "Daily";
            }

            // Assuming CalculateInterest() now accepts interest type and returns a formatted string
            String result = new MakeWork().CalculateInterest(interestType);
            resultLabel.setText(result);

            // Assuming CalculateInterest() also updates the interest object with total values
            totalInterestField.setText(String.valueOf(interest.getTotalAccruedInterest()));
            totalDepositedField.setText(String.valueOf(interest.getTotalDeposited()));

        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid floats.");
        }
    }


}