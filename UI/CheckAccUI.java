package UI;

import javax.swing.*;
import java.awt.*;

public class CheckAccUI extends JFrame {
    public CheckAccUI(JButton back, JButton check, JTextField email_enterField, JTextField password_enterField,
            JLabel error_message) {
        // Pop Out for Check Account UI
        this.setLayout(new GridLayout(2, 1, 0, 0));
        this.setTitle("Cyberjaya Online Rental Management System");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(750, 275);
        ImageIcon logo = new ImageIcon("Cyberjaya-Online-Rental-Management-System/Icons/Logo.png");
        this.setIconImage(logo.getImage());

        // Panel for entry
        JPanel check_entry = new JPanel();
        check_entry.setLayout(new GridLayout(3, 1, 10, 10));

        JPanel check_entry_email = new JPanel();
        JLabel email_title = new JLabel("                        Email :");
        email_enterField.setPreferredSize(new Dimension(250, 25));
        check_entry_email.add(email_title);
        check_entry_email.add(email_enterField);

        JPanel check_entry_password = new JPanel();
        JLabel password_title = new JLabel("Security Password :");
        password_enterField.setPreferredSize(new Dimension(250, 25));
        check_entry_password.add(password_title);
        check_entry_password.add(password_enterField);

        error_message.setForeground(Color.RED);
        error_message.setHorizontalAlignment(JLabel.CENTER);

        check_entry.add(check_entry_email);
        check_entry.add(check_entry_password);
        check_entry.add(error_message);
        this.add(check_entry);

        // Button for Check Account Pop out
        JPanel button_panel = new JPanel();
        button_panel.setLayout(new GridLayout(2, 1, 10, 10));
        JPanel button_column1 = new JPanel();
        button_column1.add(back);
        button_column1.add(check);

        button_panel.add(button_column1);

        this.add(button_panel);

    }
}
