package UI;
import javax.swing.*;
import java.awt.*;

public class UserViewRent extends JPanel{
    public UserViewRent(JButton back, JLabel notice, JTable data_display){
        // User View Rented Property UI
        this.setLayout(new GridLayout(4,1,1,1));

        // Title for View Rented Property Page
        JLabel title = new JLabel("PROPERTY RENTED");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title);

        // Table display for rented property data
        data_display.getTableHeader().setReorderingAllowed(false);
        data_display.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(data_display);
        this.add(scrollPane);

        // Notice Label
        notice.setForeground(Color.RED);
        notice.setHorizontalAlignment(JLabel.CENTER);
        this.add(notice);

        // Button for View Rented Property Page
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(back);
        this.add(buttonPanel);

    }
}
