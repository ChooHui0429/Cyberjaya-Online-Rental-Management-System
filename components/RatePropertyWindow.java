package components;

import javax.swing.*;
import java.awt.*;

public class RatePropertyWindow extends JFrame {
    public RatePropertyWindow(JButton one, JButton two, JButton three, JButton four, JButton five, JLabel title_ID) {
        // Main Frame for Rate Property Window
        this.setTitle("Cyberjaya Online Rental Management System");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(500, 500);
        ImageIcon logo = new ImageIcon("icons/Logo.png");
        this.setIconImage(logo.getImage());
        this.setResizable(false);

        this.setLayout(new GridLayout(3, 1, 1, 1));

        // ID for Rate Property Rent Window
        title_ID.setHorizontalAlignment(JLabel.CENTER);
        title_ID.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title_ID);

        JLabel notice = new JLabel("Please Rate about the property that you rented before.");
        notice.setHorizontalAlignment(JLabel.CENTER);
        this.add(notice);

        JPanel button_panel = new JPanel();
        button_panel.add(one);
        button_panel.add(two);
        button_panel.add(three);
        button_panel.add(four);
        button_panel.add(five);
        this.add(button_panel);

    }
}
