package components;

import javax.swing.*;
import java.awt.*;

public class UploadPropertyUI extends JPanel {
    public UploadPropertyUI(JButton back, JButton upload, JTextField size_enterField, JTextField NumRoom_enterField,
            JTextField NumBathroom_enterField, JTextField Condition_enterField, JTextField ContactNum_enterField,
            JTextField rentalFee_enterField, JLabel error_message, JTextArea address_enterField,
            JTextArea facilities_enterField, JTextArea rentalAskFor_enterField,
            JComboBox<String> propertyType_selection, JComboBox<String> status_selection) {

        // UI for Upload New Property
        this.setLayout(new GridLayout(3, 1, 1, 1));

        // Title for Upload New Property Page
        JLabel title = new JLabel("NEW PROPERTY");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title);

        // Entry for New Property information
        JPanel info_entry = new JPanel();
        info_entry.setLayout(new GridLayout(6, 2, 1, 1));

        JPanel info_entry_propertyType = new JPanel();
        JLabel propertyType_title = new JLabel("Property Type :");
        info_entry_propertyType.add(propertyType_title);
        info_entry_propertyType.add(propertyType_selection);

        JPanel info_entry_size = new JPanel();
        JLabel size_title = new JLabel("    Size (square feet) :");
        size_enterField.setPreferredSize(new Dimension(250, 25));
        info_entry_size.add(size_title);
        info_entry_size.add(size_enterField);

        JPanel info_entry_address = new JPanel();
        JLabel address_title = new JLabel("               Address :");
        address_enterField.setPreferredSize(new Dimension(250, 25));
        address_enterField.setRows(2);
        info_entry_address.add(address_title);
        info_entry_address.add(address_enterField);

        JPanel info_entry_status = new JPanel();
        JLabel status_title = new JLabel("Status :");
        info_entry_status.add(status_title);
        info_entry_status.add(status_selection);

        JPanel info_entry_NumRoom = new JPanel();
        JLabel NumRoom_title = new JLabel("Number of Room :");
        NumRoom_enterField.setPreferredSize(new Dimension(250, 25));
        info_entry_NumRoom.add(NumRoom_title);
        info_entry_NumRoom.add(NumRoom_enterField);

        JPanel info_entry_NumBathroom = new JPanel();
        JLabel NumBathroom_title = new JLabel("Number of Bathoom :");
        NumBathroom_enterField.setPreferredSize(new Dimension(250, 25));
        info_entry_NumBathroom.add(NumBathroom_title);
        info_entry_NumBathroom.add(NumBathroom_enterField);

        JPanel info_entry_facilities = new JPanel();
        JLabel facilities_title = new JLabel("              Facilities :");
        facilities_enterField.setPreferredSize(new Dimension(250, 25));
        facilities_enterField.setRows(2);
        info_entry_facilities.add(facilities_title);
        info_entry_facilities.add(facilities_enterField);

        JPanel info_entry_Condition = new JPanel();
        JLabel Condition_title = new JLabel("                 Condition :");
        Condition_enterField.setPreferredSize(new Dimension(250, 25));
        info_entry_Condition.add(Condition_title);
        info_entry_Condition.add(Condition_enterField);

        JPanel info_entry_rentalAskFor = new JPanel();
        JLabel rentalAskFor_title = new JLabel("Rental Asking For:");
        rentalAskFor_enterField.setPreferredSize(new Dimension(250, 25));
        rentalAskFor_enterField.setRows(2);
        info_entry_rentalAskFor.add(rentalAskFor_title);
        info_entry_rentalAskFor.add(rentalAskFor_enterField);

        JPanel info_entry_ContactNum = new JPanel();
        JLabel ContactNum_title = new JLabel("  Contact Number :");
        ContactNum_enterField.setPreferredSize(new Dimension(250, 25));
        info_entry_ContactNum.add(ContactNum_title);
        info_entry_ContactNum.add(ContactNum_enterField);

        JPanel info_entry_rentalFee = new JPanel();
        JLabel rentalFee_title = new JLabel("  Rental Fee (RM) :");
        rentalFee_enterField.setPreferredSize(new Dimension(250, 25));
        info_entry_rentalFee.add(rentalFee_title);
        info_entry_rentalFee.add(rentalFee_enterField);

        // Error Message Label
        error_message.setForeground(Color.RED);
        error_message.setHorizontalAlignment(JLabel.CENTER);

        info_entry.add(info_entry_propertyType);
        info_entry.add(info_entry_status);
        info_entry.add(info_entry_size);
        info_entry.add(info_entry_address);
        info_entry.add(info_entry_NumBathroom);
        info_entry.add(info_entry_NumRoom);
        info_entry.add(info_entry_Condition);
        info_entry.add(info_entry_facilities);
        info_entry.add(info_entry_rentalAskFor);
        info_entry.add(info_entry_ContactNum);
        info_entry.add(info_entry_rentalFee);
        info_entry.add(error_message);
        this.add(info_entry);

        // Button for Upload New Property Page
        JPanel button_panel = new JPanel();
        button_panel.add(back);
        button_panel.add(upload);

        this.add(button_panel);

    }
}
