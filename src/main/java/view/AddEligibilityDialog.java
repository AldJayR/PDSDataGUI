package view;

import model.Eligibility;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class AddEligibilityDialog extends BaseDialog {

    private Eligibility eligibility;
    private JTextField careerServiceField;
    private JTextField ratingField;
    private JFormattedTextField dateOfExaminationField;
    private JTextField placeOfExaminationField;
    private JTextField licenseNumberField;
    private JFormattedTextField licenseValidityDateField;
    private JButton okButton;
    private JButton cancelButton;

    // Two constructors: one for new eligibility, one for editing an existing one.
    public AddEligibilityDialog(Frame parent, boolean modal) {
        this(parent, modal, null);
    }

    public AddEligibilityDialog(Frame parent, boolean modal, Eligibility eligibilityToEdit) {
        super(parent, modal);
        this.eligibility = eligibilityToEdit;
        initializeComponents();
        if (eligibilityToEdit != null) {
            populateFields();
            setTitle("Edit Eligibility");
        } else {
            setTitle("Add New Eligibility");
        }
    }

    private void initializeComponents() {
        // Main panel setup
        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
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

        // Career Service
        addFormField(formPanel, "Career Service", careerServiceField = createTextField(), gbc, gridY++);

        // Rating
        addFormField(formPanel, "Rating", ratingField = createTextField(), gbc, gridY++);

        // Date of Examination
        addFormField(formPanel, "Date of Examination", dateOfExaminationField = createDateField(), gbc, gridY++);

        // Place of Examination
        addFormField(formPanel, "Place of Examination", placeOfExaminationField = createTextField(), gbc, gridY++);

        // License Number
        addFormField(formPanel, "License Number", licenseNumberField = createTextField(), gbc, gridY++);

        // License Validity Date
        addFormField(formPanel, "License Validity Date", licenseValidityDateField = createDateField(), gbc, gridY++);

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

        // Set the dialog content and configuration
        setContentPane(mainPanel);
        setResizable(true);
        setupEventListeners();
        pack();
        setSize(500, 600);
        setLocationRelativeTo(getParent());
    }

    // Helper method to add a label-field pair using GridBagLayout.
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
            eligibility = null;
            dispose();
        });
    }

    private boolean validateInput() {
        if (careerServiceField.getText().trim().isEmpty()) {
            showError("Please enter the Career Service.");
            careerServiceField.requestFocus();
            return false;
        }

        if (ratingField.getText().trim().isEmpty()) {
            showError("Please enter the Rating.");
            ratingField.requestFocus();
            return false;
        }

        if (dateOfExaminationField.getValue() == null) {
            showError("Please enter a valid Date of Examination.");
            dateOfExaminationField.requestFocus();
            return false;
        }

        if (placeOfExaminationField.getText().trim().isEmpty()) {
            showError("Please enter the Place of Examination.");
            placeOfExaminationField.requestFocus();
            return false;
        }

        if (licenseNumberField.getText().trim().isEmpty()) {
            showError("Please enter the License Number.");
            licenseNumberField.requestFocus();
            return false;
        }

        if (licenseValidityDateField.getValue() == null) {
            showError("Please enter a valid License Validity Date.");
            licenseValidityDateField.requestFocus();
            return false;
        }

        return true;
    }

    // You can keep this method locally or move it to BaseDialog if it's shared among dialogs.
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
        if (eligibility != null) {
            careerServiceField.setText(eligibility.getCareerService());
            ratingField.setText(eligibility.getRating());

            LocalDate examDate = eligibility.getDateOfExamination();
            LocalDate validityDate = eligibility.getLicenseDateOfValidity();

            dateOfExaminationField.setValue((examDate != null)
                    ? Date.from(examDate.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null);

            licenseValidityDateField.setValue((validityDate != null)
                    ? Date.from(validityDate.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null);

            placeOfExaminationField.setText(eligibility.getPlaceOfExamination());
            licenseNumberField.setText(eligibility.getLicenseNumber());
        }
    }

    // Implementation of the abstract method from BaseDialog.
    @Override
    protected void updateModelFromFields() {
        if (eligibility == null) {
            eligibility = new Eligibility();
        }
        eligibility.setCareerService(careerServiceField.getText().trim());
        eligibility.setRating(ratingField.getText().trim());

        // Convert Date to LocalDate
        Date examDate = (dateOfExaminationField.getValue() instanceof Date)
                ? (Date) dateOfExaminationField.getValue() : null;
        Date validityDate = (licenseValidityDateField.getValue() instanceof Date)
                ? (Date) licenseValidityDateField.getValue() : null;

        LocalDate localExamDate = (examDate != null)
                ? examDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate localValidityDate = (validityDate != null)
                ? validityDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;

        eligibility.setDateOfExamination(localExamDate);
        eligibility.setLicenseDateOfValidity(localValidityDate);

        eligibility.setPlaceOfExamination(placeOfExaminationField.getText().trim());
        eligibility.setLicenseNumber(licenseNumberField.getText().trim());
    }

    public Eligibility getEligibility() {
        return eligibility;
    }
}
