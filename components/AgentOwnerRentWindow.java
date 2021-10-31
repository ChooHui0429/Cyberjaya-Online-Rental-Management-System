package components;

import javax.swing.*;
import java.awt.*;

/**
 * Layout for agent and owner to accept or reject property renting
 * 
 * @author Tan Choo Hui
 * @author Lim Tian Hee
 */
public class AgentOwnerRentWindow extends JFrame {
    public AgentOwnerRentWindow(JButton back, JButton rent, JButton reject, JLabel title_ID, JLabel userID,
            JLabel userContact, JLabel email, String selected_user) {

        // Main Frame for Agent/Owner Property Rent Window
        this.setTitle("Cyberjaya Online Rental Management System");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(500, 500);
        ImageIcon logo = new ImageIcon("icons/appLogo.png");
        this.setIconImage(logo.getImage());
        this.setResizable(false);

        this.setLayout(new GridLayout(3, 1, 1, 1));

        // ID for Agent/Owner Property Rent Window
        title_ID.setHorizontalAlignment(JLabel.CENTER);
        title_ID.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title_ID);

        JPanel info_display = new JPanel();
        info_display.setLayout(new GridLayout(3, 1, 1, 1));
        info_display.add(userID);
        info_display.add(userContact);
        info_display.add(email);

        this.add(info_display);

        // Button for Agent/Owner Property Rent Window
        JPanel button_panel = new JPanel();
        button_panel.add(back);
        button_panel.add(reject);
        button_panel.add(rent);
        this.add(button_panel);

    }

}
