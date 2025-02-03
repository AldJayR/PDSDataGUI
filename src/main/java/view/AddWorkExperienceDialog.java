package view;

import model.WorkExperience;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.time.ZoneId;


public class AddWorkExperienceDialog extends BaseDialog {

    private static final Color PRIMARY_COLOR = new Color(59, 130, 246);    // Blue
    private static final Color BACKGROUND_COLOR = new Color(249, 250, 251); // Light gray
    private static final Color TEXT_COLOR = new Color(31, 41, 55);         // Dark gray
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 16);
    private static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 13);
    private static final Font INPUT_FONT = new Font("Arial", Font.PLAIN, 14);

    private JTextField positionTitleField;
    private JTextField departmentAgencyOfficeCompanyField;
    private JTextField monthlySalaryField;
    private JTextField salaryGradeStepIncrementField;
    private JTextField statusOfAppointmentField;
    private JCheckBox governmentServiceCheckBox;
    private JFormattedTextField dateFromField;
    private JFormattedTextField dateToField;
    private JButton okButton;
    private JButton cancelButton;
    private WorkExperience workExperience;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public AddWorkExperienceDialog(Frame parent, boolean modal) {
        this(parent, modal, null);
    }

    public AddWorkExperienceDialog(Frame parent, boolean modal, WorkExperience workExperienceToEdit) {
        super(parent, modal);
        this.workExperience = workExperienceToEdit;
        initializeComponents();
        if (workExperienceToEdit != null) {
            populateFields();
            setTitle("Edit Work Experience");
        } else {
            setTitle("Add New Work Experience");
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
        gbc.weightx = 1.0;

        int gridY = 0;

        // Position Title
        addFormField(formPanel, "Position Title",
                positionTitleField = createTextField(), gbc, gridY++);

        // Department/Agency/Office/Company
        addFormField(formPanel, "Department/Agency/Office/Company",
                departmentAgencyOfficeCompanyField = createTextField(), gbc, gridY++);

        // Monthly Salary
        addFormField(formPanel, "Monthly Salary",
                monthlySalaryField = createTextField(), gbc, gridY++);

        // Salary Grade & Step Increment
        addFormField(formPanel, "Salary Grade & Step Increment",
                salaryGradeStepIncrementField = createTextField(), gbc, gridY++);

        // Status of Appointment
        addFormField(formPanel, "Status of Appointment",
                statusOfAppointmentField = createTextField(), gbc, gridY++);

        // Government Service Checkbox
        JPanel checkboxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        checkboxPanel.setBackground(BACKGROUND_COLOR);
        governmentServiceCheckBox = createCheckBox("Government Service");
        checkboxPanel.add(governmentServiceCheckBox);
        addFormField(formPanel, "", checkboxPanel, gbc, gridY++);

        // Date Range Panel
        JPanel dateRangePanel = new JPanel(new GridBagLayout());
        dateRangePanel.setBackground(BACKGROUND_COLOR);
        GridBagConstraints dateGbc = new GridBagConstraints();
        dateGbc.fill = GridBagConstraints.HORIZONTAL;
        dateGbc.weightx = 1.0;
        dateGbc.insets = new Insets(0, 0, 0, 8);

        // Date From
        dateGbc.gridx = 0;
        addFormField(dateRangePanel, "Date From",
                dateFromField = createDateField(), dateGbc, 0);

        // Date To
        dateGbc.gridx = 1;
        dateGbc.insets = new Insets(0, 8, 0, 0);
        addFormField(dateRangePanel, "Date To",
                dateToField = createDateField(), dateGbc, 0);

        gbc.gridy = gridY * 2;
        formPanel.add(dateRangePanel, gbc);

        // Add form panel to scroll pane
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBorder(null);
        scrollPane.setBackground(BACKGROUND_COLOR);
        scrollPane.getViewport().setBackground(BACKGROUND_COLOR);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

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
        setResizable(true);
        setupEventListeners();
        pack();
        setSize(600, 700);
        setLocationRelativeTo(getParent());
    }

    private void addFormField(JPanel panel, String labelText, JComponent field,
            GridBagConstraints gbc, int gridy) {
        if (!labelText.isEmpty()) {
            JLabel label = createLabel(labelText);
            gbc.gridy = gridy * 2;
            panel.add(label, gbc);
        }

        gbc.gridy = gridy * 2 + 1;
        panel.add(field, gbc);
    }

    private JCheckBox createCheckBox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(INPUT_FONT);
        checkBox.setBackground(BACKGROUND_COLOR);
        checkBox.setForeground(TEXT_COLOR);
        return checkBox;
    }

    private void setupEventListeners() {
        okButton.addActionListener(e -> {
            if (validateInput()) {
                updateModelFromFields();
                dispose();
            }
        });

        cancelButton.addActionListener(e -> {
            workExperience = null;
            dispose();
        });
    }

    private boolean validateInput() {
        if (positionTitleField.getText().trim().isEmpty()) {
            showError("Please enter the Position Title.");
            positionTitleField.requestFocus();
            return false;
        }

        if (departmentAgencyOfficeCompanyField.getText().trim().isEmpty()) {
            showError("Please enter the Department/Agency/Office/Company.");
            departmentAgencyOfficeCompanyField.requestFocus();
            return false;
        }

        if (monthlySalaryField.getText().trim().isEmpty()) {
            showError("Please enter the Monthly Salary.");
            monthlySalaryField.requestFocus();
            return false;
        }

        if (statusOfAppointmentField.getText().trim().isEmpty()) {
            showError("Please enter the Status of Appointment.");
            statusOfAppointmentField.requestFocus();
            return false;
        }

        if (dateFromField.getText().trim().isEmpty() || parseDate(dateFromField.getText()) == null) {
            showError("Please enter a valid Start Date.");
            dateFromField.requestFocus();
            return false;
        }

        if (dateToField.getText().trim().isEmpty() || parseDate(dateToField.getText()) == null) {
            showError("Please enter a valid End Date.");
            dateToField.requestFocus();
            return false;
        }

        LocalDate fromDate = parseDate(dateFromField.getText());
        LocalDate toDate = parseDate(dateToField.getText());
        if (fromDate != null && toDate != null && fromDate.isAfter(toDate)) {
            showError("Start Date cannot be after End Date.");
            dateFromField.requestFocus();
            return false;
        }

        return true;
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        } catch (DateTimeParseException ex) {
            return null;
        }
    }

    @Override
    protected void populateFields() {
        if (workExperience != null) {
            positionTitleField.setText(workExperience.getPositionTitle());
            departmentAgencyOfficeCompanyField.setText(workExperience.getDepartmentAgencyOfficeCompany());
            monthlySalaryField.setText(workExperience.getMonthlySalary());
            salaryGradeStepIncrementField.setText(workExperience.getSalaryGradeStepIncrement());
            statusOfAppointmentField.setText(workExperience.getStatusOfAppointment());
            governmentServiceCheckBox.setSelected(workExperience.isGovernmentService());

            // Set LocalDate to the field, converting it to String for display
            if (workExperience.getDateFrom() != null) {
                dateFromField.setValue(Date.from(workExperience.getDateFrom()
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
            if (workExperience.getDateTo() != null) {
                dateToField.setValue(Date.from(workExperience.getDateTo()
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
        }
    }

    @Override
    protected void updateModelFromFields() {
        if (workExperience == null) {
            workExperience = new WorkExperience();
        }
        workExperience.setPositionTitle(positionTitleField.getText().trim());
        workExperience.setDepartmentAgencyOfficeCompany(departmentAgencyOfficeCompanyField.getText().trim());
        workExperience.setMonthlySalary(monthlySalaryField.getText().trim());
        workExperience.setSalaryGradeStepIncrement(salaryGradeStepIncrementField.getText().trim());
        workExperience.setStatusOfAppointment(statusOfAppointmentField.getText().trim());
        workExperience.setGovernmentService(governmentServiceCheckBox.isSelected());
        workExperience.setDateFrom(parseDate(dateFromField.getText()));
        workExperience.setDateTo(parseDate(dateToField.getText()));
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }
}
