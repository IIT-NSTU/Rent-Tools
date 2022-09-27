package view;

import backend.Helper;

import javax.swing.*;
import java.awt.*;

public class AddExistingTool extends FrameSetter{
    private static final Font FONT = new Font("Arial", Font.BOLD, 20);
    private JTextField quantityTextField;
    private JComboBox itemNameComboBox;
    private JButton addToolButton, backButton;
    private Helper helper;

    public AddExistingTool() {
        helper = new Helper();
        setMainPanel();
        setButtons();
        setActionListeners();
    }

    @Override
    void setSize() {
        setSize(400, 500);
    }

    void setMainPanel(){
        getMainPanel().setLayout(new GridLayout(0, 1, 0, 2));
    }

    public void setButtons() {
        JLabel label = new JLabel("Select Tool");
        label.setFont(FONT);
        getMainPanel().add(label);

        itemNameComboBox = new JComboBox(helper.getToolNames());
        itemNameComboBox.setFont(FONT);
        getMainPanel().add(itemNameComboBox);

        label = new JLabel("Enter quantity");
        label.setFont(FONT);
        getMainPanel().add(label);

        quantityTextField = new JTextField();
        quantityTextField.setFont(FONT);
        getMainPanel().add(quantityTextField);

        addToolButton = new JButton("Add Tool");
        addToolButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addToolButton.setFocusPainted(false);
        addToolButton.setFont(FONT);
        addToolButton.setBackground(Color.DARK_GRAY);
        addToolButton.setForeground(Color.WHITE);
        getMainPanel().add(addToolButton);

        backButton = new JButton("Back");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setFont(FONT);
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.WHITE);
        getMainPanel().add(backButton);
    }

    public void setActionListeners() {
        itemNameComboBox.addActionListener(e-> {
            String name = itemNameComboBox.getSelectedItem().toString();
            JOptionPane.showMessageDialog(null, "Total " + name + " " + helper.getTotalTool(name));
        });

        addToolButton.addActionListener(e-> {
            if (!helper.getToolList().isEmpty()) {
                String name = itemNameComboBox.getSelectedItem().toString();
                int quantity = 0;
                try {
                    quantity = Integer.parseInt(quantityTextField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid quantity.");
                    return;
                }
                helper.addTool(name, quantity);
            } else {
                JOptionPane.showMessageDialog(null, "Noting to add");
            }

        });

        backButton.addActionListener(e-> {
            this.dispose();
            new HomePage().setVisible(true);
        });

    }

    public static void main(String[] args) {
        new AddExistingTool().setVisible(true);
    }
}
