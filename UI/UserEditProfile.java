package UI;
import javax.swing.*;
import java.awt.*;

public class UserEditProfile extends JPanel{
    public UserEditProfile(
        JButton update, 
        JTextField name_enterField, 
        JTextField email_enterField, 
        JTextField contactNumber_enterField,
        JLabel error_message){
        // UI for user edit profile
        this.setLayout(new GridLayout(3,1,1,1));

        // Title for user edit profile
        JLabel title = new JLabel("EDIT PROFILE");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title);

        // Entry for update profile
        JPanel update_entry = new JPanel();
        update_entry.setLayout(new GridLayout(4,1,10,10));

        JPanel update_entry_name = new JPanel();
        JLabel name_title = new JLabel("                        Name :");
        name_enterField.setPreferredSize(new Dimension(250,25));
        update_entry_name.add(name_title);
        update_entry_name.add(name_enterField);

        JPanel update_entry_email = new JPanel();
        JLabel email_title = new JLabel("                        Email :");
        email_enterField.setPreferredSize(new Dimension(250,25));
        update_entry_email.add(email_title);
        update_entry_email.add(email_enterField);

        JPanel update_entry_contactNumber = new JPanel();
        JLabel contactNumber_title = new JLabel("Contact Number :");
        contactNumber_enterField.setPreferredSize(new Dimension(250,25));
        update_entry_contactNumber.add(contactNumber_title);
        update_entry_contactNumber.add(contactNumber_enterField); 

        // Error message label
        error_message.setForeground(Color.RED);
        error_message.setHorizontalAlignment(JLabel.CENTER);

        update_entry.add(update_entry_name);
        update_entry.add(update_entry_email);
        update_entry.add(update_entry_contactNumber);
        update_entry.add(error_message);
        this.add(update_entry);

        // Button for update profile Page
        JPanel button_panel = new JPanel();
        button_panel.add(update);

        this.add(button_panel);
    }
}
