package view;

import model.Reference;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddReferenceDialog extends BaseDialog {

    private JTextField nameField;
    private JTextField addressField;
    private JTextField telephoneNoField;
    private JButton okButton;
    private JButton cancelButton;
    private Reference reference;

    // Constructors
    public AddReferenceDialog(Frame parent, boolean modal) {
        this(parent, modal, null);
    }

    public AddReferenceDialog(Frame parent, boolean modal, Reference referenceToEdit) {
        super(parent, modal);
        this.reference = referenceToEdit;
        initializeComponents();
        if (referenceToEdit != null) {
            populateFields();
            setTitle("Edit Reference");
        } else {
            setTitle("Add Reference");
        }
    }

    private void initializeComponents() {
        // Create the main panel with BorderLayout and padding
        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(24, 24, 24, 24));

        // Header label
        JLabel headerLabel = createLabel(getTitle());
        headerLabel.setFont(TITLE_FONT);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Form panel with GridBagLayout for flexible layout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(BACKGROUND_COLOR);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.weightx = 1.0;
        int gridY = 0;

        // Name field
        addFormField(formPanel, "Name:", nameField = createTextField(), gbc, gridY++);
        // Address field
        addFormField(formPanel, "Address:", addressField = createTextField(), gbc, gridY++);
        // Telephone No. field
        addFormField(formPanel, "Telephone No.:", telephoneNoField = createTextField(), gbc, gridY++);

        // Add form panel to a scroll pane (if needed)
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

        // Set the dialog's content pane and configuration
        setContentPane(mainPanel);
        setResizable(true);
        setupEventListeners();
        pack();
        setLocationRelativeTo(getParent());
    }

    // Helper method to add a label–field pair using GridBagLayout
    private void addFormField(JPanel panel, String labelText, JComponent field,
                              GridBagConstraints gbc, int gridy) {
        JLabel label = createLabel(labelText);
        gbc.gridy = gridy * 2;
        panel.add(label, gbc);
        gbc.gridy = gridy * 2 + 1;
        panel.add(field, gbc);
    }

    // Setup event listeners for the buttons
    private void setupEventListeners() {
        okButton.addActionListener(e -> {
            if (validateInput()) {
                updateModelFromFields();
                dispose();
            }
        });
        cancelButton.addActionListener(e -> {
            reference = null;
            dispose();
        });
    }
    
    private void showError(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private boolean validateInput() {
        if (nameField.getText().trim().isEmpty()) {
            showError("Please enter a name.");
            nameField.requestFocus();
            return false;
        }
        return true;
    }

    // Implementation of the abstract method from BaseDialog.
    @Override
    protected void populateFields() {
        if (reference != null) {
            nameField.setText(reference.getName());
            addressField.setText(reference.getAddress());
            telephoneNoField.setText(reference.getTelephoneNo());
        }
    }

    @Override
    protected void updateModelFromFields() {
        if (reference == null) {
            reference = new Reference();
        }
        reference.setName(nameField.getText().trim());
        reference.setAddress(addressField.getText().trim());
        reference.setTelephoneNo(telephoneNoField.getText().trim());
    }

    public Reference getReference() {
        return reference;
    }
}
