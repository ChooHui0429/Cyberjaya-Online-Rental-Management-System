package components;

import javax.swing.*;
import java.awt.*;

/**
 * Layout for agent and owner to view and select properties to modify
 * 
 * @author Tan Choo Hui
 * @author Lim Tian Hee
 */
public class ModifiedPropertyPage extends JPanel {
    public ModifiedPropertyPage(JButton back, JTable data_display, JLabel notice) {
        // Modified Property Page UI
        this.setLayout(new GridLayout(4, 1, 1, 1));

        // Title for Modified Property Page
        JLabel title = new JLabel("MODIFIED PROPERTY");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title);

        // Table display for property data
        data_display.getTableHeader().setReorderingAllowed(false);
        data_display.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(data_display);
        this.add(scrollPane);

        // Notice label
        notice.setHorizontalAlignment(JLabel.CENTER);
        notice.setForeground(Color.red);
        this.add(notice);

        // Button for Modified Property Page
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(back);
        this.add(buttonPanel);

    }
}
