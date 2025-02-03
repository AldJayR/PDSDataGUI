package view;

import model.Eligibility;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class AddEligibilityDialog extends JDialog {

    private static final Color PRIMARY_COLOR = new Color(59, 130, 246);    // Blue
    private static final Color BACKGROUND_COLOR = new Color(249, 250, 251); // Light gray
    private static final Color TEXT_COLOR = new Color(31, 41, 55);         // Dark gray
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 16);
    private static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 13);
    private static final Font INPUT_FONT = new Font("Arial", Font.PLAIN, 14);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    private JTextField careerServiceField;
    private JTextField ratingField;
    private JFormattedTextField dateOfExaminationField;
    private JTextField placeOfExaminationField;
    private JTextField licenseNumberField;
    private JFormattedTextField licenseValidityDateField;
    private JButton okButton;
    private JButton cancelButton;
    private Eligibility eligibility;

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

        // Create and add form fields
        int gridY = 0;

        // Career Service
        addFormField(formPanel, "Career Service",
                careerServiceField = createTextField(), gbc, gridY++);

        // Rating
        addFormField(formPanel, "Rating",
                ratingField = createTextField(), gbc, gridY++);

        // Date of Examination
        addFormField(formPanel, "Date of Examination",
                dateOfExaminationField = createDateField(), gbc, gridY++);

        // Place of Examination
        addFormField(formPanel, "Place of Examination",
                placeOfExaminationField = createTextField(), gbc, gridY++);

        // License Number
        addFormField(formPanel, "License Number",
                licenseNumberField = createTextField(), gbc, gridY++);

        // License Validity Date
        addFormField(formPanel, "License Validity Date",
                licenseValidityDateField = createDateField(), gbc, gridY++);

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
        setSize(500, 600);
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
                updateEligibilityFromFields();
                dispose();
            }
        });

        cancelButton.addActionListener(e -> {
            eligibility = null;
            dispose();
        });
    }

    private boolean validateInput() {
        // Validate Career Service
        if (careerServiceField.getText().trim().isEmpty()) {
            showError("Please enter the Career Service.");
            careerServiceField.requestFocus();
            return false;
        }

        // Validate Rating
        if (ratingField.getText().trim().isEmpty()) {
            showError("Please enter the Rating.");
            ratingField.requestFocus();
            return false;
        }

        // Validate Date of Examination
        if (dateOfExaminationField.getValue() == null) {
            showError("Please enter a valid Date of Examination.");
            dateOfExaminationField.requestFocus();
            return false;
        }

        // Validate Place of Examination
        if (placeOfExaminationField.getText().trim().isEmpty()) {
            showError("Please enter the Place of Examination.");
            placeOfExaminationField.requestFocus();
            return false;
        }

        // Validate License Number
        if (licenseNumberField.getText().trim().isEmpty()) {
            showError("Please enter the License Number.");
            licenseNumberField.requestFocus();
            return false;
        }

        // Validate License Validity Date
        if (licenseValidityDateField.getValue() == null) {
            showError("Please enter a valid License Validity Date.");
            licenseValidityDateField.requestFocus();
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

    private void populateFields() {
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

    private void updateEligibilityFromFields() {
        if (eligibility == null) {
            eligibility = new Eligibility();
        }
        eligibility.setCareerService(careerServiceField.getText().trim());
        eligibility.setRating(ratingField.getText().trim());

        // Convert Date to LocalDate
        Date examDate = (dateOfExaminationField.getValue() instanceof Date)
                ? (Date) dateOfExaminationField.getValue()
                : null;
        Date validityDate = (licenseValidityDateField.getValue() instanceof Date)
                ? (Date) licenseValidityDateField.getValue()
                : null;

        LocalDate localExamDate = (examDate != null) ? examDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate localValidityDate = (validityDate != null) ? validityDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;

        eligibility.setDateOfExamination(localExamDate);
        eligibility.setLicenseDateOfValidity(localValidityDate);

        eligibility.setPlaceOfExamination(placeOfExaminationField.getText().trim());
        eligibility.setLicenseNumber(licenseNumberField.getText().trim());
    }

    public Eligibility getEligibility() {
        return eligibility;
    }
}
