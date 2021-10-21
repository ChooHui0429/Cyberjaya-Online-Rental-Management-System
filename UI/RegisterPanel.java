package UI;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends JPanel {
    public RegisterPanel(JButton register, JButton back, JTextField name_enterField, JTextField email_enterField,
            JTextField securityPassword_enterField, JLabel error_message, JComboBox<String> acc_type_selection) {

        // UI for Registration
        this.setLayout(new GridLayout(3, 1, 1, 1));

        // Title for Registration Page
        JLabel title = new JLabel("REGISTRATION");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title);

        // Entry for registration information
        JPanel register_entry = new JPanel();
        register_entry.setLayout(new GridLayout(5, 1, 10, 10));

        JPanel register_entry_name = new JPanel();
        JLabel name_title = new JLabel("                        Name :");
        name_enterField.setPreferredSize(new Dimension(250, 25));
        register_entry_name.add(name_title);
        register_entry_name.add(name_enterField);

        JPanel register_entry_email = new JPanel();
        JLabel email_title = new JLabel("                        Email :");
        email_enterField.setPreferredSize(new Dimension(250, 25));
        register_entry_email.add(email_title);
        register_entry_email.add(email_enterField);

        JPanel register_entry_securityPassword = new JPanel();
        JLabel securityPassword_title = new JLabel("Security Password :");
        securityPassword_enterField.setPreferredSize(new Dimension(250, 25));
        register_entry_securityPassword.add(securityPassword_title);
        register_entry_securityPassword.add(securityPassword_enterField);

        JPanel register_entry_accType = new JPanel();
        JLabel accType_title = new JLabel("Account Type :");
        register_entry_accType.add(accType_title);
        register_entry_accType.add(acc_type_selection);

        // Error Message Label
        error_message.setForeground(Color.RED);
        error_message.setHorizontalAlignment(JLabel.CENTER);

        register_entry.add(register_entry_name);
        register_entry.add(register_entry_email);
        register_entry.add(register_entry_securityPassword);
        register_entry.add(register_entry_accType);
        register_entry.add(error_message);
        this.add(register_entry);

        // Button for Register Page
        JPanel button_panel = new JPanel();
        button_panel.add(back);
        button_panel.add(register);

        this.add(button_panel);
    }
}
