package view;

import model.Child;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class AddChildDialog extends JDialog {

    private static final Color PRIMARY_COLOR = new Color(59, 130, 246);    // Blue
    private static final Color BACKGROUND_COLOR = new Color(249, 250, 251); // Light gray
    private static final Color TEXT_COLOR = new Color(31, 41, 55);         // Dark gray
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 16);
    private static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 13);
    private static final Font INPUT_FONT = new Font("Arial", Font.PLAIN, 14);

    private JTextField nameField;
    private JFormattedTextField dobField;
    private JButton okButton;
    private JButton cancelButton;
    private Child child;

    public AddChildDialog(Frame parent, boolean modal) {
        this(parent, modal, null);
    }

    public AddChildDialog(Frame parent, boolean modal, Child childToEdit) {
        super(parent, modal);
        this.child = childToEdit;
        initializeComponents();
        if (childToEdit != null) {
            populateFields();
            setTitle("Edit Child");
        } else {
            setTitle("Add New Child");
        }
    }

    private void initializeComponents() {
        // Main panel setup
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 20));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(24, 24, 24, 24));

        // Header
        JLabel headerLabel = new JLabel(getTitle());
        headerLabel.setFont(TITLE_FONT);
        headerLabel.setForeground(TEXT_COLOR);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(BACKGROUND_COLOR);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 0, 8, 0);

        // Name field
        JLabel nameLabel = createLabel("Name");
        nameField = createTextField();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        formPanel.add(nameLabel, gbc);

        gbc.gridy = 1;
        formPanel.add(nameField, gbc);

        // Date of birth field
        JLabel dobLabel = createLabel("Date of Birth");
        dobField = createDateField();

        gbc.gridy = 2;
        formPanel.add(dobLabel, gbc);

        gbc.gridy = 3;
        formPanel.add(dobField, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        buttonPanel.setBackground(BACKGROUND_COLOR);

        cancelButton = createSecondaryButton("Cancel");
        okButton = createPrimaryButton("Save");

        buttonPanel.add(cancelButton);
        buttonPanel.add(okButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Dialog setup
        setContentPane(mainPanel);
        setResizable(false);
        setupEventListeners();
        pack();
        setSize(400, 300);
        setLocationRelativeTo(getParent());
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(LABEL_FONT);
        label.setForeground(TEXT_COLOR);
        return label;
    }

    private JTextField createTextField() {
        JTextField field = new JTextField();
        field.setFont(INPUT_FONT);
        field.setPreferredSize(new Dimension(200, 32));
        return field;
    }

    private JFormattedTextField createDateField() {
        JFormattedTextField field = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy"));
        field.setFont(INPUT_FONT);
        field.setPreferredSize(new Dimension(200, 32));
        field.setToolTipText("Format: MM/DD/YYYY");
        return field;
    }

    private JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 36));
        return button;
    }

    private JButton createSecondaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(BACKGROUND_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(TEXT_COLOR));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(100, 36));
        return button;
    }

    private void setupEventListeners() {
        okButton.addActionListener(e -> {
            if (validateInput()) {
                saveChild();
                dispose();
            }
        });

        cancelButton.addActionListener(e -> {
            child = null;
            dispose();
        });
    }

    private boolean validateInput() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            showError("Please enter a name.");
            nameField.requestFocus();
            return false;
        }

        if (dobField.getValue() == null) {
            showError("Please enter a valid date of birth.");
            dobField.requestFocus();
            return false;
        }

        return true;
    }

    private void saveChild() {
        if (child == null) {
            child = new Child();
        }
        child.setName(nameField.getText().trim());

        Object dobValue = dobField.getValue();
        if (dobValue instanceof Date) {
            Date date = (Date) dobValue;
            LocalDate localDate = date.toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();
            child.setDateOfBirth(localDate);
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private void populateFields() {
        nameField.setText(child.getName());
        if (child.getDateOfBirth() != null) {
            Date date = Date.from(
                    child.getDateOfBirth()
                            .atStartOfDay(java.time.ZoneId.systemDefault())
                            .toInstant()
            );
            dobField.setValue(date);
        }
    }

    public Child getChild() {
        return child;
    }
}
