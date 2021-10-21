package UI;

import javax.swing.*;
import java.awt.*;

public class CheckResultPopOut extends JFrame {
    public CheckResultPopOut(JButton ok, JLabel notice) {
        // Pop Out Notice for check account result
        this.setLayout(new GridLayout(2, 1, 5, 5));
        this.setTitle("Cyberjaya Online Rental Management System");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(750, 250);
        ImageIcon logo = new ImageIcon("Cyberjaya-Online-Rental-Management-System/Icons/Logo.png");
        this.setIconImage(logo.getImage());

        // Notice Label
        notice.setHorizontalAlignment(JLabel.CENTER);
        this.add(notice);

        // Button for check account result pop out
        JPanel button_panel = new JPanel();
        button_panel.add(ok);
        this.add(button_panel);

    }
}
