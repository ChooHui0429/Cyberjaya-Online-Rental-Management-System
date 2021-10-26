package components;

import javax.swing.*;
import java.awt.*;

public class ReportListUI extends JFrame {
    public ReportListUI(JButton listProperty, JButton listActive, JButton listInactive, JButton listRate) {

        // Main Frame
        this.setTitle("Cyberjaya Online Rental Management System");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(200, 300);
        ImageIcon logo = new ImageIcon("icons/appLogo.png");
        this.setIconImage(logo.getImage());
        this.setResizable(false);

        // UI for Report page
        this.setLayout(new GridLayout(6, 1, 1, 1));

        // Title for Report Page
        JLabel title = new JLabel("REPORT");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title);

        // Button for Report page
        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.add(listProperty);
        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.add(listActive);
        JPanel buttonPanel3 = new JPanel();
        buttonPanel3.add(listInactive);
        JPanel buttonPanel4 = new JPanel();
        buttonPanel4.add(listRate);

        this.add(buttonPanel1);
        this.add(buttonPanel2);
        this.add(buttonPanel3);
        this.add(buttonPanel4);
    }
}
