import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Create and set up the window
        JFrame frame = new JFrame("MotorPH Employee App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(823, 476); // Set the size based on the provided image

        // Create the main panel with BorderLayout to hold header, menu, and content panels
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 128, 0)); // Green background for the header
        JLabel headerLabel = new JLabel("PAYROLL SYSTEM", JLabel.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        headerPanel.setPreferredSize(new Dimension(frame.getWidth(), 50)); // Set preferred size for the header

        // Menu panel for input fields and buttons
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(new Color(0, 128, 0)); // Green background for the menu
        menuPanel.setPreferredSize(new Dimension(150, frame.getHeight())); // Set preferred size for the menu

        // Employee ID input
        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setForeground(Color.WHITE);
        JTextField idField = new JTextField(15);
        menuPanel.add(idLabel);
        menuPanel.add(idField);

        // Employee Name input
        JLabel nameLabel = new JLabel("Employee Name:");
        nameLabel.setForeground(Color.WHITE);
        JTextField nameField = new JTextField(15);
        menuPanel.add(nameLabel);
        menuPanel.add(nameField);

        // Employee Position input
        JLabel positionLabel = new JLabel("Employee Position:");
        positionLabel.setForeground(Color.WHITE);
        JTextField positionField = new JTextField(15);
        menuPanel.add(positionLabel);
        menuPanel.add(positionField);

        // Salary input
        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setForeground(Color.WHITE);
        JTextField salaryField = new JTextField(15);
        menuPanel.add(salaryLabel);
        menuPanel.add(salaryField);

        // Deduction input
        JLabel deductionLabel = new JLabel("Deduction:");
        deductionLabel.setForeground(Color.WHITE);
        JTextField deductionField = new JTextField(15);
        menuPanel.add(deductionLabel);
        menuPanel.add(deductionField);

        // Calculate Net Pay button
        JButton calculateButton = new JButton("Calculate Net Pay");
        menuPanel.add(calculateButton);

        // LogOut button
        JButton logOutButton = new JButton("LogOut");
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logout operation here
                System.exit(0); // For demonstration purposes, this will close the application
            }
        });
        menuPanel.add(logOutButton);

        // Content panel for displaying results
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE); // White background for the content
        JTextArea outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);
        contentPanel.add(outputArea);

        // Add header, menu, and content panels to the main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(menuPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Action listener for calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int employeeId = Integer.parseInt(idField.getText());
                    String employeeName = nameField.getText();
                    String employeePosition = positionField.getText();
                    double salary = Double.parseDouble(salaryField.getText());
                    double deduction = Double.parseDouble(deductionField.getText());

                    // Assuming Employee, SalaryCalculator, and EmploymentHistory classes exist and have the correct methods
                    Employee employee = new Employee(employeeId, employeeName, employeePosition);
                    SalaryCalculator calculator = new SalaryCalculator(salary, new double[]{}, new double[]{deduction});
                    double netPay = calculator.calculateNetPay();
                    EmploymentHistory history = new EmploymentHistory(employee, new Date(), new Date(), employee.getPosition(), salary - deduction);

                    // Display results
                    outputArea.setText("Employee ID: " + employee.getEmployeeID() +
                            "\nEmployee Name: " + employee.getName() +
                            "\nEmployee Position: " + employee.getPosition() +
                            "\nSalary: " + salary +
                            "\nNet Pay (Salary with Deduction): " + netPay +
                            "\nEmployment Start Date: " + history.getStartDate() +
                            "\nEmployment End Date: " + history.getEndDate() +
                            "\nEmployee Position: " + history.getPosition());
                } catch (NumberFormatException ex) {
                    outputArea.setText("Invalid input. Please enter numeric values for ID, Salary, and Deduction.");
                }
            }
        });

        // Add main panel to frame
        frame.add(mainPanel);

        // Display the window
        frame.setLocationRelativeTo(null); // Center window
        frame.setVisible(true);
    }
}
