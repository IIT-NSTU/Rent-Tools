package view;

import backend.Helper;

import javax.swing.*;
import java.awt.*;

public class MoreOptionsPage extends FrameSetter{
    private static final Font FONT = new Font("Arial", Font.BOLD, 20);
    private JButton searchCustomerButton, showAllActiveCustomerButton, showAllDeletedCustomerButton, showRentedToolButton, backButton;
    private JRadioButton customerSearchByLastNameRadioButton, customerSearchByFirstNameRadioButton, customerSearchByBothNameRadioButton;
    private JTextField customerSearchTextField;
    private Helper helper;

    public MoreOptionsPage(){
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
        ButtonGroup buttonGroup = new ButtonGroup();
        JLabel selectLabel = new JLabel("Select Search Option");
        selectLabel.setForeground(Color.GRAY);
        selectLabel.setFont(new Font("Arial", Font.BOLD, 18));
        getMainPanel().add(selectLabel);

        customerSearchByLastNameRadioButton = new JRadioButton(" Search By Last Name");
        customerSearchByLastNameRadioButton.setBackground(Color.WHITE);
        customerSearchByLastNameRadioButton.setForeground(Color.GRAY);
        customerSearchByLastNameRadioButton.setFocusPainted(false);
        customerSearchByLastNameRadioButton.setFont(new Font("Arial", Font.BOLD, 18));
        buttonGroup.add(customerSearchByLastNameRadioButton);

        customerSearchByFirstNameRadioButton = new JRadioButton(" Search By First Name");
        customerSearchByFirstNameRadioButton.setBackground(Color.WHITE);
        customerSearchByFirstNameRadioButton.setForeground(Color.GRAY);
        customerSearchByFirstNameRadioButton.setFocusPainted(false);
        customerSearchByFirstNameRadioButton.setFont(new Font("Arial", Font.BOLD, 18));
        buttonGroup.add(customerSearchByFirstNameRadioButton);

        customerSearchByBothNameRadioButton = new JRadioButton(" Search By Both");
        customerSearchByBothNameRadioButton.setBackground(Color.WHITE);
        customerSearchByBothNameRadioButton.setForeground(Color.GRAY);
        customerSearchByBothNameRadioButton.setFocusPainted(false);
        customerSearchByBothNameRadioButton.setFont(new Font("Arial", Font.BOLD, 18));
        buttonGroup.add(customerSearchByBothNameRadioButton);

        getMainPanel().add(customerSearchByLastNameRadioButton);
        getMainPanel().add(customerSearchByFirstNameRadioButton);
        getMainPanel().add(customerSearchByBothNameRadioButton);

        customerSearchTextField = new JTextField();
        customerSearchTextField.setFont(new Font("Arial", Font.BOLD, 16));
        customerSearchTextField.setForeground(Color.black);
        getMainPanel().add(customerSearchTextField);

        searchCustomerButton = new JButton("Search Customer");
        searchCustomerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchCustomerButton.setFocusPainted(false);
        searchCustomerButton.setFont(FONT);
        searchCustomerButton.setBackground(Color.DARK_GRAY);
        searchCustomerButton.setForeground(Color.WHITE);
        getMainPanel().add(searchCustomerButton);

        getMainPanel().add(new JLabel());

        showAllActiveCustomerButton = new JButton("Show All Active Customer");
        showAllActiveCustomerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showAllActiveCustomerButton.setFocusPainted(false);
        showAllActiveCustomerButton.setFont(FONT);
        showAllActiveCustomerButton.setBackground(Color.DARK_GRAY);
        showAllActiveCustomerButton.setForeground(Color.WHITE);
        getMainPanel().add(showAllActiveCustomerButton);

        showAllDeletedCustomerButton = new JButton("Show All Deleted Customer");
        showAllDeletedCustomerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showAllDeletedCustomerButton.setFocusPainted(false);
        showAllDeletedCustomerButton.setFont(FONT);
        showAllDeletedCustomerButton.setBackground(Color.DARK_GRAY);
        showAllDeletedCustomerButton.setForeground(Color.WHITE);
        getMainPanel().add(showAllDeletedCustomerButton);

        showRentedToolButton = new JButton("Show Rented Tools");
        showRentedToolButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showRentedToolButton.setFocusPainted(false);
        showRentedToolButton.setFont(FONT);
        showRentedToolButton.setBackground(Color.DARK_GRAY);
        showRentedToolButton.setForeground(Color.WHITE);
        getMainPanel().add(showRentedToolButton);

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
        searchCustomerButton.addActionListener(e->{
            String name = customerSearchTextField.getText();

            if (customerSearchByLastNameRadioButton.isSelected()) {
                String info = helper.getSearchByLastName(name);
                if (info.equals("")) {
                    JOptionPane.showMessageDialog(null, "No Data Found");
                } else {
                    JOptionPane.showMessageDialog(null, "Customer Information\n" + helper.getSearchByLastName(name));
                }
            }

            if (customerSearchByFirstNameRadioButton.isSelected()) {
                String info = helper.getSearchByFirstName(name);
                if (info.equals("")) {
                    JOptionPane.showMessageDialog(null, "No Data Found");
                } else {
                    JOptionPane.showMessageDialog(null, "Customer Information\n" + helper.getSearchByFirstName(name));
                }
            }

            if (customerSearchByBothNameRadioButton.isSelected()) {
                String info = helper.getSearchByBothName(name);
                if (info.equals("")) {
                    JOptionPane.showMessageDialog(null, "No Data Found");
                } else {
                    JOptionPane.showMessageDialog(null, "Customer Information\n" + helper.getSearchByBothName(name));
                }
            }
        });

        showAllActiveCustomerButton.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, "Customer Information\n" + helper.showActiveCustomer());
        });

        showAllDeletedCustomerButton.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, "Customer Information\n" + helper.showDeletedCustomer());
        });

        showRentedToolButton.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, "All Tool Information\n" + helper.showRentedToolCustomer());
        });

        backButton.addActionListener(e-> {
            this.dispose();
            new HomePage().setVisible(true);
        });
    }

    public static void main(String[] args) {
        new MoreOptionsPage().setVisible(true);
    }
}
