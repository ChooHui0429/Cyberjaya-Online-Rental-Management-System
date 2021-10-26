package components;

import javax.swing.*;
import java.awt.*;

public class AgentOwnerPage extends JPanel {
    public AgentOwnerPage(JButton uploadProperty, JButton modifiedProperties, JButton rentedProperties, JButton logout,
            JLabel title, JLabel welcome_name) {
        // UI for Agent and Owner Home Page
        this.setLayout(new GridLayout(3, 1, 1, 1));

        // Title for Agent and Owner Home Page
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title);

        // Welcome words
        JPanel welcome_panel = new JPanel();
        JLabel welcome = new JLabel("WELCOME ");
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setFont(new Font("MV Boli", Font.BOLD, 25));

        welcome_name.setFont(new Font("MV Boli", Font.BOLD, 25));
        welcome_name.setForeground(Color.pink);

        welcome_panel.add(welcome);
        welcome_panel.add(welcome_name);
        this.add(welcome_panel);

        // Button for Agent and Owner Home Page
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 1, 1));

        JPanel buttonRow1 = new JPanel();
        buttonRow1.add(uploadProperty);
        buttonRow1.add(modifiedProperties);

        JPanel buttonRow2 = new JPanel();
        buttonRow2.add(rentedProperties);

        JPanel buttonRow3 = new JPanel();
        buttonRow3.add(logout);

        buttonPanel.add(buttonRow1);
        buttonPanel.add(buttonRow2);
        buttonPanel.add(buttonRow3);

        this.add(buttonPanel);
    }
}
