package view;

import javax.swing.*;
import java.awt.*;

public class HomePage extends FrameSetter{
    private static final Font FONT = new Font("Arial", Font.BOLD, 20);
    private JButton registerCustomerButton, deleteCustomerButton, registerNewToolButton, addExistingToolButton, toolRentalButton, moreOptionsButton;

    public HomePage(){
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
        registerCustomerButton = new JButton("Register Customer");
        registerCustomerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerCustomerButton.setFocusPainted(false);
        registerCustomerButton.setFont(FONT);
        registerCustomerButton.setBackground(Color.DARK_GRAY);
        registerCustomerButton.setForeground(Color.WHITE);
        getMainPanel().add(registerCustomerButton);

        deleteCustomerButton = new JButton("Delete Customer");
        deleteCustomerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteCustomerButton.setFocusPainted(false);
        deleteCustomerButton.setFont(FONT);
        deleteCustomerButton.setBackground(Color.DARK_GRAY);
        deleteCustomerButton.setForeground(Color.WHITE);
        getMainPanel().add(deleteCustomerButton);

        registerNewToolButton = new JButton("Register New Tool");
        registerNewToolButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerNewToolButton.setFocusPainted(false);
        registerNewToolButton.setFont(FONT);
        registerNewToolButton.setBackground(Color.DARK_GRAY);
        registerNewToolButton.setForeground(Color.WHITE);
        getMainPanel().add(registerNewToolButton);

        addExistingToolButton = new JButton("Add Existing Tool");
        addExistingToolButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addExistingToolButton.setFocusPainted(false);
        addExistingToolButton.setFont(FONT);
        addExistingToolButton.setBackground(Color.DARK_GRAY);
        addExistingToolButton.setForeground(Color.WHITE);
        getMainPanel().add(addExistingToolButton);

        toolRentalButton = new JButton("Tool Rental");
        toolRentalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toolRentalButton.setFocusPainted(false);
        toolRentalButton.setFont(FONT);
        toolRentalButton.setBackground(Color.DARK_GRAY);
        toolRentalButton.setForeground(Color.WHITE);
        getMainPanel().add(toolRentalButton);

        moreOptionsButton = new JButton("More Options");
        moreOptionsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        moreOptionsButton.setFocusPainted(false);
        moreOptionsButton.setFont(FONT);
        moreOptionsButton.setBackground(Color.DARK_GRAY);
        moreOptionsButton.setForeground(Color.WHITE);
        getMainPanel().add(moreOptionsButton);
    }

    public void setActionListeners() {
        registerCustomerButton.addActionListener(e-> {
            this.dispose();
            new RegisterPage().setVisible(true);
        });

        registerNewToolButton.addActionListener(e-> {
            this.dispose();
            new RegisterToolPage().setVisible(true);
        });

        deleteCustomerButton.addActionListener(e-> {
            this.dispose();
            new DeleteCustomerPage().setVisible(true);
        });

        addExistingToolButton.addActionListener(e-> {
            this.dispose();
            new AddExistingTool().setVisible(true);
        });

        toolRentalButton.addActionListener(e-> {
            this.dispose();
            new ToolRentalPage().setVisible(true);
        });

        moreOptionsButton.addActionListener(e-> {
            this.dispose();
            new MoreOptionsPage().setVisible(true);
        });
    }

    public static void main(String[] args) {
        new HomePage().setVisible(true);
    }
}
