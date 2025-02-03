package view;

import model.Training;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class AddTrainingDialog extends BaseDialog {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    private JTextField titleField;
    private JFormattedTextField dateFromField;
    private JFormattedTextField dateToField;
    private JTextField numberOfHoursField;
    private JTextField typeOfLdField;
    private JTextField conductedByField;
    private JButton okButton;
    private JButton cancelButton;
    private Training training;

    // Two constructors: one for adding, one for editing an existing training
    public AddTrainingDialog(Frame parent, boolean modal) {
        this(parent, modal, null);
    }

    public AddTrainingDialog(Frame parent, boolean modal, Training trainingToEdit) {
        super(parent, modal);
        this.training = trainingToEdit;
        initializeComponents();
        if (trainingToEdit != null) {
            populateFields();
            setTitle("Edit Training");
        } else {
            setTitle("Add Training");
        }
    }

    private void initializeComponents() {
        // Main panel with BorderLayout and padding
        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(24, 24, 24, 24));

        // Header label
        JLabel headerLabel = createLabel(getTitle());
        headerLabel.setFont(TITLE_FONT);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Form panel using GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(BACKGROUND_COLOR);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.weightx = 1.0;
        int gridY = 0;

        // Title of Learning and Development
        addFormField(formPanel, "Title of Learning and Development:",
                titleField = createTextField(), gbc, gridY++);

        // Date From
        addFormField(formPanel, "Date From (MM/dd/yyyy):",
                dateFromField = createDateField(), gbc, gridY++);

        // Date To
        addFormField(formPanel, "Date To (MM/dd/yyyy):",
                dateToField = createDateField(), gbc, gridY++);

        // Number of Hours
        addFormField(formPanel, "Number of Hours:",
                numberOfHoursField = createTextField(), gbc, gridY++);

        // Type of LD
        addFormField(formPanel, "Type of LD:",
                typeOfLdField = createTextField(), gbc, gridY++);

        // Conducted/Sponsored By
        addFormField(formPanel, "Conducted/Sponsored By:",
                conductedByField = createTextField(), gbc, gridY++);

        // Add the form panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBorder(null);
        scrollPane.setBackground(BACKGROUND_COLOR);
        scrollPane.getViewport().setBackground(BACKGROUND_COLOR);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Buttons panel at the bottom
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        buttonPanel.setBackground(BACKGROUND_COLOR);
        okButton = createPrimaryButton("OK");
        cancelButton = createSecondaryButton("Cancel");

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set dialog content
        setContentPane(mainPanel);
        setResizable(true);
        setupEventListeners();
        pack();
        setLocationRelativeTo(getParent());
    }

    // Helper method to add a label and its corresponding field using GridBagLayout
    private void addFormField(JPanel panel, String labelText, JComponent field,
            GridBagConstraints gbc, int gridy) {
        JLabel label = createLabel(labelText);
        gbc.gridy = gridy * 2;
        panel.add(label, gbc);
        gbc.gridy = gridy * 2 + 1;
        panel.add(field, gbc);
    }

    private void setupEventListeners() {
        okButton.addActionListener(e -> {
            if (validateInput()) {
                updateModelFromFields();
                dispose();
            }
        });
        cancelButton.addActionListener(e -> {
            training = null;
            dispose();
        });
    }

    private boolean validateInput() {
        if (titleField.getText().trim().isEmpty()) {
            showError("Please enter the title.");
            titleField.requestFocus();
            return false;
        }
        if (dateFromField.getText().trim().isEmpty() || parseDate(dateFromField.getText()) == null) {
            showError("Please enter a valid Date From.");
            dateFromField.requestFocus();
            return false;
        }
        if (dateToField.getText().trim().isEmpty() || parseDate(dateToField.getText()) == null) {
            showError("Please enter a valid Date To.");
            dateToField.requestFocus();
            return false;
        }
        LocalDate fromDate = parseDate(dateFromField.getText());
        LocalDate toDate = parseDate(dateToField.getText());
        if (fromDate != null && toDate != null && fromDate.isAfter(toDate)) {
            showError("Date From cannot be after Date To.");
            dateFromField.requestFocus();
            return false;
        }
        // Additional validations can be added here
        return true;
    }

    private LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString, dateFormatter);
        } catch (DateTimeParseException ex) {
            showError("Invalid date format. Please use MM/dd/yyyy.");
            return null;
        }
    }

    // If desired, you can move showError to BaseDialog so all dialogs share it.
    private void showError(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    // Implementation of the abstract method from BaseDialog.
    @Override
    protected void populateFields() {
        if (training != null) {
            titleField.setText(training.getTitle());
            // Convert LocalDate to Date before setting on JFormattedTextField.
            if (training.getDateFrom() != null) {
                dateFromField.setValue(Date.from(training.getDateFrom()
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
            if (training.getDateTo() != null) {
                dateToField.setValue(Date.from(training.getDateTo()
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
            numberOfHoursField.setText(String.valueOf(training.getNumberOfHours()));
            typeOfLdField.setText(training.getTypeOfLd());
            conductedByField.setText(training.getConductedBy());
        }
    }

    // Implementation of the abstract method from BaseDialog.
    @Override
    protected void updateModelFromFields() {
        if (training == null) {
            training = new Training();
        }
        training.setTitle(titleField.getText().trim());
        training.setDateFrom(parseDate(dateFromField.getText()));
        training.setDateTo(parseDate(dateToField.getText()));
        try {
            training.setNumberOfHours(Integer.parseInt(numberOfHoursField.getText().trim()));
        } catch (NumberFormatException ex) {
            showError("Invalid number format for Number of Hours.");
        }
        training.setTypeOfLd(typeOfLdField.getText().trim());
        training.setConductedBy(conductedByField.getText().trim());
    }

    public Training getTraining() {
        return training;
    }
}
