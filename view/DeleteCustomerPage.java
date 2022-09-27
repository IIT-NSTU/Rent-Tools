package view;

import backend.Helper;

import javax.swing.*;
import java.awt.*;

public class DeleteCustomerPage extends FrameSetter{
    private static final Font FONT = new Font("Arial", Font.BOLD, 20);
    private JComboBox nameComboBox;
    private JButton deleteCustomerButton, backButton;
    private Helper helper;

    public DeleteCustomerPage() {
        helper = new Helper();
        setMainPanel();
        setButtons();
        setActionListeners();
    }

    @Override
    void setSize() {
        setSize(400, 400);
    }

    void setMainPanel(){
        getMainPanel().setLayout(new GridLayout(0, 1, 0, 2));
    }

    public void setButtons() {
        JLabel label = new JLabel("Select Customer");
        label.setFont(FONT);
        getMainPanel().add(label);

        nameComboBox = new JComboBox(helper.getCustomerIDWithName());
        nameComboBox.setFont(FONT);
        getMainPanel().add(nameComboBox);

        deleteCustomerButton = new JButton("Delete");
        deleteCustomerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteCustomerButton.setFocusPainted(false);
        deleteCustomerButton.setFont(FONT);
        deleteCustomerButton.setBackground(Color.DARK_GRAY);
        deleteCustomerButton.setForeground(Color.WHITE);
        getMainPanel().add(deleteCustomerButton);

        backButton = new JButton("Back");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setFont(FONT);
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.WHITE);
        getMainPanel().add(backButton);
    }

    public void setActionListeners() {
        nameComboBox.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, "Customer Details\n " + helper.getCustomerDetails(nameComboBox.getSelectedItem().toString().substring(0, 7)));
        });

        deleteCustomerButton.addActionListener(e-> {
            if (!helper.getCustomerList().isEmpty()) {
                helper.deleteCustomer(nameComboBox.getSelectedItem().toString().substring(0, 7));
                this.dispose();
                new DeleteCustomerPage().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Nothing to delete");
            }
        });

        backButton.addActionListener(e-> {
            this.dispose();
            new HomePage().setVisible(true);
        });

    }

    public static void main(String[] args) {
        new DeleteCustomerPage().setVisible(true);
    }
}
