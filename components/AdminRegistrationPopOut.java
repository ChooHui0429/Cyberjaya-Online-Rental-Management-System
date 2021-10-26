package components;

import javax.swing.*;
import java.awt.*;

public class AdminRegistrationPopOut extends JFrame {
    public AdminRegistrationPopOut(JButton ok, JLabel notice_id, JLabel notice_password) {
        // Pop Out Notice for Successful register
        this.setLayout(new GridLayout(3, 1, 5, 5));
        this.setTitle("Cyberjaya Online Rental Management System");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(750, 250);
        ImageIcon logo = new ImageIcon("icons/appLogo.png");
        this.setIconImage(logo.getImage());

        // Panel for all the notice
        JPanel notice_panel = new JPanel();
        notice_panel.setLayout(new GridLayout(3, 1, 1, 1));
        JLabel notice1 = new JLabel("New Admin account is created successfully !");
        notice1.setHorizontalAlignment(JLabel.CENTER);
        notice_id.setHorizontalAlignment(JLabel.CENTER);
        notice_password.setHorizontalAlignment(JLabel.CENTER);
        notice_panel.add(notice1);
        notice_panel.add(notice_id);
        notice_panel.add(notice_password);
        this.add(notice_panel);

        // Button for registration pop out window
        JPanel button_panel = new JPanel();
        button_panel.add(ok);
        this.add(button_panel);
    }
}
