package view;

import backend.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterToolPage extends FrameSetter{
    private static final Font FONT = new Font("Arial", Font.BOLD, 20);
    private JTextField nameTextField, quantityTextField;
    private JButton registerToolButton, backButton;
    private Helper helper;

    public RegisterToolPage() {
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
        JLabel label = new JLabel("Enter item name");
        label.setFont(FONT);
        getMainPanel().add(label);

        nameTextField = new JTextField();
        nameTextField.setFont(FONT);
        getMainPanel().add(nameTextField);

        label = new JLabel("Enter quantity");
        label.setFont(FONT);
        getMainPanel().add(label);

        quantityTextField = new JTextField();
        quantityTextField.setFont(FONT);
        getMainPanel().add(quantityTextField);

        registerToolButton = new JButton("Register Tool");
        registerToolButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerToolButton.setFocusPainted(false);
        registerToolButton.setFont(FONT);
        registerToolButton.setBackground(Color.DARK_GRAY);
        registerToolButton.setForeground(Color.WHITE);
        getMainPanel().add(registerToolButton);

        backButton = new JButton("Back");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setFont(FONT);
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.WHITE);
        getMainPanel().add(backButton);
    }

    public void setActionListeners() {
        quantityTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyChar() < (char)48 || keyEvent.getKeyChar() > (char)57) {
                    JOptionPane.showMessageDialog(null, "Please enter valid digit");
                    quantityTextField.setText("");
                }

                if (quantityTextField.getText().length() > 11) {
                    JOptionPane.showMessageDialog(null, "Mobile number can be maximum 11 digits");
                    quantityTextField.setText("");
                }
            }
        });

        registerToolButton.addActionListener(e-> {
            String name = nameTextField.getText();
            int quantity = 0;
            try {
                quantity = Integer.parseInt(quantityTextField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid quantity.");
                return;
            }
            helper.addTool(name, quantity);
        });

        backButton.addActionListener(e-> {
            this.dispose();
            new HomePage().setVisible(true);
        });


    }

    public static void main(String[] args) {
        new RegisterToolPage().setVisible(true);
    }
}
