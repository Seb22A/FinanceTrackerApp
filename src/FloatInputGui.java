import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FloatInputGui extends JFrame {

    private JTextField textField1, textField2, textField3, textField4, monthlyDepositField, totalInterestField, totalDepositedField;
    private JTextField bankAmountField, incomeField, spentField;
    private JLabel resultLabel;
    public static Interest interest = new Interest();

    // Radio buttons for interest type
    private JRadioButton yearlyButton, monthlyButton, dailyButton;

    public FloatInputGui() {
        setTitle("User Finance and Interest Calculation");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(14, 2)); // Adjusted for additional fields

        // User Finance Section
        add(new JLabel("User Finance", SwingConstants.CENTER));
        add(new JLabel()); // Placeholder for grid alignment

        add(new JLabel("Current Bank Amount:"));
        bankAmountField = new JTextField();
        add(bankAmountField);

        add(new JLabel("Income:"));
        incomeField = new JTextField();
        add(incomeField);

        add(new JLabel("Spent This Month:"));
        spentField = new JTextField();
        add(spentField);

        // Interest Calculation Section
        add(new JLabel("Interest Calculation", SwingConstants.CENTER));
        add(new JLabel()); // Placeholder for grid alignment

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

        add(new JLabel("Monthly Deposit:"));
        monthlyDepositField = new JTextField();
        add(monthlyDepositField);

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

        monthlyDepositField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    float monthlyDeposit = Float.parseFloat(monthlyDepositField.getText());
                    if (monthlyDeposit > 0) {
                        monthlyButton.setSelected(true);
                    }
                } catch (NumberFormatException ex) {
                    // Ignore invalid input, as it will be handled in getFloats
                }
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

            // If the monthly deposit field is not empty, include it in the calculation
            if (!monthlyDepositField.getText().isEmpty()) {
                float monthlyDeposit = Float.parseFloat(monthlyDepositField.getText());
                interest.setMonthlyDeposit(monthlyDeposit);

                // Auto-select the monthly interest type if a positive value is provided
                if (monthlyDeposit > 0) {
                    monthlyButton.setSelected(true);
                }
            } else {
                interest.setMonthlyDeposit(0);  // If empty, set monthly deposit to 0
            }

            String interestType = "";
            if (yearlyButton.isSelected()) {
                interestType = "Yearly";
            } else if (monthlyButton.isSelected()) {
                interestType = "Monthly";
            } else if (dailyButton.isSelected()) {
                interestType = "Daily";
            }

            String result = new MakeWork().CalculateInterest(interestType);
            resultLabel.setText(result);

            totalInterestField.setText(String.valueOf(interest.getTotalAccruedInterest()));
            totalDepositedField.setText(String.valueOf(interest.getTotalDeposited()));

        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        new FloatInputGui();
    }
}