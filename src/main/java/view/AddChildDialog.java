package view;

import model.Child;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class AddChildDialog extends JDialog {

    private JTextField nameField;
    private JFormattedTextField dobField;
    private JButton okButton;
    private JButton cancelButton;
    private Child child;

    // Constructor for adding a new child
    public AddChildDialog(Frame parent, boolean modal) {
        this(parent, modal, null); // Call the main constructor with null for child
    }

    // Constructor for editing an existing child
    public AddChildDialog(Frame parent, boolean modal, Child childToEdit) {
        super(parent, modal);
        this.child = childToEdit;
        initializeComponents();
        if (childToEdit != null) {
            populateFields();
        }
    }

    private void initializeComponents() {
        setTitle("Add/Edit Child");
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Date of Birth (MM/dd/yyyy):"));
        dobField = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy"));
        add(dobField);

        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    if (child == null) {
                        child = new Child();
                    }
                    child.setName(nameField.getText());
                    Object dobValue = dobField.getValue();
                    if (dobValue instanceof java.util.Date) {
                        java.util.Date date = (java.util.Date) dobValue;
                        LocalDate localDate = date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                        child.setDateOfBirth(localDate);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid date format!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    setVisible(false);
                    setVisible(false);
                }
            }
        });
        add(okButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                child = null; // Ensure child is null when canceled
                setVisible(false);
            }
        });
        add(cancelButton);

        pack();
        setLocationRelativeTo(getParent());
    }

    private boolean validateInput() {
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (dobField.getValue() == null) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date of birth.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Populate fields for editing
    private void populateFields() {
        nameField.setText(child.getName());
        if (child.getDateOfBirth() != null) {
            java.util.Date date = java.util.Date.from(child.getDateOfBirth().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
            dobField.setValue(date);
        }
    }

    public Child getChild() {
        return child;
    }
}
