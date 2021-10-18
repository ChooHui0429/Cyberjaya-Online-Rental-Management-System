package UI;
import javax.swing.*;
import java.awt.*;


public class AdminApproveUserPage extends JPanel{
    public AdminApproveUserPage(JButton back, JButton rejectUserBtn, JButton approveUserBtn, JTable data_display, JLabel notice){

        // Approve User Page UI
        this.setLayout(new GridLayout(3,1,0,0));

        // Table display for registrater data
        data_display.getTableHeader().setReorderingAllowed(false);
        data_display.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(data_display);
        this.add(scrollPane);
        
        // Notice label
        notice.setHorizontalAlignment(JLabel.CENTER);
        notice.setForeground(Color.red);
        this.add(notice);

        // Button for Approve User Page
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(back);
        buttonPanel.add(rejectUserBtn);
        buttonPanel.add(approveUserBtn);

        this.add(buttonPanel);
    }
}
