package view;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class FrameSetter extends JFrame {
    private Container container;
    private JPanel mainPanel;
    public FrameSetter() {
        setFrame();
        setContainer();
        setAppIcon();
    }

    public void setFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize();
        setLocationRelativeTo(null);
        setTitle("Tool Rent");
    }

    public void setContainer() {
        container = this.getContentPane();

        container.setLayout(new BorderLayout(30, 30));
        container.add(new JLabel(), BorderLayout.EAST);
        container.add(new JLabel(), BorderLayout.WEST);
        container.add(new JLabel(), BorderLayout.NORTH);
        container.add(new JLabel(), BorderLayout.SOUTH);

        mainPanel = new JPanel();
        container.add(mainPanel, BorderLayout.CENTER);
    }

    public void setAppIcon() {
        ImageIcon logo = new ImageIcon(this.getClass().getResource("/resources/appIcon.png"));
        this.setIconImage(logo.getImage());
    }

    abstract void setSize();

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy E hh:mm:ss a");
        Date date = new Date();
        return sdf.format(date);
    }

}
