package UI;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    public LoginPanel(JButton register, JButton login, JTextField id_enterField, JTextField password_enterField,
            JLabel error_message, JLabel find_acc) {

        // UI for Login
        this.setLayout(new GridLayout(6, 1, 0, 0));

        // Resize logo
        ImageIcon logo = new ImageIcon("Icons/Logo.png");
        Image logo_image = logo.getImage();
        Image logo_resize = logo_image.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        logo = new ImageIcon(logo_resize);

        // Logo display in Login Page
        JLabel logo_display = new JLabel();
        logo_display.setIcon(logo);
        logo_display.setHorizontalAlignment(JLabel.CENTER);
        this.add(logo_display);

        // Title display in Login Page
        JLabel title_display = new JLabel("Cyberjaya Online Rental Management System");
        title_display.setHorizontalAlignment(JLabel.CENTER);
        title_display.setFont(new Font("MV Boli", Font.BOLD, 20));
        this.add(title_display);

        // Panel for user login in Login Page
        JPanel login_entry = new JPanel();
        login_entry.setLayout(new GridLayout(3, 1, 10, 10));

        JPanel login_entry_id = new JPanel();
        JLabel id_title = new JLabel("    User ID :");
        id_enterField.setPreferredSize(new Dimension(250, 25));
        login_entry_id.add(id_title);
        login_entry_id.add(id_enterField);

        JPanel login_entry_password = new JPanel();
        JLabel password_title = new JLabel("Password :");
        password_enterField.setPreferredSize(new Dimension(250, 25));
        login_entry_password.add(password_title);
        login_entry_password.add(password_enterField);

        error_message.setForeground(Color.RED);
        error_message.setHorizontalAlignment(JLabel.CENTER);

        login_entry.add(login_entry_id);
        login_entry.add(login_entry_password);
        login_entry.add(error_message);
        this.add(login_entry);

        // Button for Login Page
        JPanel button_panel = new JPanel();
        button_panel.setLayout(new GridLayout(2, 1, 10, 10));
        JPanel button_column1 = new JPanel();
        button_column1.add(register);
        button_column1.add(login);

        find_acc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        find_acc.setForeground(Color.BLUE);
        find_acc.setHorizontalAlignment(JLabel.CENTER);

        button_panel.add(button_column1);
        button_panel.add(find_acc);

        this.add(button_panel);
    }
}
