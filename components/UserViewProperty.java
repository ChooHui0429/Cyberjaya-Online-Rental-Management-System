package components;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

/**
 * Layout for user to view the list of property
 * 
 * @author Tan Choo Hui
 * @author Lim Tian Hee
 */
public class UserViewProperty extends JPanel {
    public UserViewProperty(JButton back, JTable data_display, JLabel title) {
        // User View Property UI
        this.setLayout(new GridLayout(4, 1, 1, 1));

        // Title for View Property Page
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title);

        // Table display for property data
        data_display.getTableHeader().setReorderingAllowed(false);
        data_display.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        data_display.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(data_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane);

        // Button for Modified Property Page
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(back);
        this.add(buttonPanel);

    }

}
