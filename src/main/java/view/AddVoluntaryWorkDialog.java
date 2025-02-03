package view;

import model.VoluntaryWork;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class AddVoluntaryWorkDialog extends BaseDialog {

    // Date formatter for parsing and formatting strings
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    private JTextField organizationNameField;
    private JTextField organizationAddressField;
    private JFormattedTextField dateFromField;
    private JFormattedTextField dateToField;
    private JTextField numberOfHoursField;
    private JTextField positionNatureOfWorkField;
    private JButton okButton;
    private JButton cancelButton;
    private VoluntaryWork voluntaryWork;

    // Constructors
    public AddVoluntaryWorkDialog(Frame parent, boolean modal) {
        this(parent, modal, null);
    }

    public AddVoluntaryWorkDialog(Frame parent, boolean modal, VoluntaryWork voluntaryWorkToEdit) {
        super(parent, modal);
        this.voluntaryWork = voluntaryWorkToEdit;
        initializeComponents();
        if (voluntaryWorkToEdit != null) {
            populateFields();
            setTitle("Edit Voluntary Work");
        } else {
            setTitle("Add Voluntary Work");
        }
    }

    private void initializeComponents() {
        // Create a main panel with a border layout and add padding
        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(24, 24, 24, 24));

        // Header
        JLabel headerLabel = createLabel(getTitle());
        headerLabel.setFont(TITLE_FONT);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Form panel using GridBagLayout for flexible layout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(BACKGROUND_COLOR);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.weightx = 1.0;
        int gridY = 0;

        // Organization Name
        addFormField(formPanel, "Name of Organization:", organizationNameField = createTextField(), gbc, gridY++);
        // Organization Address
        addFormField(formPanel, "Address of Organization:", organizationAddressField = createTextField(), gbc, gridY++);
        // Date From
        addFormField(formPanel, "Date From (MM/dd/yyyy):", dateFromField = createDateField(), gbc, gridY++);
        // Date To
        addFormField(formPanel, "Date To (MM/dd/yyyy):", dateToField = createDateField(), gbc, gridY++);
        // Number of Hours
        addFormField(formPanel, "Number of Hours:", numberOfHoursField = createTextField(), gbc, gridY++);
        // Position/Nature of Work
        addFormField(formPanel, "Position/Nature of Work:", positionNatureOfWorkField = createTextField(), gbc, gridY++);

        // Add the form panel to a scroll pane in case there is a lot of content
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBorder(null);
        scrollPane.setBackground(BACKGROUND_COLOR);
        scrollPane.getViewport().setBackground(BACKGROUND_COLOR);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Buttons panel
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
            voluntaryWork = null;
            dispose();
        });
    }

    private boolean validateInput() {
        if (organizationNameField.getText().trim().isEmpty()) {
            showError("Please enter the Name of Organization.");
            organizationNameField.requestFocus();
            return false;
        }
        if (organizationAddressField.getText().trim().isEmpty()) {
            showError("Please enter the Address of Organization.");
            organizationAddressField.requestFocus();
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
        if (voluntaryWork != null) {
            organizationNameField.setText(voluntaryWork.getOrganizationName());
            organizationAddressField.setText(voluntaryWork.getOrganizationAddress());
            // Convert LocalDate to Date before setting the value.
            if (voluntaryWork.getDateFrom() != null) {
                dateFromField.setValue(Date.from(voluntaryWork.getDateFrom()
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
            if (voluntaryWork.getDateTo() != null) {
                dateToField.setValue(Date.from(voluntaryWork.getDateTo()
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
            numberOfHoursField.setText(String.valueOf(voluntaryWork.getNumberOfHours()));
            positionNatureOfWorkField.setText(voluntaryWork.getPositionNatureOfWork());
        }
    }

    // Implementation of the abstract method from BaseDialog.
    @Override
    protected void updateModelFromFields() {
        if (voluntaryWork == null) {
            voluntaryWork = new VoluntaryWork();
        }
        voluntaryWork.setOrganizationName(organizationNameField.getText().trim());
        voluntaryWork.setOrganizationAddress(organizationAddressField.getText().trim());
        voluntaryWork.setDateFrom(parseDate(dateFromField.getText()));
        voluntaryWork.setDateTo(parseDate(dateToField.getText()));
        try {
            voluntaryWork.setNumberOfHours(Integer.parseInt(numberOfHoursField.getText().trim()));
        } catch (NumberFormatException ex) {
            showError("Invalid number format for Number of Hours.");
        }
        voluntaryWork.setPositionNatureOfWork(positionNatureOfWorkField.getText().trim());
    }

    public VoluntaryWork getVoluntaryWork() {
        return voluntaryWork;
    }
}
