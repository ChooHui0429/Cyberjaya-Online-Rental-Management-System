package UI;

import javax.swing.*;
import java.awt.*;

public class AdminRemoveUserPage extends JPanel {
    public AdminRemoveUserPage(JButton back, JButton removeUserBtn, JTable data_display, JLabel notice) {

        // Remove User Page UI
        this.setLayout(new GridLayout(3, 1, 0, 0));

        // Table for display accounts data
        data_display.getTableHeader().setReorderingAllowed(false);
        data_display.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(data_display);
        this.add(scrollPane);

        // Notice label
        notice.setHorizontalAlignment(JLabel.CENTER);
        notice.setForeground(Color.red);
        this.add(notice);

        // Button for Remove User Page
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(back);
        buttonPanel.add(removeUserBtn);

        this.add(buttonPanel);
    }
}
