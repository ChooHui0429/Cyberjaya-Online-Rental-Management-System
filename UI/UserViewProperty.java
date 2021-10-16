package UI;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class UserViewProperty extends JPanel{
    public UserViewProperty(JButton back, JTable data_display){
        // User View Property UI
        this.setLayout(new GridLayout(4,1,1,1));

        // Title for View Property Page
        JLabel title = new JLabel("PROPERTY AVAILABLE");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title);

        // Table display for property data
        data_display.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(data_display);
        this.add(scrollPane);

        // Button for Modified Property Page
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(back);
        this.add(buttonPanel);

    }
    
}
