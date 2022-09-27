package view;

import backend.Helper;

import javax.swing.*;
import java.awt.*;

public class ToolRentalPage extends FrameSetter{
    private static final Font FONT = new Font("Arial", Font.BOLD, 20);
    private JTextField dateTextField;
    private JComboBox customerNameComboBox, itemNameComboBox, itemReturnComboBox;
    private JButton rentToolButton, returnToolButton, backButton;
    private Helper helper;

    public ToolRentalPage() {
        helper = new Helper();
        setMainPanel();
        setButtons();
        setActionListeners();
    }

    @Override
    void setSize() {
        setSize(400, 700);
    }

    void setMainPanel(){
        getMainPanel().setLayout(new GridLayout(0, 1, 0, 2));
    }

    public void setButtons() {
        JLabel label = new JLabel("Date & Time");
        label.setFont(FONT);
        getMainPanel().add(label);

        dateTextField = new JTextField(getDate());
        dateTextField.setFont(FONT);
        dateTextField.setEditable(false);
        getMainPanel().add(dateTextField);

        label = new JLabel("Select Customer");
        label.setFont(FONT);
        getMainPanel().add(label);

        customerNameComboBox = new JComboBox(helper.getCustomerIDWithName());
        customerNameComboBox.setFont(FONT);
        getMainPanel().add(customerNameComboBox);

        label = new JLabel("Select Tool");
        label.setFont(FONT);
        getMainPanel().add(label);

        itemNameComboBox = new JComboBox(helper.getToolNames());
        itemNameComboBox.setFont(FONT);
        getMainPanel().add(itemNameComboBox);

        rentToolButton = new JButton("Rent Tool");
        rentToolButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rentToolButton.setFocusPainted(false);
        rentToolButton.setFont(FONT);
        rentToolButton.setBackground(Color.DARK_GRAY);
        rentToolButton.setForeground(Color.WHITE);
        getMainPanel().add(rentToolButton);

        getMainPanel().add(new JLabel());

        label = new JLabel("Select Tool");
        label.setFont(FONT);
        getMainPanel().add(label);

        itemReturnComboBox = new JComboBox(helper.getRentedToolNames());
        itemReturnComboBox.setFont(FONT);
        getMainPanel().add(itemReturnComboBox);

        returnToolButton = new JButton("Return Tool");
        returnToolButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnToolButton.setFocusPainted(false);
        returnToolButton.setFont(FONT);
        returnToolButton.setBackground(Color.DARK_GRAY);
        returnToolButton.setForeground(Color.WHITE);
        getMainPanel().add(returnToolButton);

        getMainPanel().add(new JLabel());

        backButton = new JButton("Back");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setFont(FONT);
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.WHITE);
        getMainPanel().add(backButton);
    }

    public void setActionListeners() {
        customerNameComboBox.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, "Customer Details\n " + helper.getCustomerDetails(customerNameComboBox.getSelectedItem().toString().substring(0, 7)));
        });

        itemNameComboBox.addActionListener(e-> {
            String name = itemNameComboBox.getSelectedItem().toString();
            JOptionPane.showMessageDialog(null, "Total " + name + " " + helper.getTotalTool(name));
        });

        itemReturnComboBox.addActionListener(e-> {
            String id = itemReturnComboBox.getSelectedItem().toString().substring(0, 7);
            JOptionPane.showMessageDialog(null, "Details\n" + helper.getToolDetails(id));
        });

        rentToolButton.addActionListener(e-> {
            if (helper.getCustomerList().isEmpty() || helper.getToolList().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Invalid Operation!");
            } else {
                helper.rentTool(customerNameComboBox.getSelectedItem().toString().substring(0, 7), dateTextField.getText());
                this.dispose();
                new ToolRentalPage().setVisible(true);
            }
        });

        returnToolButton.addActionListener(e-> {
            if (itemReturnComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Invalid Operation!");
            } else {
                helper.returnTool(itemReturnComboBox.getSelectedItem().toString().substring(0, 7), dateTextField.getText());
                this.dispose();
                new ToolRentalPage().setVisible(true);
            }
        });

        backButton.addActionListener(e-> {
            this.dispose();
            new HomePage().setVisible(true);
        });

    }

    public static void main(String[] args) {
        new ToolRentalPage().setVisible(true);
    }
}
