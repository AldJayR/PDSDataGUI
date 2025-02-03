package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;

public abstract class BaseDialog extends JDialog {
    protected static final Color PRIMARY_COLOR = new Color(59, 130, 246);
    protected static final Color BACKGROUND_COLOR = new Color(249, 250, 251);
    protected static final Color TEXT_COLOR = new Color(31, 41, 55);
    protected static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 16);
    protected static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 13);
    protected static final Font INPUT_FONT = new Font("Arial", Font.PLAIN, 14);

    public BaseDialog(Frame parent, boolean modal) {
        super(parent, modal);
    }

    protected JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(LABEL_FONT);
        label.setForeground(TEXT_COLOR);
        return label;
    }

    protected JTextField createTextField() {
        JTextField field = new JTextField();
        field.setFont(INPUT_FONT);
        field.setPreferredSize(new Dimension(200, 32));
        return field;
    }

    protected JFormattedTextField createDateField() {
        JFormattedTextField field = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy"));
        field.setFont(INPUT_FONT);
        field.setPreferredSize(new Dimension(200, 32));
        field.setToolTipText("Format: MM/DD/YYYY");
        return field;
    }

    protected JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 36));
        return button;
    }

    protected JButton createSecondaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(BACKGROUND_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(TEXT_COLOR));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(100, 36));
        return button;
    }

    protected abstract void populateFields();
    protected abstract void updateModelFromFields();
}
