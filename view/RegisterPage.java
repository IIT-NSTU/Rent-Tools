package view;

import backend.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterPage extends FrameSetter{
    private static final Font FONT = new Font("Arial", Font.BOLD, 20);
    private JTextField nameTextField, fatherNameTextField, motherNameTextField, mobileNumberTextField, addressTextField;
    private JButton registerButton, backButton;
    private Helper helper;

    public RegisterPage() {
        helper = new Helper();
        setMainPanel();
        setButtons();
        setActionListeners();
    }

    @Override
    void setSize() {
        setSize(400, 600);
    }

    void setMainPanel(){
        getMainPanel().setLayout(new GridLayout(0, 1, 0, 2));
    }

    public void setButtons() {
        JLabel label = new JLabel("Enter customer's name");
        label.setFont(FONT);
        getMainPanel().add(label);

        nameTextField = new JTextField();
        nameTextField.setFont(FONT);
        getMainPanel().add(nameTextField);

        label = new JLabel("Enter customer's father's name");
        label.setFont(FONT);
        getMainPanel().add(label);

        fatherNameTextField = new JTextField();
        fatherNameTextField.setFont(FONT);
        getMainPanel().add(fatherNameTextField);

        label = new JLabel("Enter customer's mother's name");
        label.setFont(FONT);
        getMainPanel().add(label);

        motherNameTextField = new JTextField();
        motherNameTextField.setFont(FONT);
        getMainPanel().add(motherNameTextField);

        label = new JLabel("Enter customer's mobile number");
        label.setFont(FONT);
        getMainPanel().add(label);

        mobileNumberTextField = new JTextField();
        mobileNumberTextField.setFont(FONT);
        getMainPanel().add(mobileNumberTextField);

        label = new JLabel("Enter customer's address");
        label.setFont(FONT);
        getMainPanel().add(label);

        addressTextField = new JTextField();
        addressTextField.setFont(FONT);
        getMainPanel().add(addressTextField);

        registerButton = new JButton("Register");
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.setFocusPainted(false);
        registerButton.setFont(FONT);
        registerButton.setBackground(Color.DARK_GRAY);
        registerButton.setForeground(Color.WHITE);
        getMainPanel().add(registerButton);

        backButton = new JButton("Back");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setFont(FONT);
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.WHITE);
        getMainPanel().add(backButton);
    }

    public void setActionListeners() {
        mobileNumberTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyChar() < (char)48 || keyEvent.getKeyChar() > (char)57) {
                    JOptionPane.showMessageDialog(null, "Please enter valid digit");
                    mobileNumberTextField.setText("");
                }

                if (mobileNumberTextField.getText().length() > 11) {
                    JOptionPane.showMessageDialog(null, "Mobile number can be maximum 11 digits");
                    mobileNumberTextField.setText("");
                }
            }
        });

        registerButton.addActionListener(e-> {
            String customerName = nameTextField.getText();
            String fatherName = fatherNameTextField.getText();
            String motherName = motherNameTextField.getText();
            String mobileNumber = mobileNumberTextField.getText();
            String address = addressTextField.getText();

            if (customerName.equals("") || fatherName.equals("") || motherName.equals("") || mobileNumber.equals("") || address.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter All Information");
                return;
            }

            helper.addCustomer(customerName, fatherName, motherName, mobileNumber, address);
        });

        backButton.addActionListener(e-> {
            this.dispose();
            new HomePage().setVisible(true);
        });


    }

    public static void main(String[] args) {
        new RegisterPage().setVisible(true);
    }
}
